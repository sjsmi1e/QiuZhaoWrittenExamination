package JD.exam;

import javafx.util.Pair;

import java.net.SocketTimeoutException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author smi1e
 * Date 2019/8/20 14:34
 * Description
 */
public class Main {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        while (in.hasNext()) {

            int n = in.nextInt();
            List<Integer> list1 = new ArrayList<>(n);
            List<Integer> list2 = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                int t = in.nextInt();
                list1.add(t);
                list2.add(t);
            }

            Collections.sort(list1);

            ArrayList<Integer> tt = new ArrayList<>();
            int res = 0;
            int index = 0;
            for (int i = 0; i < n; i++) {
                Integer integer = list2.get(i);
                tt.add(integer);
                if (list1.get(index).compareTo(integer) == 0) {
                    Collections.sort(tt);
                    for (int j = 0; index < n && j < tt.size(); index++, j++) {
                        if (tt.get(j).compareTo(list1.get(index)) != 0) {
                            tt.clear();
                            res++;
                            break;
                        }
                        if ((tt.get(j).compareTo(list1.get(index)) == 0) && j == (tt.size() - 1)) {
                            tt.clear();
                            res++;
                        }
                    }
                }
            }
            System.out.println(res);
        }
    }
}
