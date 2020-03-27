package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/3/28 0:19
 */

import java.util.*;

/**
 * 之字型输出二叉树的节点。
 * 解题思路：
 * 可以维护两个栈，根节点放入第一个栈。
 * 第二个栈先放入根节点的左子树，再放入右子树。
 * 当奇数层数的时候，依次把第二个栈的节点弹出，然后先放入右子树再放左子树。
 * 偶数蹭的时候，把第一个栈的节点弹出，先放左子树，再放右子树。
 */
public class Q32_3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        int counter = 0;//用于标记当前层数
        stack1.push(root);
        while (!stack1.isEmpty() || !stack2.isEmpty()){
            counter++;
            if((counter&1) == 1){
                List<Integer> tmp = new ArrayList<>();
                while (!stack1.isEmpty()){
                    TreeNode node = stack1.pop();
                    tmp.add(node.val);
                    if(node.left != null)
                        stack2.push(node.left);
                    if(node.right != null)
                        stack2.push(node.right);
                }
                result.add(tmp);
            }else {
                List<Integer> tmp = new ArrayList<>();
                while (!stack2.isEmpty()){
                    TreeNode node = stack2.pop();
                    tmp.add(node.val);
                    if(node.right != null)
                        stack1.push(node.right);
                    if(node.left != null)
                        stack1.push(node.left);
                }
                result.add(tmp);
            }
        }
        return result;
    }

    /**
     * 另一种方式，偶数层的时候把列表反转。
     * @param root 根节点
     * @return list
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        if(root != null)
            queue.add(root);
        int counter = 0;
        while (!queue.isEmpty()){
            counter++;
            List<Integer> list1 = new ArrayList<>();
            for(int i = queue.size();i>0;i--) {
                TreeNode node = queue.poll();
                list1.add(node.val);
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            if((counter&1)!=1) Collections.reverse(list1);
            list.add(list1);
        }
        return list;
    }
}
