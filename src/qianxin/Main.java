package qianxin;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.*;

/**
 * @author smi1e
 * Date 2019/9/9 18:39
 * Description
 */
public class Main {
    private static Scanner in = new Scanner(System.in);
    static int res = 0;
    static Map<Integer, List<Integer>> map = new HashMap<>();

    public static void main(String[] args) {
        while (in.hasNext()) {
            String ts = "";
            while ("".equals(ts)) {
                ts = in.nextLine();
            }
            String[] s1 = ts.split(" ");
            ts = "";
            while ("".equals(ts)) {
                ts = in.nextLine();
            }
            String[] s2 = ts.split(" ");
            int[] s = new int[s1.length];
            for (int i = 0; i < s1.length; i++) {
                Integer t = Integer.valueOf(s1[i]);
                s[i] = t;
                ArrayList<Integer> tt = new ArrayList<>();
                map.put(t, tt);
            }
            for (int i = 0; i < s1.length; i++) {
                int t = Integer.valueOf(s2[i]);
                if (t == 0) {
                    continue;
                }
                List<Integer> list = map.get(t);
                list.add(s[i]);
            }
            ts = "";
            while ("".equals(ts)) {
                ts = in.nextLine();
            }
            int t = Integer.valueOf(ts);
            dfs(map.get(t));
            map.clear();
            System.out.println(res + 1);
            res = 0;
        }
    }

    private static void dfs(List<Integer> list) {
        if (list.size() == 0) {
            return;
        }
        res += list.size();
        list.forEach(x -> dfs(map.get(x)));
    }
}
