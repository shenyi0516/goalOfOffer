package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/3/26 22:16
 */

/**
 * 判断一个链表是否包含环
 * 分为3步：
 * 1.先用快指针和慢指针，快指针每次前进两格，慢指针每次前进一格，如果当快指针走到node.next==null时，
 * 两个指针依旧不相等，则无环
 * 2.如果两个指针相遇了，证明该链表有环。此时需要知道环有几个节点，快指针每次向前移动一格并计数，
 * 当两个指针再次相遇的时候，就可以知道环的节点数。
 * 3.当知道节点数n的时候，快慢指针重新从头节点出发，快指针先移动n格，两个指针每次向前移动一格，
 * 当两个指针相遇的时候，该位置即为环入口
 */
public class Q23 {
    /**
     *
     * @param head 头结点
     * @return 不存在环返回null，存在的话返回相遇节点
     */
    public static ListNode MeetingNode(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        if(fast == null)
            return null;
        fast = fast.next;
        while (fast != null && slow != null){
            if(fast == slow)
                return fast;
            fast = fast.next;
            slow = slow.next;
            if(fast != null){
                fast = fast.next;
            }
        }
        return null;
    }
    public static int counterOfLoop(ListNode head,ListNode meetNode){
        if(meetNode == null || head == null)
            return 0;
        ListNode fast = meetNode;
        ListNode slow = meetNode;
        fast = fast.next;
        int counter = 1;
        while (fast != null){
            if(fast == slow)
                return counter;
            else{
                fast = fast.next;
                counter++;
            }
        }
        return 0;
    }
    public static ListNode EntryOfLoop(ListNode head,int counter){
        if(head == null || counter == 0)
            return null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null && counter!=0){
            fast = fast.next;
            counter--;
        }
        while (fast!=null&&slow!=null){
            if(fast == slow)
                return fast;
            fast=fast.next;
            slow=slow.next;
        }
        return null;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode tmp = head;
        ListNode tmp3 = null;
        for(int i =2;i<=6;i++){
            tmp.next = new ListNode(i);
            tmp = tmp.next;
            if(i == 3)
                tmp3 = tmp;
        }
        tmp.next = tmp3;
        ListNode meetNode = MeetingNode(head);
        int counter = counterOfLoop(head,meetNode);
        System.out.println(counter);
        System.out.println(EntryOfLoop(head,counter).val);
    }
}
