package Repository;

import Domain.Expression.*;
import Domain.ProgramState.*;
import Domain.Statement.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Live on 11/8/2015.
 */

public class Repo implements MyIRepo {

    public List<PrgState> programs;

    public Repo() {

        programs = new ArrayList();

        MyIStack stack1 = new MyLibStack();
        MyIList list1 = new MyLibList();
        MyIDictionary dict1 = new MyLibDictionary();
        IHeap heap1 = new Heap<>();

        PrgState prog = new PrgState(stack1, dict1, list1, heap1,
                new CompStmt(
                        new AssignStmt("v", new ConstExp(-1)),
                        new CompStmt(
                                new WhileStmt(
                                        //new RelationalOp(new VarExp("v"), new ConstExp(3), 1),
                                        new ConstExp(3),
                                        new PrintStmt(new VarExp("v")),
                                        new AssignStmt("v", new ArithExp(new VarExp("v"), new ConstExp(1), 1))),

                                new CompStmt(
                                        new SleepStmt(5),
                                        new PrintStmt(new ArithExp(new VarExp("v"), new ConstExp(10), 3))))));


        programs.add(prog);
    }


    public PrgState getCrtPrg() {
        return programs.get(0);
    }

    public List<PrgState> getPrgList() {
        return programs;
    }

    public void setPrgList(List<PrgState> p) {
        programs = p;
    }


    public void serializeProgState(PrgState p) {
        try {
            File file = new File("C:/Users/Live/IdeaProjects/serProgState.txt");
            FileOutputStream fileOut = new FileOutputStream(file);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(p);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in C:/Users/Live/IdeaProjects/serProgState.txt");
        } catch (IOException i) {
            i.printStackTrace();
        }

    }

    public PrgState deserializeProgState() {
        PrgState p = new PrgState();
        try {
            File file = new File("C:/Users/Live/IdeaProjects/serProgState.txt");
            FileInputStream fileIn = new FileInputStream(file);
            try (ObjectInputStream ois = new ObjectInputStream(fileIn)) {
                p = (PrgState) ois.readObject();

            } catch (EOFException ignored) {
                // as expected
            } finally {
                fileIn.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw e;
        } catch (ClassNotFoundException c) {
            System.out.println("ToDo class not found");
            c.printStackTrace();
            throw c;
        } finally {
            return p;
        }

    }

    public void ProgStateFile(PrgState p) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("C:/Users/Live/IdeaProjects/FilePrgState.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        writer.print("state id : ");
        writer.println(p.id);

        writer.println("Stack: ");
        for (int i = p.exeStack.getLength() - 1; i >= 0; i--) {
            writer.print(p.exeStack.get(i).getClass().getName() + ": ");
            writer.print(((IStmt) p.exeStack.get(i)).toStr());
            writer.println();
        }
        writer.println();

        writer.println(" List:");
        for (int i = 0; i < p.out.size(); i++) {
            writer.print(p.out.get(i));
            writer.print(",");
        }
        writer.println();

        writer.println("Dictionary:");
        writer.println(p.symTable.toStr());


        writer.close();
    }

}
