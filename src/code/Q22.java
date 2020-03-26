package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/3/26 21:52
 */

/**
 * 输出链表中倒数第k个节点。
 * 解题思路：设置快慢两个指针，快指针先走k-1步，当快指针走到结尾处时，慢指针刚好走到倒数第k个节点。
 * 值得注意的地方：
 * 1、链表的头指针为空
 * 2、k>链表的长度。
 * 3、k<=0，此时会导致k-1出错。
 * 测试用例：
 * 一个正常链表，0<k<=nodeList.length
 * 空链表
 * k<=0或者k>nodeList.length
 */
public class Q22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if(head == null)
            return null;
        if(k<=0)
            return null;
        ListNode fast = head;
        ListNode slow = head;
        for(int i=0;i<k;++i){
            if(fast!=null)
                fast = fast.next;
            else
                return null;
        }
        while (fast.next!= null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
