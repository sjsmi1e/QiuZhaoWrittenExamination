package yongyou;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String next = in.nextLine();
            String[] split = next.split(",");
            TreeNode treeNode = method1(split[0], split[1]);
            method3(treeNode);
            System.out.println();

        }
    }

    static class TreeNode{
        public char value;
        public TreeNode lNode;
        public TreeNode rNode;

        public TreeNode(char value, TreeNode lNode, TreeNode rNode) {
            this.value = value;
            this.lNode = lNode;
            this.rNode = rNode;
        }
    }

    //根据前序遍历fstr，和中序遍历mstr得到二叉树根节点
    public static TreeNode method1(String fStr,String mStr){
        TreeNode treeNode = new TreeNode(fStr.charAt(0),null,null);

        if(fStr.length()==1){
            return treeNode;
        }
        String[] strings = method2(fStr, mStr);
        if(strings[2] != null && strings[2].length() != 0){
            treeNode.lNode = method1(strings[0],strings[2]);
        }
        if(strings[3]!=null && strings[3].length() != 0){
            treeNode.rNode = method1(strings[1],strings[3]);
        }
        return treeNode;
    }

    //根据前序fstr，中序mstr得出该节点的左子树前序stirng[0],中序string[2],右子树前序string[1],中序string[3]
    public static String[] method2(String fStr,String mStr){

        String[] result = new String[4];
        if(fStr.length()==1){
            return result;
        }
        String[] middleSplit = new String[2];
        mStr.split(fStr.charAt(0)+"");
        middleSplit[0]=mStr.split(fStr.charAt(0)+"")[0];
        if (mStr.split(fStr.charAt(0)+"").length==1){
            middleSplit[1]="";
        }else {
            middleSplit[1] = mStr.split(fStr.charAt(0)+"")[1];
        }
        int middleLeftCount = middleSplit[0].length();
        String[] frontSplit = new String[2];
        frontSplit[0] = fStr.substring(1,middleLeftCount+1);
        frontSplit[1] = fStr.substring(middleLeftCount+1);
        result[0] = frontSplit[0];
        result[1] = frontSplit[1];
        result[2] = middleSplit[0];
        result[3] = middleSplit[1];
        return result;
    }
    public static void method3(TreeNode rootNode){
        if(rootNode.lNode!=null){
            method3(rootNode.lNode);
        }
        if(rootNode.rNode!= null){
            method3(rootNode.rNode);
        }
        System.out.print(rootNode.value);

    }
}