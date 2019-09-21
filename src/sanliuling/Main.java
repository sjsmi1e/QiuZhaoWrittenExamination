package sanliuling;

import java.math.BigInteger;
import java.net.SocketTimeoutException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author smi1e
 * Date 2019/8/5 10:06
 * Description
 */
public class Main {
    private static Scanner in = new Scanner(System.in);

    public static void huaban() {
        for (int t = in.nextInt(); t > 0; t--) {
            int sum = 0;
            for (int n = in.nextInt(); n > 0; n--) {
                int x1 = in.nextInt();
                int y1 = in.nextInt();
                int x2 = in.nextInt();
                int y2 = in.nextInt();
                sum += (x2 - x1 + 1) * (y2 - y1 + 1);
            }
            System.out.println(sum);
        }
    }

    public static void jiaoyi() {
        for (int t = in.nextInt(); t > 0; t--) {
            int sum = 0;
            for (int i = 0; i < 5; i++) {
                sum += in.nextInt();
            }
            if (sum % 5 == 0) {
                System.out.println(sum / 5 == 0 ? -1 : sum / 5);
            } else {
                System.out.println(-1);
            }
        }
    }

    public static void paidui() {
        for (int t = in.nextInt(); t > 0; t--) {
            long[] x = new long[3];
            long sum = 0;
            for (int i = 0; i < 3; i++) {
                x[i] = in.nextInt();
            }
            Arrays.sort(x);

            if ((x[0] + x[1]) * 2 < x[2]) {
                sum = x[0] + x[1];
            } else {
                sum = (x[0] + x[1] + x[2]) / 3;
            }
            System.out.println(sum);
        }
    }

    public static void Opecity() {
        int n = in.nextInt();
        long minx = Integer.MAX_VALUE;
        long miny = Integer.MAX_VALUE;
        long maxx = -Integer.MAX_VALUE;
        long maxy = -Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            long tx = in.nextLong();
            long ty = in.nextLong();
            minx = minx < tx ? minx : tx;
            miny = miny < ty ? miny : ty;
            maxx = maxx > tx ? maxx : tx;
            maxy = maxy > ty ? maxy : ty;
        }
        long x = maxx - minx;
        long y = maxy - miny;
        System.out.println(x > y ? x * x : y * y);
    }

    public static void quanSport() {
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
    }

    public static void bittttttts() {
        int q = in.nextInt();
        for (int i = 0; i < q; i++) {
            long k = in.nextLong();
            long l = in.nextLong();
            long r = in.nextLong();
            long s = 1;
            long res = 0;
            while (true) {
                s *= k;
                if (s - 1 >= l && s - 1 <= r) {
                    res = s - 1;
                }
                if (s - 1 > r) {
                    break;
                }
            }
            System.out.println(res);
        }
    }

    public static void passSyc() {
        while (in.hasNext()) {
            char[][] t = new char[3][3];
            for (int i = 0; i < 3; i++) {
                String str = in.next();
                for (int j = 0; j < 3; j++) {
                    t[i][j] = str.charAt(j);
                }
            }
            int[][] dir = {{0, 1}, {-1, 1}, {-1, 0}, {-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}};
            boolean flag = true;
            for (int i = 0; i < 4; i++) {
                if (t[1 + dir[i][0]][1 + dir[i][1]] != t[1 + dir[i + 4][0]][1 + dir[i + 4][1]]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

//            for (int i = 0; i < 3; i++) {
//                for (int j = 0; j < 3; j++) {
//                    System.out.print(t[i][j]);
//                }
//                System.out.println();
//            }
        }
    }

    public static void task() {
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            long[] task = new long[n];
            for (int i = 0; i < n; i++) {
                task[i] = in.nextLong();
            }
            Arrays.sort(task);
            for (int i = 0; i < m; i++) {
                long t = in.nextLong();
                int i1 = Arrays.binarySearch(task, t);
                if (i1 >= 0) {
                    boolean flag = false;
                    for (i1 = i1 + 1; i1 < n; i1++) {
                        if (task[i1] - task[i1 - 1] != 1) {
                            flag = true;
                            System.out.println(task[i1 - 1] + 1);
                            break;
                        }
                    }
                    if (!flag) {
                        System.out.println(task[n - 1] + 1);
                    }
                } else {
                    System.out.println(t);
                }
            }
        }
    }

    public static void viruses() {
        while (in.hasNext()) {
            long n = in.nextLong();
            long res = 0;
            int[] dp = new int[1000000000];
            for (long i = n; i >= 1; i--) {
                long temp = i;
                int a = 10;
                boolean flag = true;
                do {
                    long t = (i % a) / (a / 10);
                    if (t == 0 || t == 1) {
                        a *= 10;
                    } else {
                        flag = false;
                        break;
                    }
                } while ((temp = temp / 10) != 0);
                if (flag) {
                    res++;
                }
            }
            System.out.println(res);
        }
    }

    public static void theBrain() {

        while (in.hasNext()) {
            String string = in.next();
            String s1 = in.next();
            String s2 = in.next();
            boolean f1 = false;
            boolean f2 = false;
            int i1 = string.indexOf(s1);
            int i2 = string.lastIndexOf(s2);
            if (i1 < i2 && i1 != -1 && i2 != -1 && i2 >= i1 + s1.length()) {
                f1 = true;
            }

            StringBuffer stringBuffer = new StringBuffer();
            //倒转
            for (int i = string.length() - 1; i >= 0; i--) {
                stringBuffer.append(string.charAt(i));
            }
            String string2 = stringBuffer.toString();
            i1 = string2.indexOf(s1);
            i2 = string2.lastIndexOf(s2);
            if (i1 < i2 && i1 != -1 && i2 != -1 && i2 >= i1 + s1.length()) {
                f2 = true;
            }


            if (f1 && f2) {
                System.out.println("both");
            } else if (f1) {
                System.out.println("forward");
            } else if (f2) {
                System.out.println("backward");
            } else {
                System.out.println("invalid");
            }

        }
    }

    public static void isSubString(String s, String p, String q) {
        boolean isForward = false;
        boolean isBackward = false;

        String regex = "[\\w]*" + p + "[\\w]*" + q + "[\\w]*";

        if (s.matches(regex))
            isForward = true;

        if (new StringBuilder(s).reverse().toString().matches(regex))
            isBackward = true;

        if (isForward) {
            if (isBackward)
                System.out.println("both");
            else
                System.out.println("forward");
        } else {
            if (isBackward)
                System.out.println("backward");
            else
                System.out.println("invalid");
        }
    }

    public static void eMathematics() {
        while (in.hasNext()) {
            int n = in.nextInt();
            double sum = 0;
            for (int i = 0; i < n; i++) {
                sum += in.nextDouble() * in.nextDouble() / 100;
            }
            System.out.println(String.format("%.3f", sum));
        }
    }

    public static void dividetheGold() {
        int t = in.nextInt();
        for (int k = 1; k <= t; k++) {
            int n = in.nextInt();
            int[] a = new int[n + 1];
            int[][] dp = new int[n + 1][n + 1];
            for (int i = 1; i <= n; i++) {
                int temp = in.nextInt();
                a[i] += a[i - 1] + temp;
                dp[i][i] = temp;
            }

            for (int i = n - 1; i > 0; i--) {
                for (int j = i + 1; j <= n; j++) {
                    dp[i][j] = a[j] - a[i - 1] - Math.min(dp[i + 1][j], dp[i][j - 1]);
                }
            }
            System.out.println("Case #" + k + ": " + dp[1][n] + " " + (a[n] - dp[1][n]));
        }
    }

    public static void run() {
        while (in.hasNext()) {
            float l = in.nextFloat();
            float r = in.nextFloat();
            System.out.printf("%.3f %.3f\n", r * Math.cos(l / r), -r * Math.sin(l / r));
            System.out.printf("%.3f %.3f\n", r * Math.cos(l / r), r * Math.sin(l / r));
        }
    }


    public static void main(String[] args) {
        run();
    }


}
