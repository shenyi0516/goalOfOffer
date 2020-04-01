package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/3/28 22:53
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.SplittableRandom;

/**
 * 实现两个函数，第一个函数把二叉树转化为字符串。
 * 第二个函数把字符串再转化为二叉树。
 * 如果单纯采用先序遍历，不能构筑出一个二叉树，所以先序遍历的同时需要把为空的节点也保存到字符串中。
 * 用层次遍历实现更加方便，空的节点用null字符代替。
 */
public class Q37 {
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder("[");
        serializeNode(root, stringBuilder);
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static void serializeNode(TreeNode root,StringBuilder stringBuilder){
        if(root == null){
            stringBuilder.append("null,");
            return;
        }
        stringBuilder.append(root.val).append(",");
        serializeNode(root.left,stringBuilder);
        serializeNode(root.right,stringBuilder);
    }
    // Decodes your encoded data to tree.
    static int i = 0;
    public static TreeNode deserialize(String data) {
        if (data.length()<2)
            return null;
        data = data.substring(1,data.length()-1);
        String[] vals = data.split(",");
        i = -1;
        return deserializeNode(vals);
    }
    public static TreeNode deserializeNode(String[] vals){
        i++;
        if(i < vals.length &&!vals[i].equals("null") ){
            TreeNode node = new TreeNode(Integer.valueOf(vals[i]));
            node.left = deserializeNode(vals);
            node.right = deserializeNode(vals);
            return node;
        }
        return null;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println(serialize(root));
        TreeNode node = deserialize(serialize(root));
        System.out.println(node.val);
    }
}
