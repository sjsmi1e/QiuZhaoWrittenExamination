package langchao;

import java.util.Scanner;

/**
 * @author smi1e
 * Date 2019/9/7 14:25
 * Description
 */
public class Test {
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        int[] left = new int[51];
        int[] right = new int[51];
        left[0] = 1;
        right[0] = 1;
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int t = in.nextInt();
            if (t % 2 == 0) {
                right[t / 2] = 1;
            } else {
                left[(t - 1) / 2 + 1] = 1;
            }
        }
        int[] maxl = new int[2];
        int[] maxr = new int[2];
        int lindex = 0, rindex = 0;
        int tmaxl = 0, tmaxr = 0;
        for (int i = 1; i <= 50; i++) {
            if (left[i] == 0) {
                tmaxl++;
                if (left[i - 1] == 1) {
                    lindex = i;
                }
            } else {
                if (maxl[1] < tmaxl) {
                    maxl[1] = tmaxl;
                    maxl[0] = lindex;
                }
                tmaxl = 0;
            }
            if (right[i] == 0) {
                tmaxr++;
                if (right[i - 1] == 1) {
                    rindex = i;
                }
            } else {
                if (maxr[1] < tmaxr) {
                    maxr[1] = tmaxr;
                    maxr[0] = rindex;
                }
                tmaxr = 0;
            }
        }
        if (maxl[1] < tmaxl) {
            maxl[1] = tmaxl;
            maxl[0] = lindex;
        }
        if (maxr[1] < tmaxr) {
            maxr[1] = tmaxr;
            maxr[0] = rindex;
        }
        if (maxl[1] > maxr[1]) {
            System.out.println(maxl[0] * 2 - 1 + " " + maxl[1]);
        } else {
            System.out.println(maxr[0] * 2 + " " + maxr[1]);
        }
    }
}
