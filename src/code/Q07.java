package code;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 采用递归的方式重建二叉树。
 * 第一次输入pre（先序）和in（中序）后，查找到in中pre[0]的位置i，pre[1:i+1]为左子树的先序遍历，in[0:i]左子树的中序遍历。
 *pre[i+1:length]为右子树的先序遍历，in[i+1,in.length]为右子树的中序遍历，当前根节点为pre[0]，以此递归，最后能重建二叉树。
 */
public class Q07{
    public static class TreeNode{
        int data;
        TreeNode leftTree;
        TreeNode rightTree;
        TreeNode(int data){
            this.data = data;
        }
    }

    public static TreeNode ConstructCore(int[] pre, int[] in){
        if(pre == null || in == null)
            return null;
        if (pre.length == 0 || in.length == 0)
            return null;
        if (pre.length != in.length)
            return null;
        TreeNode node = new TreeNode(pre[0]);
        for(int i = 0;i<pre.length;i++){
            if(pre[0] == in[i]){
                node.leftTree = ConstructCore(Arrays.copyOfRange(pre,1,i+1), Arrays.copyOfRange(in,0, i));
                node.rightTree = ConstructCore(Arrays.copyOfRange(pre,i+1,pre.length), Arrays.copyOfRange(in,i+1, in.length));
            }
        }
        return node;
    }

    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        TreeNode root = ConstructCore(pre,in);
        System.out.println("OK");
    }

}
