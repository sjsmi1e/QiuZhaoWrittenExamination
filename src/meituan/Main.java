package meituan;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author smi1e
 * Date 2019/8/21 19:28
 * Description
 */
public class Main {
    private static Scanner in = new Scanner(System.in);

    public static void third(){
        while (in.hasNext()) {
            int n = in.nextInt();
            int k = in.nextInt();
            int ik = 0;
            int ikg = 0;
            int res = 0;
            int[] temp = new int[n];
            int ans = 0;
            for (int i = 0; i < n; i++) {
                int t = in.nextInt();
                if (t==1){
                    res++;
                }else {
                    if (k>0){
                        temp[ik++] = ++res;
                        k--;
                    }else {
                        res = res+1-temp[ikg++];
                    }
                }
                ans = res>ans?res:ans;
            }
            System.out.println(ans);
        }
    }

    public static void forth(){}

    public static void main(String[] args) {

        while (in.hasNext()){
            int n = in.nextInt();
            int first = in.nextInt();
            int second = first;
            int last = first;
            int now = first;
            int jian = first;
            for (int i = 1;i<n;i++){
                now = in.nextInt();
                if (now>last){
                    jian+=last;
                    last = now;
                }else if (now==last){
                    continue;
                }else {

                }
            }
        }
    }
}
