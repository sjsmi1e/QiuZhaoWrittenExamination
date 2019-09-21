package ali.ali2;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {
    static Scanner in = new Scanner(System.in);

/** 请完成下面这个函数，实现题目要求的功能 **/
    /**
     * 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^
     **/
    static String getIndexAndLongest(String users) {

        String str = users + users;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < users.length(); i++) {
            if (str.charAt(i) == 'b') {
                list.add(i);
            }
        }
        int temp = 0;
        for (int i = users.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == 'g') {
                temp++;
            } else {
                break;
            }
        }
        int res = list.get(1) - list.get(0) - 1 + temp;
        int index = 0;
        for (int i = 1; i < list.size() - 1; i++) {
            int t = list.get(i) - list.get(i - 1) - 1 + list.get(i + 1) - list.get(i) - 1;
            index = res >= t ? index : list.get(i);
            res = res > t ? res : t;
        }
        int t = 0;
        for (int i = list.get(list.size() - 1) + 1; i < str.length(); i++) {
            if (str.charAt(i) == 'g') {
                t++;
            } else {
                break;
            }
        }
        t = list.get(list.size() - 1) - list.get(list.size() - 2) - 1 + t;
        index = res >= t ? index : list.get(list.size() - 1);


        int g = in.nextInt();
        int tg = g;
        int ress = 0;
        int res2 = 0;
        Queue<Integer> girl = new PriorityQueue<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'b') {
                res2++;
            } else {
                girl.offer(i);
                tg--;
                if (tg < 0) {
                    int t1 = girl.poll();
                    int t2 = girl.peek();
                    res2 = res2 - (t2 - t1 - 1);
                    tg = g;
                    ress = Math.max(ress,res2);
                }
            }
        }


        return String.valueOf(index+" "+ress);

    }

    public static void main(String[] args) {

        String res;

        String _users;
        try {
            _users = in.nextLine();
        } catch (Exception e) {
            _users = null;
        }

        res = getIndexAndLongest(_users);
        System.out.println(res);
    }
}