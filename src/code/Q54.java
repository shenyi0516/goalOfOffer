package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/4/4 15:43
 */

import java.util.ArrayList;

/**
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 * 解题思路：二叉搜索树中序遍历即可得到一个排好序的数组。
 * 考虑到输出k大，所以遍历到数组长度为k的时候就可以停止了，返回下表为k-1的数。
 * java中的可变数组为ArrayList
 * 特殊情况：
 * 根节点为空。或者k超过节点数。k=0。
 */
public class Q54 {
    static public int kthLargest(TreeNode root, int k) {
        if(root == null || k==0)
            return -1;
        ArrayList<Integer> res = new ArrayList<>();
        GetRes(res,root,k);
        if (res.size()<k)
            return -1;
        else
            //注意是get第k大的数，所以序号为res.size()-k
            return res.get(res.size()-k);
    }

    static private void GetRes(ArrayList<Integer> res, TreeNode root,int k) {
        if (root != null){
            GetRes(res,root.left,k);
            res.add(root.val);
            GetRes(res,root.right, k);
        }
        if (res.size() == k)
            return;
    }

    public static void main(String[] args) {

    }
}
