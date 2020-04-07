package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/4/4 16:38
 */

/**
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
 * 如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 * 解题思路：
 * 用后序计算出每个节点的深度，如果左右子树深度差超过1则返回false
 */
public class Q55_2 {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        return DFS(root) != -1;
    }
    public int DFS(TreeNode root){
        if (root == null)
            return 0;
        int left = DFS(root.left);
        int right = DFS(root.right);
        if (left == -1 || right == -1)
            return -1;
        else if (Math.abs(left - right) > 1)
            return -1;
        return Math.max(left,right)+1;
    }
}
