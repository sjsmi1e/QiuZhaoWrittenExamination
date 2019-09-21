package baidu.bb;

import java.util.Scanner;

/**
 * @author smi1e
 * Date 2019/9/10 18:57
 * Description
 */
public class Main {
    private static Scanner in = new Scanner(System.in);
    private static long res = 0;

    public static void main(String[] args) {
        while (in.hasNext()) {

            int n = in.nextInt();
            int k = in.nextInt();
            dfs(n, k);
            System.out.println(res);
            res = 0;
        }
    }

    private static void dfs(int n, int k) {
        int t = (n - k) % 2;
        if (t != 0 || n <= k) {
            res++;
            return;
        }
        dfs((n - k) / 2, k);
        dfs((n - k) / 2 + k, k);
    }
}
