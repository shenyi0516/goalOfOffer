package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/3/27 22:31
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上到下打印二叉树。
 * 解题思路：
 * 依靠队列的方式，每次打印一个节点的时候，把该节点的左右子树都加入队列。
 * 直到队列为空，则所有节点输出完毕。
 * 需要注意的地方：
 * 输入二叉树为空、二叉树只有一个根节点。
 */
public class Q32 {
    public int[] levelOrder(TreeNode root) {
        if(root == null)
            return new int[0];
        Queue<TreeNode> queue = new LinkedList<>(){{ add(root); }};
        ArrayList<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            result.add(node.val);
            if(node.left != null)
                queue.add(node.left);
            if(node.right != null)
                queue.add(node.right);
        }
        int[] ans = new int[result.size()];
        for(int i=0;i<result.size();i++)
            ans[i] = result.get(i);
        return ans;
    }
}
