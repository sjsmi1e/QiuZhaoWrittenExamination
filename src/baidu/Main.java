package baidu;

import javafx.scene.transform.Scale;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author smi1e
 * Date 2019/9/10 18:57
 * Description
 */
public class Main {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[][] money = new int[n][2];
            for (int i = 0; i < n; i++) {
                money[i][0] = in.nextInt();
                money[i][1] = in.nextInt();
            }
            Arrays.sort(money, Comparator.comparingInt(o -> o[0]));
            int res = 0;
            int first = 0;
            for (int i = money.length - 1; i >= 0; i--) {
                if (money[i][0] >= m) {
                    res += money[i][1];
                } else {
                    if (i == first) {
                        if (money[i][1] * money[i][0] >= m) {
                            res += money[i][1] * money[i][0] / m;
                        }
                        break;
                    }
                    if (money[i][1] == 0) {
                        break;
                    }
                    int t = 1;
                    while (money[i][1] != 0) {
                        if (t > money[first][1]) {
                            t = 1;
                            first++;
                            continue;
                        }
                        if (money[i][0] + money[first][0] * t >= m) {
                            int min = Math.min(money[i][1], t);
                            money[i][1] -= min;
                            money[first][1] -= min;
                            res += min;
                        } else {
                            t++;
                            continue;
                        }
                        if (money[first][1] == 0) {
                            first++;
                            t = 1;
                        }
                    }
                    first = 0;
                }
            }
            System.out.println(res);

        }
    }
}
