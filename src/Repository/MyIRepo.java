package Repository;

import Domain.ProgramState.PrgState;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by Live on 11/8/2015.
 */
public interface MyIRepo {

    public PrgState getCrtPrg();

    public void serializeProgState(PrgState p);

    public PrgState deserializeProgState();

    public List<PrgState> getPrgList();

    public void setPrgList(List<PrgState> p);

    public void ProgStateFile(PrgState p);
}
