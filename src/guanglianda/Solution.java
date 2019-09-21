package guanglianda;

import javafx.util.Pair;

import java.nio.channels.SocketChannel;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author smi1e
 * Date 2019/8/18 9:56
 * Description
 */
public class Solution {

    public int binCount(int num) {

        int res = 0;

        while (num != 0) {
            if ((num & 1) == 1) {
                res++;
            }
            num = num >> 1;
        }

        return res;

    }

    public boolean party(int[] Locations) {
        Arrays.sort(Locations);
        for (int i = 1; i < Locations.length; i++) {
            if (Locations[i] == Locations[i - 1]) {
                return false;
            }
        }

        return true;
    }

    public int oneCount(int[][] a) {
        int res = 0;
        int[][] visit = new int[a.length][a[0].length];
        int[][] dir = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
        Queue<Pair<Integer, Integer>> q = new LinkedBlockingDeque<>();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] == 1 && visit[i][j] == 0) {
                    q.offer(new Pair<>(i, j));
                    visit[i][j] = 1;
                    while (!q.isEmpty()) {
                        Pair<Integer, Integer> t = q.poll();
                        int x = t.getKey();
                        int y = t.getValue();
                        for (int k = 0; k < dir.length; k++) {
                            int tx = x + dir[k][0];
                            int ty = y + dir[k][1];
                            if (tx >= 0 && tx < a.length && ty >= 0 && ty < a[0].length && a[tx][ty] == 1 && visit[tx][ty] == 0) {
                                q.offer(new Pair<>(tx, ty));
                                visit[tx][ty] = 1;
                            }
                        }
                    }
                    res++;
                }
            }
        }
        return res;
    }

    public String get(String str,String Delimiter,int AIndex){
        String[] split = str.split(Delimiter);
        return split[AIndex];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        int[][] a = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                a[i][j] = in.nextInt();
            }
        }
        Solution solution = new Solution();
        System.out.println(solution.oneCount(a));
    }

}
