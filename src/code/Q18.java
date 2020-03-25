package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/3/25 23:32
 */

/**
 * 给出一个链表的节点，在n(1)内进行删除
 * 解题思路：
 * 如果该节点不是尾节点的话，可以将该节点的下一个节点的内容复制到该节点上，那么相当于删除了这个节点。
 * 如果该节点是尾节点的话，则从头开始删除。
 */
public class Q18 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 力扣上的题目,给出节点的val值，删除该节点。
     * @param head 头结点
     * @param val val值
     * @return
     */
    public ListNode deleteNode(ListNode head, int val) {
        ListNode node = head;
        if(head.val == val && node.next!= null){
            head = node.next;
            return head;
        }
        else if(node.next == null && head.val == val){
            return null;
        }
        while (node.next != null){
            if(node.next.val == val){
                node.next = node.next.next;
                break;
            }else {
                node = node.next;
            }
        }
        return head;
    }

    /**
     * 剑指offer上的题
     * @param head
     * @param deletNode
     * @return
     */
    public ListNode deleteNode2(ListNode head, ListNode deletNode) {
        if(deletNode.next != null){
            deletNode.val = deletNode.next.val;
            deletNode.next = deletNode.next.next;
        }else if(head == deletNode){
            head = null;
        }else{
            ListNode node = head;
            while (node.next!=deletNode){
                node = node.next;
            }
            node.next = null;
        }
        return head;
    }
}
