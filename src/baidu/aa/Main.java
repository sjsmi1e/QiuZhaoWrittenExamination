package baidu.aa;

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
            for (int i = money.length - 1; i >= 0; i--) {
                if (money[i][0] >= m) {
                    res += money[i][1];
                } else {
                    int first = 0;
                    int ti = 1;
                    while (money[i][1] != 0) {
                        if (ti > money[i][1]) {
                            first++;
                            ti = 1;
                        }

                        int t = 1;
                        for (; ; ) {
                            if (t > money[first][1]) {
                                break;
                            } else {
                                if (money[first][0] * t + money[i][0] * ti >= m) {
                                    res += money[first][1] / t;
                                    money[first][1] -= (money[first][1] / t) * t;
                                    money[i][1] -= ti;
                                    break;
                                } else {
                                    t++;
                                }
                            }
                        }
                        ti++;
                    }
                    System.out.println(res);
                }
            }

        }
    }
}
