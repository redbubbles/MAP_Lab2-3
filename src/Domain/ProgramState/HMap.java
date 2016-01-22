package Domain.ProgramState;

/**
 * Created by Live on 12/8/2015.
 */
public class HMap {
    public static Integer address;
    public static Integer content;


    public HMap(Integer address, Integer content) {
        this.address = address;
        this.content = content;
    }

    public Integer getA() {
        return address;
    }

    public Integer getC() {
        return content;
    }

    public void setC(Integer v) {
        content = v;
    }

    public void setA(Integer i) {
        address = i;
    }

    public String toStr() {
        return address + "->" + "" + content;

    }

}
