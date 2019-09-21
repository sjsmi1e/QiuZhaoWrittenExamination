import java.util.*;

import org.junit.Test;

/**
 * Created by smi1e
 * Date 2019/7/13 9:28
 * Description
 */
public class DP {

    /**
     * 最大子序列和
     * 以i结尾max（sum[i-1]+nums[i],nums[i]）
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans[i] = Math.max(ans[i - 1] + nums[i], nums[i]);
        }
        int res = ans[0];
        for (int i : ans) {
            res = res < i ? i : res;
        }
        return res;
    }


    /**
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * <p>
     * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
     * <p>
     * 注意你不能在买入股票前卖出股票。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [7,1,5,3,6,4]
     * 输出: 5
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int res;
//        int[] tprices = new int[prices.length];
//        for (int i = 0;i < prices.length;i++)
//            tprices[i] = -prices[i];
        res = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                res = prices[j] - prices[i] > res ? prices[j] - prices[i] : res;
            }
        }

        return res;
    }

    /**
     * 爬楼梯
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        return (int) (1 / Math.sqrt(5) * (Math.pow((1 + Math.sqrt(5)) / 2, n + 1) - Math.pow((1 - Math.sqrt(5)) / 2, n + 1)));
    }

    /**
     * 最大和（相邻两个不能相加）
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return nums[0] > nums[1] ? nums[0] : nums[1];
        }
        int[] res = new int[nums.length];
        res[0] = nums[0];
        res[1] = nums[0] < nums[1] ? nums[1] : nums[0];
        for (int i = 2; i < nums.length; i++) {
            res[i] = res[i - 2] + nums[i] > res[i - 1] ? res[i - 2] + nums[i] : res[i - 1];
        }
//        for (int i : res)
//            System.out.println(i+" ");
        int ans = 0;
        for (int i = 0; i < res.length; i++)
            ans = ans < res[i] ? res[i] : ans;
        return ans;
    }

    public int minCostClimbingStairs(int[] cost) {
        int[] tcost = new int[cost.length + 1];
        int[] dp = new int[cost.length + 1];
        int i = 0;
        for (; i < cost.length; i++) {
            tcost[i] = cost[i];
            dp[i] = cost[i];
        }
        tcost[i] = 0;
        dp[1] = tcost[1];
        for (i = 2; i < tcost.length; i++) {
            dp[i] = dp[i - 1] + tcost[i] > dp[i - 2] + tcost[i] ? dp[i - 2] + tcost[i] : dp[i - 1] + tcost[i];
        }
//        System.out.println(Arrays.toString(tcost));
//        for (int j:dp)
//            System.out.println(j);
        return dp[cost.length];
    }

    /**
     * 最长回文子串
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        int start = 0;
        int end = 0;
        String res = s.substring(start, end + 1);
        for (int r = 0; r < s.length(); r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(r) == s.charAt(l) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (end + 1 - start < r + 1 - l) {
                        end = r;
                        start = l;
                        res = s.substring(start, end + 1);
                    }
                }
            }
        }
//        for (boolean b[]:dp){
//            for (boolean o:b){
//                if (o)
//                    System.out.print("true ");
//                else
//                    System.out.print("false ");
//            }
//            System.out.println("");
//        }
        return res;
    }

    /**
     * leetcode不同路径1
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }
        return dp[m - 1][n - 1];
    }

    /**
     * leetcode不同路径2
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        boolean flag = false;
        for (int i = 0; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == 1) {
                flag = true;
            }
            if (flag)
                dp[i][0] = 0;
            else
                dp[i][0] = 1;
        }
        flag = false;
        for (int i = 0; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] == 1) {
                flag = true;
            }
            if (flag)
                dp[0][i] = 0;
            else
                dp[0][i] = 1;
        }
        for (int i = 1; i < obstacleGrid.length; i++)
            for (int j = 1; j < obstacleGrid[i].length; j++) {
                if (obstacleGrid[i][j] == 1)
                    dp[i][j] = 0;
                else if (obstacleGrid[i - 1][j] == 1 && obstacleGrid[i][j - 1] == 0)
                    dp[i][j] = dp[i][j - 1];
                else if (obstacleGrid[i - 1][j] == 0 && obstacleGrid[i][j - 1] == 1)
                    dp[i][j] = dp[i - 1][j];
                else if (obstacleGrid[i - 1][j] == 0 && obstacleGrid[i][j - 1] == 0)
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                else
                    dp[i][j] = 0;
            }
        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }


    /**
     * 最小路径和
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < grid[0].length; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < grid.length; i++)
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        return dp[grid.length - 1][grid[0].length - 1];
    }


    /**
     * 编码方式
     *
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        int a0 = Integer.valueOf(s.charAt(0) - '0');
        if (a0 != 0)
            dp[0]++;
        if (s.length() == 1)
            return dp[0];
        int a1 = Integer.valueOf(s.charAt(1) - '0');
        int a = Integer.valueOf(s.substring(0, 2));
        if (a1 != 0)
            dp[1]++;
        if (a > 0 && a <= 26 && a0 != 0)
            dp[1]++;
        if (a > 0 && a <= 26 && a0 == 0)
            dp[1] = dp[0];
        for (int i = 2; i < s.length(); i++) {
            a0 = Integer.valueOf(s.charAt(i - 1) - '0');
            a1 = Integer.valueOf(s.charAt(i) - '0');
            a = Integer.valueOf(s.substring(i - 1, i + 1));
            if (a1 != 0)
                dp[i] += dp[i - 1];
            if (a > 0 && a <= 26 && a0 != 0)
                dp[i] += dp[i - 2];
        }
        return dp[s.length() - 1];
    }

    /**
     * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++)
            for (int j = 1; j <= i; j++)
                dp[i] += dp[j - 1] * dp[i - j];

        return dp[n];
    }

    /**
     * 三角形最小路径和
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j == 0) {
                    triangle.get(i).set(j, triangle.get(i - 1).get(j) + triangle.get(i).get(j));
                } else if (j == triangle.get(i).size() - 1) {
                    triangle.get(i).set(j, triangle.get(i - 1).get(j - 1) + triangle.get(i).get(j));
                } else {
                    triangle.get(i).set(j, Math.min(triangle.get(i - 1).get(j), triangle.get(i - 1).get(j - 1)) + triangle.get(i).get(j));
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < triangle.get(triangle.size() - 1).size(); i++) {
            res = res < triangle.get(triangle.size() - 1).get(i) ? res : triangle.get(triangle.size() - 1).get(i);
        }
        return res;
    }

    /**
     * 单词拆分
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    /**
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int res = -Integer.MAX_VALUE;
        int min = 1, max = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                min = min ^ max;
                max = min ^ max;
                min = max ^ min;
            }
            max = max * nums[i] > nums[i] ? max * nums[i] : nums[i];
            min = min * nums[i] < nums[i] ? min * nums[i] : nums[i];
            res = max > res ? max : res;
        }
        return res;
    }

    /**
     * 打家劫舍2
     *
     * @param nums
     * @return
     */
    public int rob2(int[] nums) {
        int res1;
        int res2;
        int[] dp1 = new int[nums.length - 1];
        int[] dp2 = new int[nums.length - 1];
        for (int i = 0; i < nums.length - 1; i++) {
            dp1[i] = nums[i];
        }
        for (int i = 1; i < nums.length; i++) {
            dp2[i - 1] = nums[i];
        }

        return (res1 = rob(dp1)) > (res2 = rob(dp2)) ? res1 : res2;
    }

    public int maximalSquare(char[][] matrix) {
        int res = 0;
        if (matrix.length == 0) {
            return 0;
        }
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == '1') {
                res = dp[0][i] = 1;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == '1') {
                res = dp[i][0] = 1;
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    int t = -1;
                    t = dp[i][j - 1] < dp[i - 1][j] ? dp[i][j - 1] : dp[i - 1][j];
                    t = t < dp[i - 1][j - 1] ? t : dp[i - 1][j - 1];
                    dp[i][j] = t + 1;
                    res = dp[i][j] > res ? dp[i][j] : res;
                }

            }
        }

//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }
        return res * res;
    }


//    public int nthUglyNumber(int n) {
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        int[] a = {0, 0, 0, 0, 0, 0};
//        while (list.size() < n) {
//            int[] ints = minThree(2 * list.get(a[1]), 3 * list.get(a[2]), 5 * list.get(a[3]));
//            a[ints[0]]++;
//            if (list.get(list.size()-1) != ints[1]) {
//                list.add(ints[1]);
//            }
//        }
////        list.stream().forEach(System.out::print);
//        return list.get(n - 1);
//     }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = Integer.MAX_VALUE;
        List<Integer> s = new ArrayList<>();
        for (int i = 1; ; i++) {
            int t = i * i;
            if (t > n) {
                break;
            }
            if (t <= n) {
                s.add(t);
                dp[t] = 1;
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j : s) {
                if (j >= i) {
                    break;
                }
                if (dp[i] == 0) {
                    dp[i] = dp[i - j] + dp[j];
                }
                dp[i] = Math.min(dp[i - j] + dp[j], dp[i]);
            }
        }
//        System.out.println(Arrays.toString(dp));
        return dp[n];
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int res = 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            if (dp[i] == 0) {
                dp[i] = 1;
            }
            res = res > dp[i] ? res : dp[i];
        }
//        System.out.println(Arrays.toString(dp));
        return res;
    }


    class NumMatrix {
        private int[][] dp;

        public NumMatrix(int[][] matrix) {
            if (matrix.length == 0) {
                return;
            }
            dp = new int[matrix.length + 1][matrix[0].length + 1];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    dp[i + 1][j + 1] = dp[i][j + 1] + dp[i + 1][j] + matrix[i][j] - dp[i][j];
                }
            }
//            for (int i = 1; i <= matrix.length; i++) {
//                for (int j = 1; j <= matrix[0].length; j++) {
//                    System.out.print(dp[i][j] + " ");
//                }
//                System.out.println();
//            }

        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return dp[row2 + 1][col2 + 1] - dp[row2 + 1][col1] - dp[row1][col2 + 1] + dp[row1][col1];
        }
    }



    public static void main(String[] args) {
        DP dp = new DP();
        int[] b = {10, 9, 2, 5, 3, 7, 101, 18};
//        char[][] a = {
//                {'0', '0', '0', '1'},
//                {'1', '1', '0', '1'},
//                {'1', '1', '1', '1'},
//                {'0', '1', '1', '1'},
//                {'0', '1', '1', '1'}};

        System.out.println(dp.lengthOfLIS(b));
    }

    @Test
    public void test() {
        int[][] a = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        NumMatrix numMatrix = new NumMatrix(a);
        System.out.println(numMatrix.sumRegion(1, 2, 2, 4));
    }
}
