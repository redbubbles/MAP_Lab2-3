package Controller;

import Domain.Expression.Exp;
import Domain.ProgramState.*;
import Domain.Statement.*;
import Repository.MyIRepo;
import Repository.Repo;
import sun.font.ScriptRunData;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.lang.Runnable;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * Created by Live on 11/4/2015.
 */

public class Ctrl {
    public MyIRepo repo;

    public Ctrl(MyIRepo r) {
        repo = r;
    }

    public void allStep(PrgState state) {
        String s = "";
        PrgState prg = new Repo().getCrtPrg();
        while (!prg.getStk().isEmpty()) {
            prg.oneStep();
            s = s + prg.toStr();
        }

    }

    public List<Object> removeCompletedPrg(List<PrgState> inPrgList) {
        return inPrgList.stream()
                .filter(p -> p.isNotCompleted())
                .collect(Collectors.toList());
    }

    void oneStepForAllPrg(List<PrgState> prgList) throws InterruptedException {
        prgList.forEach(prg -> prg.toStr());

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        executorService.execute(new Runnable() {
            public void run() {
                System.out.println("Asynchronous task");
            }
        });

        //prepare the list of callables
        List<Callable<PrgState>> callList = prgList.stream()
                .map(p -> (Callable<PrgState>) (() -> {
                    return p.oneStep();
                }))
                .collect(Collectors.toList());


        //start the execution of the callables
        //it returns the list of new created threads
        List<PrgState> newPrgList =
                executorService.invokeAll(callList).stream()
                        .map(future -> {
                            try {
                                return future.get();
                            } catch (Exception e) {
                                //here you can treat the possible
                                // exceptions thrown by statements
                                // execution
                                throw new IllegalStateException(e);
                            }
                        })
                        .filter(p -> p != null)
                        .collect(Collectors.toList());
        //add the new created threads to the list of existing threads

        prgList.addAll(newPrgList);

    }
}


//-------------------------------------------------------
//old imoplementation
        /*
        // If the statement is an assign one


        if (crtStmt instanceof AssignStmt) {
            AssignStmt crtStmt1 = (AssignStmt) crtStmt;
            Exp exp = crtStmt1.exp;
            MyIDictionary symTbl = state.getSymTable();
            String id = crtStmt1.id;
            IHeap h = state.getHeap();
            Integer val = exp.eval(symTbl, h);

            if (symTbl.isDefined(id))
                symTbl.update(id, val);
            else {
                MyMap m = new MyMap(id, val);
                symTbl.add(m);

            }
            return;
        }


        // If the statement is an comp one

        if (crtStmt instanceof CompStmt) {
            CompStmt crtStmt1 = (CompStmt) crtStmt;
            stk.push(crtStmt1.snd);
            stk.push(crtStmt1.first);
            return;
        }


        if (crtStmt instanceof IfStmt) {
            IfStmt crtStmt1 = (IfStmt) crtStmt;
            Exp exp = crtStmt1.exp;
            IStmt thenStmt = ((IfStmt) crtStmt).thenS;
            IStmt elseStmt = ((IfStmt) crtStmt).elseS;
            if (exp.eval(state.getSymTable(), state.getHeap()) == 1)
                stk.push(thenStmt);
            else
                stk.push(elseStmt);
            return;
        }

        if (crtStmt instanceof WhileStmt) {
            WhileStmt crtStmt1 = (WhileStmt) crtStmt;
            Exp exp = crtStmt1.exp;
            IStmt[] s = crtStmt1.stmt;

            int k = exp.eval(state.getSymTable(), state.getHeap());

            while (k > 0) {
                for (int i = 0; i < s.length; i++) {
                    stk.push(s[i]);
                }
                k--;
            }
            return;
        }

        if (crtStmt instanceof PrintStmt) {
            PrintStmt crtStmt1 = (PrintStmt) crtStmt;
            Exp exp = crtStmt1.exp;
            list.add(exp.eval());
            return;
        }

        if (crtStmt instanceof New) {
            New crtStmt1 = (New) crtStmt;
            Exp exp = crtStmt1.exp;
            MyIDictionary symTbl = state.getSymTable();
            IHeap heap = state.getHeap();
            String v = crtStmt1.var;
            Integer index = heap.size();

            Integer val = exp.eval(symTbl, heap);

            if (symTbl.isDefined(v))
                symTbl.update(v, index);

            else {
                MyMap m = new MyMap(v, index);
                symTbl.add(m);
            }
            HMap h = new HMap(index, val);
            heap.add(h);

            return;
        }

        if (crtStmt instanceof wH) {
            wH crtStmt1 = (wH) crtStmt;
            MyIDictionary symTbl = state.getSymTable();
            String v = crtStmt1.var;
            Exp exp = crtStmt1.exp;
            IHeap heap = state.getHeap();
            int address = symTbl.lookup(v);
            try {
                HMap h = (HMap) heap.getElement(address);
                h.setA(address);
                h.setC(exp.eval(symTbl, heap));
            } catch (NoSuchElementException e) {
                return;
            }

        }
        //--------------------------------------------------------------
        //finish onestep
        */

