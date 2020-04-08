package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/4/8 17:37
 */

/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 解题思路：
 * 由于是二叉搜索树，可以利用二叉搜索树的特性。
 * 当遍历到一个节点的时候，
 * 如果两个节点的值都小于这个节点，则说明最低节点在左子树上
 * 如果都大于，这说明在右子树上。
 * 如果一个大于，一个小于，则说明该节点是最低公共节点。
 */
public class Q68 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null)
            return null;
        while (root != null){
            if (p.val < root.val && q.val < root.val)
                root = root.left;
            else if (p.val > root.val && q.val > root.val)
                root = root.right;
            else
                return root;
        }
        return null;
    }
}
