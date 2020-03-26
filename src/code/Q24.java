package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/3/26 23:01
 */

/**
 * 给出一个链表进行翻转。
 * 解题思路：需要反转节点node的话，首先需要知道node的前一个节点preNode。
 * 但是，仅仅node.next = preNode的话，会导致原来node的下一个节点nextNode丢失。
 * 所以需要先把nextNode保存起来，每当反转完一个节点的时候，3个指针各自向前移动一格。
 * 需要考虑的情况：
 * 1.头指针为空
 * 2.该链表只有一个节点。
 * 初始化指针:
 * 1.node = head;
 * 2.preNode = null; 这样反转之后node才会指向null，不然无限循环;
 */
public class Q24 {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode node = head;
        ListNode preNode = null;
        ListNode headReverse = null;
        while (node != null){
            if(node.next == null)
                headReverse = node;
            ListNode nextNode = node.next;
            node.next = preNode;
            preNode = node;
            node = nextNode;
        }
        return headReverse;
    }
}
