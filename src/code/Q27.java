package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/3/27 17:22
 */

/**
 * 给出一个二叉树TreeA，返回TreeA的镜像二叉树TreeB。
 * 解题思路:画图可得，交换所有非叶节点的左右子树即可得到镜像二叉树。
 * 需要注意的地方：输入一个空的二叉树。
 */
public class Q27 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null)
            return root;
        if (root.left == null && root.right == null)
            return root;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        if(root.left != null)
            mirrorTree(root.left);
        if(root.right != null)
            mirrorTree(root.right);
        return root;
    }
}
