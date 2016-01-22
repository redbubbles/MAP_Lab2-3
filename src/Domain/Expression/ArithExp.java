package Domain.Expression;

import Domain.ProgramState.IHeap;
import Domain.ProgramState.MyIDictionary;

import java.io.Console;

import Domain.Expression.Exp;
import Domain.Expression.ConstExp;
import Domain.Expression.VarExp;

/**
 * Created by Live on 11/4/2015.
 */

public class ArithExp extends Exp {
    public Exp e1;
    public Exp e2;
    public int op; //1 stands for +, 2 for -, etc. 3-*, 4->/


    public ArithExp(Exp e1, Exp e2, int op) {
        this.e1 = e1;
        this.e2 = e2;
        this.op = op;
    }

    public String toStr() {
        switch (op) {
            case 1:
                return e1.toStr() + " + " + e2.toStr();
            case 2:
                return e1.toStr() + " - " + e2.toStr();
            case 3:
                return e1.toStr() + " * " + e2.toStr();
            case 4:
                return e1.toStr() + " / " + e2.toStr();
            default:
                System.out.println("Invalid operation");
                break;
        }

        return " c ";

    }

    public int eval(MyIDictionary tbl, IHeap heap) {
        switch (op) {
            case 1:
                return (e1.eval(tbl, heap) + e2.eval(tbl, heap));
            case 2:
                return (e1.eval(tbl, heap) - e2.eval(tbl, heap));
            case 3:
                return (e1.eval(tbl, heap) * e2.eval(tbl, heap));
            case 4:
                if (e2.eval(tbl, heap) != 0) return (e1.eval(tbl, heap) / e2.eval(tbl, heap));
            default:
                System.out.println("Invalid operation");
                break;
        }
        return 0;
    }

}