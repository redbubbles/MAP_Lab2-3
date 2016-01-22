package Domain.ProgramState;

/**
 * Created by Live on 11/8/2015.
 */
public class MyMap {

    /**
     * fields
     */
    public static Integer val;
    public static String id;


    /**
     * Constructor
     */
    public MyMap(String inID, Integer inval) {
        id = inID;
        val = inval;
    }

    /**
     * data accesz
     */

    public String getID() {
        return id;
    }

    public Integer getVal() {
        return val;
    }

    public void setVal(Integer v) {
        val = v;
    }

    public void setId(String i) {
        id = i;
    }

    public String toStr() {
        return id + "->" + "" + val;

    }
}
