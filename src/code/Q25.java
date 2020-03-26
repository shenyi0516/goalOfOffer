package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/3/26 23:52
 */

/**
 * 合并两个排序后的链表
 * 给出两个链表l1、l2,分别用两个指针指向l1和l2的第一个数得node1和node2，比较两个指针大小，把小的那个指针放入新的链表l3中
 * 然后将小的指针向后移动一位。直到两个指针都指向null。
 * 要考虑的情况：
 * 1、输入的链表中有空指针。
 */
public class Q25 {
    /**
     * 递归的方式
     * @param l1 链表1
     * @param l2 链表2
     * @return 新链表的头节点
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode l3Head = null;
        if(l1.val <l2.val){
            l3Head = l1;
            l3Head.next = mergeTwoLists(l1.next,l2);
        }else {
            l3Head = l2;
            l3Head.next = mergeTwoLists(l1,l2.next);
        }
        return l3Head;
    }

    /**
     * 非递归的方式，采用伪头节点。
     * @param l1 链表1
     * @param l2 链表2
     * @return l3头节点
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode dum = new ListNode(0), cur = dum;
        while (l1 != null && l2 != null){
            if(l1.val<l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 !=null? l1 : l2;
        return dum.next;
    }
}
