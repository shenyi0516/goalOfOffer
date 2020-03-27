package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/3/27 17:36
 */

/**
 * 给出一颗二叉树，判断该二叉树是否为左右对称的二叉树。
 * 解题思路:如何判断二叉树是否为左右对称的二叉树？
 * 首先定义一种遍历方法：二叉树的对称先序遍历。
 * 先输出根节点，然后输出右节点，最后输出左节点。
 * 但是考虑到如果二叉树中存在多个相同的值，那么会导致不能分辨。
 * 那么需要在遍历的时候把null一并输出，判断整体是否相等。
 * 需要注意的地方:输入一个空二叉树、只有一个节点的二叉树、所有节点值都相同的二叉树。
 */
public class Q28 {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root,root);
    }

    private boolean isSymmetric(TreeNode root, TreeNode root1) {
        if(root == null && root1 == null)
            return true;
        if(root == null || root1 == null)
            return false;
        if(root.val != root1.val)
            return false;
        return isSymmetric(root.left,root1.right)&&isSymmetric(root.right,root1.left);
    }

}
