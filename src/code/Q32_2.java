package code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/3/28 0:11
 */

/**
 * 题目同上，但是这次输出的时候需要按行输出，同一层的节点站一行。
 */
public class Q32_2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        if(root != null)
            queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> list1 = new ArrayList<>();
            for(int i = queue.size();i>0;i--) {
                TreeNode node = queue.poll();
                list1.add(node.val);
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            list.add(list1);
        }
        return list;
    }
}
