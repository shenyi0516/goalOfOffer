package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/3/26 18:25
 */
public class CharTest {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = node;
        node1.next = new ListNode(2);
        System.out.println(node.next.val);
    }
}
