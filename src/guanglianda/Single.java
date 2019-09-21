package guanglianda;

/**
 * @author smi1e
 * Date 2019/8/18 9:59
 * Description
 */
public class Single {
    private Single INSTANCE = new Single();
    private Single(){}
    public Single getInstance(){
        return INSTANCE;
    }
}
