
import java.util.*;

public class Main {

    public static void stockGod() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int index = 1;
            int pre = 1;
            int i = 1;
            int ti;
            while (i < n) {
                ti = index;
                while (ti != 0) {
                    i++;
                    pre++;
                    if (i >= n) {
                        break;
                    }
                    ti--;
                }
                if (i >= n) {
                    break;
                }
                i++;
                pre--;
                index++;
            }
            System.out.println(pre);

        }
    }

    public static void reverseINT() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            int first = 0;
            int second = n - 1;
            for (int i = 1; i < n; i++) {
                if (a[i - 1] > a[i]) {
                    first = i - 1;
                    while (i < n) {
                        if (a[i] > a[i - 1]) {
                            second = i - 1;
                            break;
                        }
                        i++;
                    }
                    break;
                }
            }
            if (second == n - 1 && first == 0) {
                System.out.println("yes");
            } else if (second == n - 1 && first != 0) {
                if (a[second] > a[first - 1]) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
            } else if (second != n - 1 && first == 0) {
                if (a[first] < a[second + 1]) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
            } else {
                if (a[first] < a[second + 1] && a[second] > a[first - 1]) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
            }

        }
    }

    public static void timo() {

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.next();
            String str2 = in.next();
            float len = str.length();
            int right = 0;
            for (int i = 0; i < len; i++) {
                char c = str.charAt(i);
                if (c >= 'a' && c <= 'z' || c >= '0' && c <= '9' || c >= 'A' && c <= 'Z') {
                    if (str2.charAt(i) == '1') {
                        right++;
                    }
                } else {
                    if (str2.charAt(i) == '0') {
                        right++;
                    }
                }
            }
            float res = right / len;
            System.out.println(String.format("%.2f%%", res * 100));
        }
    }

    public static void roadLight() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            double l = in.nextDouble();
            double[] a = new double[n];
            double res = 0;
            for (int i = 0; i < n; i++) {
                a[i] = in.nextDouble();
            }
            Arrays.sort(a);

            double t = a[0];
            if (t != 0) {
                res = t * 2;
            }
            for (int i = 0; i < n; i++) {
                double d = a[i] - t;
                t = a[i];
                res = res > d ? res : d;
            }
            res = res > (l - a[n - 1]) * 2 ? res : (l - a[n - 1]) * 2;
            System.out.println(String.format("%.2f", res / 2));
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            long a = in.nextLong();
            for (int i = 0; i < n; i++) {
                long t = in.nextLong();
                if (a >= t) {
                    a += t;
                } else {
                    a += Quick_GCD(a, t);
                }
            }
            System.out.println(a);

        }

    }

    private static long Quick_GCD(long a, long b) {
        if (a == 0) return b;
        if (b == 0) return a;
        if (!(a % 2 == 1) && !(b % 2 == 1)) {
            return Quick_GCD(a >> 1, b >> 1) << 1;
        } else if (!(b % 2 == 1)) {
            return Quick_GCD(a, b >> 1);
        } else if (!(a % 2 == 1)) {
            return Quick_GCD(a >> 1, b);
        } else {
            return Quick_GCD(Math.abs(a - b), Math.min(a, b));
        }
    }


}