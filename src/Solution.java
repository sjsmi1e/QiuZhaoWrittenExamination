
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.junit.Test;

import java.util.*;

/**
 * Created by smi1e
 * Date 2019/6/14 12:06
 * Description
 */
public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        int len = array.length;
        for (int i = 0; i < len / 2; i++) {
            int a = sum - array[i];
            int i1 = Arrays.binarySearch(array, a);
            System.out.println("i1:" + i1);
            if (i1 < len && i1 >= 0) {
                res.add(array[i]);
                res.add(array[i1]);
            }

        }
        return res;
    }

    public String LeftRotateString(String str, int n) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str.substring(n));
        stringBuilder.append(str.substring(0, n - 1));
        return stringBuilder.toString();
    }

    public String ReverseSentence(String str) {
        if (str.length() == 0) {
            return "";
        }
        if (str.equals(" ")) {
            return "";
        }
        if (str.equals("")) {
            return "";
        }
        String[] s = str.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(s[s.length - 1]);
        for (int i = s.length - 2; i >= 0; i--) {
            stringBuilder.append(" " + s[i]);
        }
        return stringBuilder.toString();
    }

    public boolean isContinuous(int[] numbers) {
        Arrays.sort(numbers);
        int sum = 0;
        int i = 0;
        boolean res = true;
        for (; i < numbers.length; i++) {
            if (numbers[i] == 0)
                sum++;
            if (numbers[i] != 0)
                break;
        }
        if (i == 0) {
            i++;
        }
        for (; i < numbers.length; i++) {
            if (numbers[i] != numbers[i - 1] + 1 && numbers[i - 1] != 0) {
                int t1 = numbers[i];
                int t2 = numbers[i - 1];
                while (true) {
                    if (sum == 0) {
                        res = false;
                    }
                    if (sum != 0) {
                        sum--;
                        t2++;
                    }
                    if (t2 + 1 == t1) {
                        break;
                    }
                }

            }
        }
        return res;
    }

    public int LastRemaining_Solution(int n, int m) {
        if (n == 0 || m == 0) {
            return -1;
        }
        int[] childs = new int[n];
        //ArrayList<Integer> childs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            childs[i] = 1;
        }
        int len = n;
        int i = -1;
        while (true) {
            if (len == 1) {
                for (int j = 0; j < n; j++) {
                    if (childs[j] == 1) {
                        return j;
                    }
                }
            }
            int flag = 0;
            while (true) {
                if (flag == m) {
                    childs[i] = 0;
                    len--;
                    break;
                }
                i++;
                if (i >= n) {
                    i = i - n;
                }
                if (childs[i] == 1) {
                    flag++;
                }
            }

        }
    }

    //两数求和
    public int[] twoSum(Integer[] nums, int target) {
        HashMap<Integer, Integer> numMap = new HashMap<>();
        int[] ans = new int[nums.length];
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            numMap.put(nums[i], i);
            ans[i] = target - nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (numMap.get(ans[i]) != null && numMap.get(ans[i]) != i) {
                res[0] = i;
                res[1] = numMap.get(ans[i]);
                return res;
            }
        }
        return null;

    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean findTarget(TreeNode root, int k) {
//        HashMap<Integer,Integer> nums = new HashMap<>();
        List<Integer> nums = new LinkedList<>();
        TreeNode treeNode = root;
        goTree(root, nums);
        Integer[] objects = nums.toArray(new Integer[nums.size()]);
        Solution s = new Solution();
        if (s.twoSum(objects, k) != null) {
            return true;
        } else {
            return false;
        }
    }

    //先序遍历树
    void goTree(TreeNode treeNode, List nums) {
        if (treeNode == null) {
            return;
        }
        nums.add(treeNode.val);
        goTree(treeNode.left, nums);
        goTree(treeNode.right, nums);
    }

    public void test() {
        TreeNode treeNode1 = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(6);
        TreeNode treeNode4 = new TreeNode(2);
        TreeNode treeNode5 = new TreeNode(4);
        TreeNode treeNode6 = new TreeNode(7);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.right = treeNode6;
        Solution solution = new Solution();
        System.out.println(solution.findTarget(treeNode1, 9));
    }

    public int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            int pop = x % 10;
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;
            ans = ans * 10 + pop;
            x /= 10;
        }
        return ans;
    }

    /**
     * 单词拆分
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {

        int length = s.length();
        int[] dp = new int[length + 1];
        dp[0] = 1;
        if (wordDict.contains(s.substring(0, 1))) {
            dp[1] = 1;
        }
        for (int i = 2; i < dp.length; i++) {
            for (int j = 1; j <= i; j++) {
                if (wordDict.contains(s.substring(j - 1, i)) && dp[j - 1] == 1) {
                    dp[i] = 1;
                    break;
                }
            }
        }
//        for (int i = 0; i < dp.length; i++) {
//            System.out.print(dp[i] + " ");
//        }
//        System.out.println();
        if (dp[length] == 1) {
            return true;
        } else {
            return false;
        }
    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length <= 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[index]);
        int ind = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (preorder[index] == inorder[i]) {
                index++;
                ind = i;
                break;
            }
        }
        root.left = go(preorder, inorder, 0, ind - 1);
        root.right = go(preorder, inorder, ind + 1, preorder.length - 1);
        return root;
    }


    private static int index = 0;

    private TreeNode go(int[] pre, int[] inn, int l, int r) {
        if (l > r) {
            return null;
        }
        TreeNode root = new TreeNode(pre[index]);
        for (int i = l; i <= r; i++) {
            if (index >= pre.length) {
                break;
            }
            if (pre[index] == inn[i]) {
                index++;
                root.left = go(pre, inn, l, i - 1);
                root.right = go(pre, inn, i + 1, r);
                break;
            }
        }
        return root;
    }

    private void afterOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        afterOrder(root.left);
        afterOrder(root.right);
        System.out.print(root.val + " ");
    }

    public int distributeCandies(int[] candies) {
        Set<Integer> res = new HashSet<>();
        for (int i = 0; i < candies.length; i++) {
            int t = candies[i];
            if (!res.contains(t)) {
                res.add(t);
            }
        }
        int mid = candies.length / 2;
        int size = res.size();

        if (size <= mid) {
            return size;
        }
        return mid;
    }

    public int candy(int[] ratings) {

        int sum = 1;
        int last = 1;
        int[] first = {-1, 0};
        for (int i = 1; i < ratings.length; i++) {
            int t = ratings[i];
            if (t > ratings[i - 1]) {
                first[0] = -1;
                sum += ++last;
            } else if (t == ratings[i - 1]) {
                sum += 1;
                last = 1;
            } else {
                if (first[0] == -1) {
                    first[0] = i - 1;
                    first[1] = last;
                }
                if (last == 1) {
                    if (i - first[0] < first[1]) {
                        sum += i - first[0];
                    } else {
                        sum += i - first[0] + 1;
                    }
                } else {
                    sum += 1;
                    last = 1;
                }
            }
        }
        return sum;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 != null) {
            return l2;
        } else if (l1 != null && l2 == null) {
            return l1;
        }
        int jinwei = 0;
        if ((l1.val + l2.val) > 9) {
            jinwei = 1;
        }
        ListNode res = new ListNode((l1.val + l2.val) % 10);
        ListNode rres = res;
        for (l1 = l1.next, l2 = l2.next; l1 != null && l2 != null; l1 = l1.next, l2 = l2.next) {
            int l = l1.val;
            int r = l2.val;
            int ts = l + r + jinwei;
            if (ts > 9) {
                jinwei = 1;
            } else {
                jinwei = 0;
            }
            res.next = new ListNode(ts % 10);
            res = res.next;
        }
        while (l1 != null) {
            int ts = l1.val + jinwei;
            l1 = l1.next;
            if (ts > 9) {
                jinwei = 1;
            } else {
                jinwei = 0;
            }
            res.next = new ListNode(ts % 10);
            res = res.next;
        }
        while (l2 != null) {
            int ts = l2.val + jinwei;
            l2 = l2.next;
            if (ts > 9) {
                jinwei = 1;
            } else {
                jinwei = 0;
            }
            res.next = new ListNode(ts % 10);
            res = res.next;
        }
        if (jinwei == 1) {
            res.next = new ListNode(1);
            res = res.next;
        }
        return rres;
    }

//    public boolean isValid(String s) {
//        String kuohao = "()[]{}";
//        int[][] count = new int[3][1];
//        for (int i = 0; i < s.length(); i++) {
//            int tj = -1;
//            for (int j = 0; j < kuohao.length(); i++) {
//                if (kuohao.charAt(j) == s.charAt(i)) {
//                    tj = j;
//                }
//            }
//            if (tj % 2 == 0) {
//                count[tj/2][0]++;
//            }else {
//
//            }
//        }
//
//    }


    @Test
    public void test2() {
        ListNode l1 = new ListNode(5);
//        ListNode t1 = l1;
//        t1.next = new ListNode(4);
//        t1 = t1.next;
//        t1.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
//        ListNode t2 = l2;
//        t2.next = new ListNode(6);
//        t2 = t2.next;
//        t2.next = new ListNode(4);
        Solution solution = new Solution();
        ListNode listNode = solution.addTwoNumbers(l1, l2);
        for (; listNode != null; listNode = listNode.next) {
            System.out.println(listNode.val);
        }

    }

    public static void main(String[] args) {
        int[] a = {1, 3, 4, 3, 2, 1};
//        int[] pre = {-1};
//        int[] ord = {-1};
        Solution solution = new Solution();

//        System.out.println(solution.isValid("(([])[])"));
    }
}
