package kedaxunfei;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author smi1e
 * Date 2019/9/12 9:33
 * Description
 */
public class Main {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        while (in.hasNext()) {
            String next = in.next();
            StringBuffer stringBuffer = new StringBuffer();
            char t = next.charAt(0);
            char tn = '1';
            for (int i = 1; i < next.length(); i++) {
                if (t == next.charAt(i)) {
                    tn++;
                } else {
                    if (tn > '1') {
                        stringBuffer.append(tn);
                        stringBuffer.append(t);
                    } else {
                        stringBuffer.append(t);
                    }
                    t = next.charAt(i);
                    tn = '1';
                }
            }
            if (tn > '1') {
                stringBuffer.append(tn);
                stringBuffer.append(t);
            } else {
                stringBuffer.append(t);
            }
            System.out.println(stringBuffer.toString());
        }
    }
}
