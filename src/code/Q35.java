package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/3/28 20:25
 */

import java.util.LinkedList;

/**
 * 复杂链表的复制，给出一个特殊的链表，链表中除了一般的指针还存在一个特别的指针random指针指向任意一个节点或者空节点。
 * 实现函数copyRandomList，返回复制一个复杂链表。
 * 解题思路：
 * 这道题的主要问题在于如何找到random指针指向的节点。
 * 采用hash表保存链表节点的话需要o(n)的空间。
 * 不使用额外空间的方法如下：
 * 首先遍历原链表l1，在每个节点的后面都创建一个相同的节点。
 * 然后再遍历一遍l1，如果l1中某个奇数节点的random指针不为空，那么其下一个节点的random指针指向该节点的random指针的下一个节点。
 * 最后把所有的奇数节点和偶数节点进行拆分，偶数节点组成的链表即为复制后的链表。
 * 值得注意的地方：输入链表头指针为空
 */
public class Q35 {
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;
        Node pNode = head;
        while (pNode != null){
            Node nodeCopy = new Node(pNode.val);
            nodeCopy.next = pNode.next;
            pNode.next = nodeCopy;
            pNode = pNode.next.next;
        }
        pNode = head;
        int i = 0;
        while (pNode != null){
            i++;
            if((i&1)== 1){
                //注意存在random指针为空的情况
                if(pNode.random != null)
                    pNode.next.random = pNode.random.next;
            }
            pNode = pNode.next;
        }
        Node headCopy = head.next;
        Node pCopy = headCopy;
        pNode = head;
        while (pNode!=null){
            pNode.next = pNode.next.next;
            pNode = pNode.next;
            //注意这边，pNode已经指向了下一个节点，此时如果pNode==null，说明链表已经到底了。
            //此时pCopy.next也为空，不加限制的话会出现空指针问题。
            if(pNode != null)
                pCopy.next = pCopy.next.next;
                pCopy = pCopy.next;
        }
        return headCopy;
    }
}
