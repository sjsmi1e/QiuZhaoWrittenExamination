package cvte;

/**
 * @author smi1e
 * Date 2019/9/11 21:00
 * Description
 */
class Test {
    static int a = 5;

    static {
        a += 10;
    }

    static {
        a /= 3;
    }

    public static void main(String[] args) {
        System.out.println(a);
    }

}
