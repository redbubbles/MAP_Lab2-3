package View;

import Controller.Ctrl;
import Domain.Expression.ArithExp;
import Domain.Expression.ConstExp;
import Domain.Expression.RelationalOp;
import Domain.Expression.VarExp;
import Domain.Expression.rH;
import Domain.ProgramState.*;
import Domain.Statement.*;
import Repository.MyIRepo;
import Repository.Repo;

/**
 * Created by Live on 11/8/2015.
 */

public class Execution {
    public static void main(String[] args) {

        MyIRepo repo = new Repo();
        Ctrl cont = new Ctrl(repo);

        PrgState prog = repo.getCrtPrg();
        repo.serializeProgState(prog);
        prog = null;
        prog = repo.deserializeProgState();
        prog.toStr();
        cont.allStep(prog);

        repo.ProgStateFile(prog);


    }
}


