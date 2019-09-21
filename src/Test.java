import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by smi1e
 * Date 2019/7/12 15:55
 * Description
 */
public class Test {

    class inn {
    }

    class iinn extends inn {
    }

    class MyThread implements Runnable {

        @Override
        public void run() {
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new CopyOnWriteArrayList<>();
    }
}
