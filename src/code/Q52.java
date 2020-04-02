package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/4/3 0:51
 */

import java.util.Stack;

/**
 * 输入两个链表，找出它们的第一个公共节点。
 * 解题思路：
 * 剑指offer上的方法：
 * 使用两个堆栈，把两个链表中的节点分别放入堆栈中，最后两个堆栈一起弹出，找到最后一个相同的节点。
 * 力扣上的方法：
 * 快慢指针，指针1在链表1上遍历，当遍历到结尾的时候从链表2上再次开始遍历。
 * 指针2在链表2上遍历，当遍历到结尾的时候从链表1上再次开始遍历。
 * 当指针相遇的时候，该节点则为公共节点。
 */
public class Q52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA!=pB){
            //由于只遍历m+n的长度，如果最后没有相交的节点会同时指向null
            pA = pA != null ? pA.next : headB;
            pB = pB != null ? pB.next : headA;
        }
        return pA;
    }
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        Stack<ListNode> stackA = new Stack<>();
        Stack<ListNode> stackB = new Stack<>();
        while (headA != null){
            stackA.push(headA);
            headA = headA.next;
        }
        while (headB != null){
            stackB.push(headB);
            headB = headB.next;
        }
        ListNode res = null;
        while (!stackA.isEmpty() && !stackB.isEmpty() && stackA.peek() == stackB.peek()){
            res = stackA.pop();
            stackB.pop();
        }
        return res;
    }
}
