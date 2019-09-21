package meituan.formal;

import java.util.*;

/**
 * @author smi1e
 * Date 2019/8/22 14:31
 * Description
 */
public class Main {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        while (in.hasNext()) {
            String str = in.next();
            int[][] a = new int[26][3];
//            List<Map.Entry<Integer,Integer>>a = new ArrayList<>(26);
            Map<Character, Integer> map = new HashMap<>(26);
            map.put('A', 0);
            map.put('B', 1);
            map.put('C', 2);
            map.put('D', 3);
            map.put('E', 4);
            map.put('F', 5);
            map.put('G', 6);
            map.put('H', 7);
            map.put('I', 8);
            map.put('J', 9);
            map.put('K', 10);
            map.put('L', 10);
            map.put('M', 12);
            map.put('N', 13);
            map.put('O', 14);
            map.put('P', 15);
            map.put('Q', 16);
            map.put('R', 17);
            map.put('S', 18);
            map.put('T', 19);
            map.put('U', 20);
            map.put('V', 21);
            map.put('W', 22);
            map.put('X', 23);
            map.put('Y', 24);
            map.put('Z', 25);
            char first = str.charAt(0);
            a[map.get(first)][2] = 1;
            for (int i = 0; i < str.length(); i++) {
                char t = str.charAt(i);
                if (a[map.get(t)][0] == 0 && first != t) {
                    a[map.get(t)][0] = i;
                } else {
                    a[map.get(t)][1] = i;
                }
                a[map.get(t)][2] = 1;
            }
            Arrays.sort(a, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] == o2[0])
                        return o1[1] - o2[1];
                    return o1[0] - o2[0];
                }
            });

//            for (int i = 0; i < 26; i++) {
//                System.out.println(a[i][0] + " "+a[i][1] + " " + a[i][2]);
//            }


            int f1 = 0, f2 = 0;
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < 26; i++) {
                if (f1 <= a[i][0] && f2 >= a[i][0] && a[i][2] == 1) {
                    f2 = f2 > a[i][1] ? f2 : a[i][1];
                } else if (a[i][2] == 1) {
                    res.add(f2 - f1 + 1);
                    f1 = a[i][0];
                    f2 = a[i][1];
                    if (f1 > f2) {
                        f2 = f1;
                    }

                }
                if (i == 25) {
                    res.add(f2 - f1 + 1);
                }
            }
            for (int i = 0; i < res.size(); i++) {
                int out = res.get(i);
                if (out != 0) {
                    System.out.print(out + " ");
                }
            }
            System.out.println();
        }
    }
}
