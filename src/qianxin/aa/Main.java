package qianxin.aa;

import java.util.Scanner;

/**
 * @author smi1e
 * Date 2019/9/9 20:15
 * Description
 */
public class Main {
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        while (in.hasNext()) {
            int t = in.nextInt();
            int[] a = new int[(int) Math.pow(2, t) - 1];
            for (int i = 0; i < a.length; i++) {
                a[i] = in.nextInt();
            }
            int l = in.nextInt();
            int r = in.nextInt();
            boolean lflag = false;
            boolean rflag = false;
            for (int i = 0; i < a.length; i++) {
                if (a[i]==l){
                    lflag = true;
                }
            }
            for (int i = 0; i < a.length; i++) {
                if (a[i]==r){
                    rflag = true;
                }
            }
            if (lflag&&rflag){

                System.out.println(query(a, l, r));
            }else {

                System.out.println(-1);
            }
        }
    }


    public static int query(int[] a, int l, int r) {
        int left = l;
        int right = r;

        //二叉查找树内，如果左结点大于右结点，不对，交换
        if (left > right) {
            int temp = left;
            left = right;
            right = temp;
        }

        int index = 0;
        while (true) {
            //如果t小于u、v，往t的右子树中查找
            if (a[index] < left) {
                index = index * 2 + 2;
                //如果t大于u、v，往t的左子树中查找
            } else if (a[index] > right) {
                index = index * 2 + 1;
            } else {
                return a[index];
            }
        }
    }
}
