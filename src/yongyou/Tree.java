package yongyou;

/**
 * @author smi1e
 * Date 2019/8/31 19:56
 * Description
 */
public class Tree {
//    static class TreeNode {
//        TreeNode left;
//        TreeNode right;
//        int val;
//
//        public TreeNode(int val) {
//            this.val = val;
//        }
//    }
//
//    TreeNode go(int[] pre, int[] inn, int l, int r) {
//        if (l > r) {
//            return null;
//        }
//        TreeNode root = new TreeNode(pre[index]);
//        for (int i = l; i <= r; i++) {
//            if (index >= pre.length) {
//                break;
//            }
//            if (pre[index] == inn[i]) {
//                index++;
//                root.left = go(pre, inn, l, i - 1);
//                root.right = go(pre, inn, i + 1, r);
//                break;
//            }
//        }
//        return root;
//    }
//
//    void order(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//        System.out.print(root.val + " ");
//        order(root.left);
//        order(root.right);
//    }
//
//    void afterOrder(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//        afterOrder(root.left);
//        afterOrder(root.right);
//        System.out.print(root.val + " ");
//    }
//
//    static int index = 0;
//
//    public static void main(String[] args) {
//        int[] pre = {31, 29, 28, 30, 32, 33};
//        int[] ord = {28, 29, 30, 31, 32, 33};
//        Tree tree = new Tree();
//        TreeNode root = new TreeNode(pre[index]);
//        int ind = 0;
//        for (int i = 0; i < ord.length; i++) {
//            if (pre[index] == ord[i]) {
//                index++;
//                ind = i;
//                break;
//            }
//        }
//        root.left = tree.go(pre, ord, 0, ind - 1);
//        root.right = tree.go(pre, ord, ind + 1, pre.length - 1);
//
//        tree.afterOrder(root);
//        System.out.println();
//    }
}
