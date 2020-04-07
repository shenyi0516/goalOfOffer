package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/4/4 16:05
 */

import java.util.Map;

/**
 * 采用递归的方式。
 * 输入一棵二叉树的根节点，求该树的深度。
 * 从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 * 解题思路：1.采用dfs，当前节点的深度为max(left,right)+1
 * 2.采用层次遍历，每遍历一层，计数器+1
 */
public class Q55 {
    public int maxDepth(TreeNode root) {
        return DFS(root);
    }

    private int DFS(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(DFS(root.left),DFS(root.right))+1;
    }
}
