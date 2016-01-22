package Domain.Expression;

import Domain.ProgramState.IHeap;
import Domain.ProgramState.MyIDictionary;

/**
 * Created by Live on 11/27/2015.
 */
public class RelationalOp extends Exp {
    public Exp e1;
    public Exp e2;
    public int op;

    public RelationalOp(Exp e1, Exp e2, int op) {
        this.e1 = e1;
        this.e2 = e2;
        this.op = op;
    }

    public String toStr() {
        switch (op) {
            case 1:
                return "(" + e1.toStr() + " < " + e2.toStr() + ")";
            case 2:
                return "(" + e1.toStr() + " <= " + e2.toStr() + ")";
            case 3:
                return "(" + e1.toStr() + " == " + e2.toStr() + ")";
            case 4:
                return "(" + e1.toStr() + " != " + e2.toStr() + ")";
            case 5:
                return "(" + e1.toStr() + " > " + e2.toStr() + ")";
            case 6:
                return "(" + e1.toStr() + " >= " + e2.toStr() + ")";
            default:
                System.out.println("Invalid operation");
                break;
        }

        return "  ";

    }

    public int eval(MyIDictionary tbl, IHeap heap) {
        switch (op) {
            case 1:
                if (e1.eval(tbl, heap) < e2.eval(tbl, heap))
                    return 1;
                else
                    return 0;
            case 2:
                if (e1.eval(tbl, heap) <= e2.eval(tbl, heap))
                    return 1;
                else
                    return 0;
            case 3:
                if (e1.eval(tbl, heap) == e2.eval(tbl, heap))
                    return 1;
                else
                    return 0;
            case 4:
                if (e1.eval(tbl, heap) != e2.eval(tbl, heap))
                    return 1;
                else
                    return 0;

            case 5:
                if (e1.eval(tbl, heap) > e2.eval(tbl, heap))
                    return 1;
                else
                    return 0;
            case 6:
                if (e1.eval(tbl, heap) >= e2.eval(tbl, heap))
                    return 1;
                else
                    return 0;

            default:
                System.out.println("Invalid operation");
                break;
        }
        return 0;
    }

}
