package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/4/8 17:59
 */

import java.util.LinkedList;
import java.util.Stack;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 解题思路：
 * 1.递归遍历，每遍历到一个节点，判断该节点的子树中是否包含输入节点，根据情况选择向左子树遍历、右子树遍历、返回当前节点。
 * 2.遍历子树，保存路径，最后比较路径中的节点。
 */
public class Q68_2 {
    /**
     * 解法一，递归求得路径，然后比较
     * @param root 根节点
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null||p == null||q == null)
            return null;
        LinkedList<TreeNode> pathP = new LinkedList<>();
        LinkedList<TreeNode> pathQ = new LinkedList<>();
        if (GetPath(root,p,pathP)&&GetPath(root,q,pathQ))
            return GetLastCommonNode(pathP,pathQ);
        else
            return null;
    }
    public boolean GetPath(TreeNode root,TreeNode end,LinkedList<TreeNode> path){
        path.add(root);
        if (root == end)
            return true;
        boolean found = false;
        if (root.left!=null)
            found = GetPath(root.left,end,path);
        if (!found && root.right != null)
            found = GetPath(root.right,end,path);
        if (!found)
            path.removeLast();
        return found;
    }
    public TreeNode GetLastCommonNode(LinkedList<TreeNode> path1,LinkedList<TreeNode> path2){
        TreeNode common = null;
        while (!path1.isEmpty() && !path2.isEmpty()){
            if (path1.peek() == path2.peek())
                common = path1.pop();
            else
                path1.pop();
            path2.pop();
        }
        return common;
    }

    /**
     * 递归判断左子树和右子树中是否包含两个节点，直至两个节点分别在左右子树中。
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null||p == null||q == null)
            return null;
        if (root == q||root == p)
            return root;
        TreeNode left = lowestCommonAncestor2(root.left,p,q);
        TreeNode right = lowestCommonAncestor2(root.right,q,p);
        if (left == null)
            return right;
        if (right == null)
            return left;
        return root;
    }
}
