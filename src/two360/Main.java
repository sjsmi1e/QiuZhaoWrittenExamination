package two360;

import java.util.*;

/**
 * @author smi1e
 * Date 2019/8/15 17:06
 * Description
 */
public class Main {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int res = 0;
            int sum = 0;
            int[] a = new int[n];
            for (int i = 0; i < m; i++) {
                int t = in.nextInt();
                a[i] = t;
                if (t >= n) {
                    res = 0;
                    break;
                }
                res = t > res ? t : res;
            }
            if (m == 2 && a[0] == a[1]) {
                if (a[0] + a[1] <= n - 1) {
                    res = (n - (a[0] + a[1])) * 2;
                    System.out.println(res > n ? n : res);
                    continue;
                } else {
                    System.out.println(0);
                    continue;
                }
            }
            if (res >= n - 1) {
                System.out.println(0);
                continue;
            }
            res = (n - res) * 2;
            System.out.println(res > n ? n : res);
        }
    }
}
