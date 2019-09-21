import org.junit.Test;

import javax.xml.stream.FactoryConfigurationError;
import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author smi1e
 * Date 2019/7/29 9:31
 * Description
 */
public class TreeAl {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {

        /**
         * 是否是相同的树
         *
         * @param p
         * @param q
         * @return
         */
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null) {
                return true;
            }
            if ((p != null && q == null) || (p == null && q != null) || (q.val != p.val)) {
                return false;
            }
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }


        /**
         * 是否是对称的树
         *
         * @param root
         * @return
         */
        public boolean isSymmetric(TreeNode root) {
            return go(root, root);
        }

        public boolean go(TreeNode tl, TreeNode tr) {
            if (tl == null && tr == null) {
                return true;
            }
            if ((tl != null && tr == null) || (tl == null && tr != null) || (tl.val != tr.val)) {
                return false;
            }
            return go(tl.left, tr.right) && go(tl.right, tr.left);
        }

        /**
         * 树的深度
         *
         * @param root
         * @return
         */
        public int maxDepth(TreeNode root) {
            return depth(0, root);
        }

        public int depth(int d, TreeNode r) {
            if (r == null) {
//                System.out.println(d);
                return d;
            }
            d++;
            int tl = depth(d, r.left);
            int tr = depth(d, r.right);
            d--;
            return tl > tr ? tl : tr;
        }

        /**
         * 二叉树的层次遍历 II
         *
         * @param root
         * @return
         */
        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            if (root == null) {
                return res;
            }
            levelOrderBottomGo(0, root);
            Collections.reverse(res);
            return res;
        }

        private void levelOrderBottomGo(int high, TreeNode t) {
            if (t == null) {
                return;
            }
            high++;
            if (res.size() < high) {
                res.add(new ArrayList<>());
            }
            res.get(high - 1).add(t.val);
            levelOrderBottomGo(high, t.left);
            levelOrderBottomGo(high, t.right);
            high--;
        }

        /**
         * 将有序数组转换为二叉搜索树
         *
         * @param nums
         * @return
         */
        public TreeNode sortedArrayToBST(int[] nums) {
            return changeToBST(nums, 0, nums.length - 1);
        }

        private TreeNode changeToBST(int[] nums, int start, int end) {
            if (start > end) {
                return null;
            }
            int mid = (start + end) / 2;
            TreeNode treeNode = new TreeNode(nums[mid]);
            treeNode.left = changeToBST(nums, start, mid - 1);
            treeNode.right = changeToBST(nums, mid + 1, end);
            return treeNode;
        }

        /**
         * 后序遍历
         */
        private void afterOrder(TreeNode t, List<TreeNode> order) {
            if (t == null) {
                return;
            }
            afterOrder(t.left, order);
            afterOrder(t.right, order);
            order.add(t);
        }

        /**
         * 是否是平衡二叉树
         *
         * @param root
         * @return
         */
        public boolean isBalanced(TreeNode root) {
            return depth(root) != -1;
        }

        private int depth(TreeNode root) {
            if (root == null) return 0;
            int left = depth(root.left);
            if (left == -1) return -1;
            int right = depth(root.right);
            if (right == -1) return -1;
            return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
        }

        /**
         * 二叉树最小深度
         *
         * @param root
         * @return
         */
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = minDepth(root.left) + 1;
            int right = minDepth(root.right) + 1;
            if (left == 1 || right == 1) {
                return left == 1 ? right : left;
            }
//            System.out.println(left+" "+right);
            return Math.min(left, right);
        }

        /**
         * 路径总和
         * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
         * <p>
         * 说明: 叶子节点是指没有子节点的节点
         *
         * @param root
         * @param sum
         * @return
         */
        public boolean hasPathSum(TreeNode root, int sum) {
            if (root == null) {
                return false;
            }
            if (sum == root.val && root.left == null && root.right == null) {
                return true;
            } else {
                sum -= root.val;
                return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
            }
        }

        /**
         * 翻转二叉树
         *
         * @param root
         * @return
         */
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            TreeNode res = new TreeNode(root.val);
            res.right = invertGo(root.left);
            res.left = invertGo(root.right);
            return res;
        }

        private TreeNode invertGo(TreeNode b) {
            if (b == null) {
                return null;
            }
            TreeNode t = new TreeNode(b.val);
            t.right = invertGo(b.left);
            t.left = invertGo(b.right);
            return t;
        }

        List<TreeNode> l = new ArrayList<>();

        /**
         * 先序遍历
         *
         * @param root
         */
        private void preOrder(TreeNode root) {
            if (root == null) {
                return;
            }
            l.add(root);
            preOrder(root.left);
            preOrder(root.right);
        }

        /**
         * 中序遍历
         *
         * @param root
         * @return
         */
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            midOrder(root, res);
            return res;
        }

        private void midOrder(TreeNode root, List<Integer> res) {
            if (root == null) {
                return;
            }
            midOrder(root.left, res);
            res.add(root.val);
            midOrder(root.right, res);
        }

        /**
         * 二叉搜索树的最近公共祖先
         * @param root
         * @param p
         * @param q
         * @return
         */
//        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//            List<TreeNode> list1 = new ArrayList<>();
//            List<TreeNode> list2 = new ArrayList<>();
//            preGo(root,list1,p);
//            preGo(root,list2,q);
//            TreeNode res = null;
//            for (int i = 0;i < Math.min(list1.size(),list2.size());i++){
////                System.out.println(list2.get(i).val);
//                if (list1.get(i)==list2.get(i)){
//                    res = list1.get(i);
//                }else {
//                    break;
//                }
//            }
//            return res;
//        }
//        private void preGo(TreeNode root,List<TreeNode> list,TreeNode p){
//            if (root==null){
//                return;
//            }
//            list.add(root);
//            if (root==p){
//                return;
//            }
//            if (root.val>p.val){
//                preGo(root.left,list,p);
//            }
//            if (root.val<p.val){
//                preGo(root.right,list,p);
//            }
//        }

        /**
         * 二叉树的最近公共祖先
         *
         * @param root
         * @param p
         * @param q
         * @return
         */
        TreeNode res1 = null;
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            dfs(root, p, q);
            return res1;
        }
        private int dfs(TreeNode root, TreeNode p, TreeNode q){
            if(root == null) {return 0;}
            int left = dfs(root.left, p, q);
            int right = dfs(root.right, p, q);
            int mid = root == p || root == q ? 1 : 0;
            if(left + right + mid > 1) {res1 = root;}
            return left + right + mid > 0 ? 1 : 0;
        }
//        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//            List<TreeNode> list1 = new ArrayList<>();
//            List<TreeNode> list2 = new ArrayList<>();
//            afterGo(root, list1, p);
//            f=false;
//            afterGo(root, list2, q);
//            int i1 = list1.indexOf(p);
//            int i2 = list2.indexOf(q);
//            boolean flag = list1.size() < list2.size() ? true : false;
////            list1.forEach((t)->{
////                System.out.println(t.val);
////            });
////            list2.forEach((t)->{
////                System.out.println(t.val);
////            });
//            if (flag) {
//                for (; i1 < list1.size(); i1++) {
//                    int t;
//                    if ((t = list2.indexOf(list1.get(i1))) != -1 && t > i2) {
//                        return list1.get(i1);
//                    }
//                }
//            } else {
//                for (; i2 < list2.size(); i2++) {
//                    int t;
//                    if ((t = list1.indexOf(list2.get(i2))) != -1 && t > i1) {
//                        return list2.get(i2);
//                    }
//                }
//            }
//            return null;
//        }
//        boolean f=false;
//        private void afterGo(TreeNode root, List<TreeNode> list, TreeNode t) {
//            if (root == null) {
//                return;
//            }
//            if (root == t) {
//                f=true;
//                list.add(root);
//                return;
//            }
//            if (!f){
//                afterGo(root.left, list, t);
//            }
//            if (!f){
//                afterGo(root.right, list, t);
//            }
//            list.add(root);
//        }

        /**
         *二叉树的所有路径
         */
        List<String> res2 = new ArrayList<>();
        public List<String> binaryTreePaths(TreeNode root) {
            if (root==null){
                return res2;
            }
            binaryTreePathsGo(root,new String());
            return res2;
        }
        private void binaryTreePathsGo(TreeNode root,String path){
            path+=root.val;
            if (root.left==null&&root.right==null){
                res2.add(path);
                return;
            }
            path+="->";
            if (root.left!=null){
                binaryTreePathsGo(root.left,path);
            }
            if (root.right!=null){
                binaryTreePathsGo(root.right,path);
            }
        }

        /**
         * 左叶子之和
         * @param root
         * @return
         */
        public int sumOfLeftLeaves(TreeNode root) {
            if (root==null){
                return 0;
            }
            return sumOfLeftLeavesGo(root,false,0);
        }
        private int sumOfLeftLeavesGo(TreeNode root,boolean flag,int sum){
            if (root.left==null&&root.right==null){
                if (flag){
                    sum+=root.val;
                }
                return sum;
            }
            if (root.left!=null && root.right!=null){
                return sumOfLeftLeavesGo(root.left,true,sum)+sumOfLeftLeavesGo(root.right,false,sum);
            }
            if (root.left!=null && root.right==null){
                return sumOfLeftLeavesGo(root.left,true,sum);
            }
            if (root.right!=null && root.left==null){
                return sumOfLeftLeavesGo(root.right,false,sum);
            }
            return 0;
        }


        /**
         * 二叉搜索树中的众数
         * @param root
         * @return
         */
        public int[] findMode(TreeNode root) {
            if (root==null){
                return new int[0];
            }
            HashMap<Integer,Integer> t = new HashMap<>();
            List<Integer> res = new ArrayList<>();
            findModeGo(root,t);
            List<Map.Entry<Integer, Integer>> collect = t.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).collect(Collectors.toList());
            int flag = 0;
//            collect.forEach((x)->{
//                System.out.println(x.getKey()+": "+x.getValue());
//            });
            for (int i = 0;i<collect.size();i++){
                if (collect.get(i).getValue()>=flag){
                    res.add(collect.get(i).getKey());
                    flag = collect.get(i).getValue();
                }else {
                    break;
                }
            }
            int[] res2 = new int[res.size()];
            for (int i = 0; i< res.size();i++){
                res2[i] = res.get(i);
            }
            return res2;
        }
        private void findModeGo(TreeNode root,Map<Integer,Integer> t){
            if (root==null){
                return;
            }
            Integer tt;
            if ((tt=t.get(root.val))==null){
                t.put(root.val,1);
            }else {
                t.replace(root.val,tt+1);
            }
            findModeGo(root.left,t);
            findModeGo(root.right,t);

        }
        /**
         * 提莫攻击
         * @param timeSeries
         * @param duration
         * @return
         */
        public int findPoisonedDuration(int[] timeSeries, int duration) {

            if (timeSeries.length==0){
                return 0;
            }
            if (timeSeries.length==1){
                return duration;
            }
            Arrays.sort(timeSeries);
            int sum = 0,j=timeSeries[0];
            for (int i = 1;i < timeSeries.length;i++){
                if (timeSeries[i-1]+duration-1-timeSeries[i]<0){
                    sum+=timeSeries[i-1]+duration-1-j+1;
                    j=timeSeries[i];
                }
                if (i==timeSeries.length-1){
                    sum+=timeSeries[i]+duration-1-j+1;
                }
            }
            return sum;
        }

    }




    @Test
    public void test() {
        Solution solution = new Solution();
        TreeNode p = new TreeNode(6);
        p.left = new TreeNode(2);
//        TreeNode t2 = p.left = new TreeNode(5);
        p.left.left = new TreeNode(0);
        p.left.right = new TreeNode(4);
        p.left.right.left = new TreeNode(2);
        p.left.right.right = new TreeNode(6);
////
        p.right = new TreeNode(8);
        p.right.left = new TreeNode(7);
        p.right.right = new TreeNode(9);
//        p.right.right.right = new TreeNode(1);
//        TreeNode treeNode = solution.invertTree(p);
//        solution.preOrder(treeNode);
//
//        TreeNode q = new TreeNode(1);
//        q.left = new TreeNode(1);
//        q.right = new TreeNode(2);
//        List<List<Integer>> res = solution.levelOrderBottom(p);
        int[] a= {1,4};
//        TreeNode treeNode = solution.sortedArrayToBST(a);
//        List<TreeNode> res = new ArrayList<>();
//        solution.afterOrder(treeNode,res);
//        List<Integer> res = solution.inorderTraversal(p);;
//        for (Integer r : res) {
//            System.out.print(r + " ");
//        }
//        solution.binaryTreePaths(p);
//        solution.res2.forEach((x)->{
//            System.out.println(x);
//        });
        System.out.println( Arrays.toString( solution.findMode(p)));
    }
}
