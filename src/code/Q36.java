package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/3/28 21:28
 */

/**
 * 给出一颗二叉搜索树，转化为一个排好序的双向链表，要求不能创建新的节点。
 * 采用分治的思想，对于一个根节点来说，修改后的链表中，他的left应该指向左子树中最大的一个数,right指向右子树中最小的一个数。
 * 采用递归的方式进行切换，最后返回头结点。
 * 改写中序遍历，遍历过程中使用一全局变脸pre存储其前一个结点,当遍历该结点时，只需该节点的前驱(left)指向pre，pre的后继指向该节点。
 * 对于头结点应特殊处理。
 * 这道题考察的是，中序遍历二叉搜索树即可得到一个递增序列。
 */
public class Q36 {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
    public Node pre;
    public Node head,tail;
    public Node treeToDoublyList(Node root) {
        if(root == null)
            return null;
        process(root);
        tail.right = head;
        head.left = tail;
        return head;
    }

    public void process(Node root){
        if(root == null)
            return;
        process(root.left);
        root.left = pre;
        if (pre == null)
            head = root;
        else {
            pre.right = root;
        }
        pre = root;
        tail = root;
        process(root.right);
    }
}
