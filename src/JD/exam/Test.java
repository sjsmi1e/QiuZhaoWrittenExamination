package JD.exam;

import java.util.Scanner;

/**
 * @author smi1e
 * Date 2019/8/24 21:47
 * Description
 */
public class Test {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < n; i++) {
            stringBuffer.append(".");
        }
        String next = in.next(stringBuffer.toString());
        System.out.println(next);
    }
}
