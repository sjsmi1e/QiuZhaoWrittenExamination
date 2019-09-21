package baidu.cc;

import java.util.*;

/**
 * @author smi1e
 * Date 2019/9/10 20:19
 * Description
 */
public class Main {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        while (in.hasNext()) {
            int n = in.nextInt();
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < n - 1; i++) {
                int t1 = in.nextInt();
                int t2 = in.nextInt();
                if (t1 > t2) {
                    int temp = t1;
                    t1 = t2;
                    t2 = temp;
                }
                List<Integer> list = map.get(t1);
                if (list == null) {
                    ArrayList<Integer> tlist = new ArrayList<>();
                    tlist.add(t2);
                    map.put(t1, tlist);
                } else {
                    map.get(t1).add(t2);
                }
            }
            int[] res = new int[map.size()];
            map.entrySet().stream().sorted();
        }
    }
}
