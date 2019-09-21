package qianxin;

/**
 * @author smi1e
 * Date 2019/9/9 18:40
 * Description
 */
public class Test {
    class t1{
        public void go(){
            System.out.println("t1");
        }
    }
    class t2 extends t1{
        @Override
        public void go(){
            System.out.println("t2");
        }
    }

    @org.junit.Test
    public void test(){
        t1 t = new t2();
        t.go();
    }
}
