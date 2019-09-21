package offer;

import java.util.*;

/**
 * @author smi1e
 * Date 2019/8/23 10:52
 * Description
 */
public class Solution {
    public int StrToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] chars = str.toCharArray();
        List<Integer> res = new ArrayList<>();
        boolean zheng = true;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                continue;
            }
            if (chars[i] >= '0' && chars[i] <= '9') {
                res.add(chars[i] - '0');
            } else if (chars[i] == '-') {
                zheng = false;
            } else if (chars[i] == '+') {
                zheng = true;
            } else {
                return 0;
            }
        }
        int ans = 0, index = 1;
        for (int j = res.size() - 1; j >= 0; j--) {
            ans += index * res.get(j);
            index *= 10;
        }
        if (!zheng) {
            return -ans;
        }
        return ans;
    }

    public boolean duplicate(int numbers[], int length, int[] duplication) {
        duplication[0] = -1;
        if (length == 0) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int number : numbers) {
            if (set.contains(number)) {
                duplication[0] = number;
                break;
            } else {
                set.add(number);
            }
        }
        if (duplication[0] != -1) {
            return true;
        }
        return false;
    }

    public int[] multiply(int[] A) {
        int[] res = new int[A.length];
        int a = 1;
        int zeroFlag = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != 0) {
                a = a * A[i];
            } else {
                zeroFlag++;
                if (zeroFlag == 2) {
                    a = 0;
                    break;
                }
            }
        }
        if (a == 0) {
            for (int i = 0; i < A.length; i++) {
                res[i] = a;
            }
        } else {
            if (zeroFlag != 0) {
                for (int i = 0; i < A.length; i++) {
                    if (A[i] == 0) {
                        res[i] = a;
                    } else {
                        res[i] = 0;
                    }
                }
            } else {
                for (int i = 0; i < A.length; i++) {
                    res[i] = div(a, A[i]);
                }
            }

        }
        return res;
    }

    private int div(int dividend, int divisor) {
        //false为负数
        long a = dividend;
        long b = divisor;
        boolean flag = true;
        if ((a < 0 && b > 0) || (a > 0 && b < 0)) {
            flag = false;
        }

        a = Math.abs(a);

        b = Math.abs(b);
        long res = 0;
        long cot = 1;
        while (a >= b) {
            cot = cot << 1;
            b = b << 1;
        }
        while (b > 0 && a > 0) {
            b = b >> 1;
            cot = cot >> 1;
            if (a >= b) {
                a -= b;
                res += cot;
            }
        }
        if (!flag) {
            res = -res;
        }
        if (res >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (res <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) res;
    }

    public int Add(int num1, int num2) {
        while (num2 != 0) {
            int temp = num1 ^ num2;
            num2 = (num1 & num2) << 1;
            num1 = temp;
        }
        return num1;
    }

    public boolean match(char[] str, char[] pattern) {
        String s = String.valueOf(str);
        String p = String.valueOf(pattern);
        return s.matches(p);
    }

    public boolean isNumeric(char[] str) {
        String s = String.valueOf(str);
        if (s.matches("^(\\-|\\+)?(\\.)?\\d+(\\.\\d+)?$")) {
            return true;
        } else {
            return s.matches("^(\\-|\\+)?(\\.)?\\d+(\\.\\d+)?([eE](\\-|\\+)?\\d+)?");
        }
    }

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        Set<ListNode> set = new HashSet<>();
        for (ListNode i = pHead; i.next != null; i = i.next) {
            if (set.contains(i)) {
                return i;
            } else {
                set.add(i);
            }
        }
        return null;
    }

    class Node {
        int x;
        int y;
        int index;

        public Node(int x, int y, int index) {
            this.x = x;
            this.y = y;
            this.index = index;
        }
    }

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        char[][] m = new char[rows][cols];
        int[][] v = new int[rows][cols];
        int index = 0;
        List<Node> first = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[index] == str[0]) {
                    first.add(new Node(i, j, 0));
                }
                m[i][j] = matrix[index++];
            }
        }
        for (int i = 0; i < first.size(); i++) {
            Node node = first.get(i);
            v[node.x][node.y] = 1;
            if (dfs(node.x, node.y, node.index, str, m, rows, cols, v)) {
                return true;
            } else {
                v[node.x][node.y] = 0;
            }
        }
        return false;
    }

    private boolean dfs(int x, int y, int n, char[] str, char[][] m, int rows, int cols, int[][] v) {
        if (n == str.length - 1) {
            return true;
        }
        int[][] dir = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
        for (int j = 0; j < dir.length; j++) {
            int tx = x + dir[j][0];
            int ty = y + dir[j][1];
            if (tx >= 0 && tx < rows && ty >= 0 && ty < cols && m[tx][ty] == str[n + 1] && v[tx][ty] == 0) {
                v[tx][ty] = 1;
                if (dfs(tx, ty, n + 1, str, m, rows, cols, v)) {
                    return true;
                }
                v[tx][ty] = 0;
            }
        }
        return false;
    }

    public String ReverseSentence(String str) {
        String[] s = str.split(" ");
        if (s.length == 0) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = s.length - 1; i >= 0; i--) {
            if (i == 0) {
                stringBuffer.append(s[i]);
                break;
            }
            stringBuffer.append(s[i] + " ");
        }
        return stringBuffer.toString();
    }

    public int movingCount(int threshold, int rows, int cols) {

        boolean v[][] = new boolean[rows][cols];
        return dfs(threshold, 0, 0, rows, cols, v);
    }

    private int dfs(int threshold, int row, int col, int rows, int cols, boolean[][] v) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || v[row][col] || threshold < getSum(row, col)) {
            return 0;
        }
        v[row][col] = true;
        return 1 + dfs(threshold, row, col + 1, rows, cols, v) + dfs(threshold, row - 1, col, rows, cols, v) +
                dfs(threshold, row, col - 1, rows, cols, v) + dfs(threshold, row + 1, col, rows, cols, v);
    }

    private int getSum(int row, int col) {
        int res = 0;
        while (row != 0) {
            res += row % 10;
            row /= 10;
        }
        while (col != 0) {
            res += col % 10;
            col /= 10;
        }
        return res;
    }

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        if (size == 0 || size > num.length) {
            return new ArrayList<>();
        }
        ArrayList<Integer> res = new ArrayList<>();
        int i = 0;
        int index = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(3, (o1, o2) -> o2 - o1);
        for (; i < size; i++) {
            queue.offer(num[i]);
        }
        res.add(queue.peek());
        for (; i < num.length; i++) {
            queue.remove(num[index++]);
            queue.offer(num[i]);
            res.add(queue.peek());
        }
        return res;

    }

    private int res = 0;

    public int InversePairs(int[] array) {
        sort(0, array.length - 1, array);
        return res;
    }

    private void sort(int l, int r, int[] array) {
        if (l < r) {
            int mid = (l + r) >> 1;
            sort(l, mid, array);
            sort(mid + 1, r, array);
            merge(l, r, mid, array);
        }
    }

    private void merge(int l, int r, int mid, int[] array) {
        int left = l, right = mid + 1;
        int[] t = new int[r - l + 1];
        int index = 0;
        while (left <= mid && right <= r) {
            if (array[left] <= array[right]) {
                t[index++] = array[left++];
            } else {
                res = (res + (mid - left + 1)) % 1000000007;
                t[index++] = array[right++];
            }
        }
        while (left <= mid) {
            t[index++] = array[left++];
        }
        while (right <= r) {
            t[index++] = array[right++];
        }
        for (int i = 0; i < t.length; i++) {
            array[l++] = t[i];
        }
    }

    public double Power(double base, int exponent) {

        return Math.pow(base, exponent);
    }

    public int GetUglyNumber_Solution(int index) {
        if (index==0){
            return 0;
        }
        ArrayList<Integer> list = new ArrayList<>(index);
        list.add(1);
        int i2=0,i3=0,i5=0;
        while (list.size()<=index){
            int t1 = list.get(i2)*2;
            int t2 = list.get(i3)*3;
            int t3 = list.get(i5)*5;
            int min;
            if (t1<t2){
                if (t1<t3){
                    min = t1;
                    i2++;
                }else {
                    min = t3;
                    i5++;
                }
            }else {
                if (t2<t3){
                    min = t2;
                    i3++;
                }else {
                    min = t3;
                    i5++;
                }
            }
            if (list.get(list.size()-1)==min){
                continue;
            }
            list.add(min);
        }
        return list.get(index-1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = {1, 2, 3, 4, 5, 6, 7, 0};
        System.out.println(solution.GetUglyNumber_Solution(8));
    }
}