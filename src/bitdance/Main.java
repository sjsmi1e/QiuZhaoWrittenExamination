package bitdance;

import java.util.*;

public class Main {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int[] pre = new int[n];
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                pre[i] = i;
                a[i] = in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                if (a[i] == 0 || a[i] == 1) {
                    continue;
                }
                for (int j = i + 1; j < n; j++) {
                    if (a[j] == 0 || a[j] == 1) {
                        continue;
                    }
                    if (Quick_GCD(a[i], a[j]) > 1) {
                        join(j, i, pre);
                        a[j] = 0;
                    }
                }
            }
            class mycom implements Comparator {

                Map<Integer, Integer> base;

                public mycom(Map<Integer, Integer> base) {
                    this.base = base;
                }

                @Override
                public int compare(Object o1, Object o2) {
                    return base.get(o1).compareTo(base.get(o2));
                }
            }

            TreeMap<Integer, Integer> map = new TreeMap<>();

            int t = 0;
            for (int i = 0; i < n; i++) {
                if (map.containsKey(pre[i])) {
                    map.replace(pre[i], map.get(pre[i]) + 1);
                } else {
                    map.put(pre[i], 1);
                }
//                System.out.println(pre[i]);
            }
//            System.out.println();
            Integer res = map.lastKey();
            System.out.println(res);
        }
    }

    private static int Quick_GCD(int a, int b) {
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

    public void first() {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int[] pre = new int[n];
            for (int i = 0; i < n; i++) {
                pre[i] = i;
            }
//            int res = 0;
            int[][] m = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    m[i][j] = in.nextInt();
                }
            }

//            ArrayList<ArrayList<Integer>> res = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (m[i][j] >= 3) {
                        join(i, j, pre);
                    }
                }
            }

            int res = 0;
            for (int i = 0; i < n; i++) {
                if (pre[i] == i) {
                    res++;
                }
            }
            System.out.println(res);
        }
    }

    private static int find(int x, int[] pre) {
        int r = x;
        while (pre[r] != r)
            r = pre[r];
        int i = x, j;
        while (r != i) {
            j = pre[i];
            pre[i] = r;
            i = j;
        }
        return r;
    }

    private static void join(int x, int y, int[] pre) {
        int tx = find(x, pre);
        int ty = find(y, pre);
        if (tx != ty) ;
        pre[tx] = ty;
    }


}