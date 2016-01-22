package Domain.Statement;

import Domain.ProgramState.PrgState;

import java.io.Serializable;

/**
 * Created by Live on 11/4/2015.
 */
public interface IStmt extends Serializable {
    String toStr();

    PrgState execute(PrgState state);
}
