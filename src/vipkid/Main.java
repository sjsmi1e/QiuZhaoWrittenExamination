package vipkid;

import java.util.*;

/**
 * @author smi1e
 * Date 2019/9/3 16:47
 * Description
 */
public class Main {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        while (in.hasNext()) {
            String next = in.nextLine();
            String[] split = next.split(",");
            Set<Integer> res = new HashSet<>();
            int[] a = new int[split.length];
            for (int i = 0; i < split.length; i++) {
                a[i] = Integer.valueOf(split[i].trim());
            }
            Arrays.sort(a);
//            for (int i = 0; i < a.length; i++) {
//                System.out.println(a[i]);
//            }
            int sum = 0;
            int zero = 0;
            for (int i = 0; i < a.length; i++) {
                if (a[i] > 0) {
                    break;
                } else if (a[i] == 0) {
                    zero++;
                } else {
                    int i1 = Arrays.binarySearch(a, -a[i]);
                    if (i1 > 0 && !res.contains(i1)) {
                        res.add(i1);
                        sum++;
                    }
                }
            }
            sum += zero / 2;
            System.out.println(sum);
        }
    }
}
