package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/3/28 19:57
 */

import java.util.LinkedList;
import java.util.List;

/**
 * 给出一颗二叉树和一个整数，打印出所有和为整数的路径。
 * 解题思路：
 * 用递归的方式先序遍历这个二叉树上的所有节点，同时把路径保存在一个列表中。
 * 当向上回溯的时候，弹出最后面一个元素，
 * 访问到叶节点的时候判断栈中的路径和是否等于给出的整数，
 * 是的话就把列表保存到返回结果中。
 * 需要注意的地方:
 * 输入根节点为空
 */
public class Q34 {
    LinkedList<Integer> path = new LinkedList<>();
    LinkedList<List<Integer>> result = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null)
            return result;
        FindPath(root,sum);
        return result;
    }

    private void FindPath(TreeNode root, int sum) {
        if (root == null)
            return;;
        path.add(root.val);
        sum -= root.val;
        if(sum == 0 && root.left == null && root.right == null)
            result.add(new LinkedList<>(path));
        FindPath(root.left, sum);
        FindPath(root.right, sum);
        path.removeLast();//回溯的时候删除自己的节点。
    }
}
