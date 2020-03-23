package code;

import java.util.ArrayList;
import java.util.Stack;

public class Q06 {
    static class Node{
        Node next;
        int data;
        public Node(int data){
            this.data = data;
        }
    }

    static class NodeList{
        Node header = null;
        public void addNode(int data){
            Node node = new Node(data);
            if(header == null){
                header = node;
                return;
            }
            Node tmp = header;
            while (tmp.next != null){
                tmp = tmp.next;
            }
            tmp.next = node;
        }
    }

    /**
     * 使用栈的方式
     * @param nodeList
     */
    static void PrintfNodeListReversingly(NodeList nodeList){
        Stack<Node> stack = new Stack<>();
        Node tmp = nodeList.header;
        while (tmp != null){
            stack.push(tmp);
            tmp = tmp.next;
        }
        while (!stack.isEmpty()){
            System.out.println(stack.pop().data);
        }
    }
    static ArrayList<Integer> tmp = new ArrayList<Integer>();
    static void PrintfNodeListNoStack(Node node){
        if(node != null){
            if(node.next != null){
                PrintfNodeListNoStack(node.next);
            }
            tmp.add(node.data);
        }
    }

    /**
     * 还可以使用一个数组倒序输入，速度更快。
     * @param head
     * @return
     */
    public static int[] reversePrint(Node head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.data);
            head = head.next;
        }
        int size = list.size();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = list.get(size - i -1);
        }
        return array;
    }

    /**
     * 先遍历一遍链表，计算出个数，然后数组从count-1开始输入，速度比上面更快一些。
     * @param head
     * @return
     */
    public static int[] reversePrint2(Node head) {
        Node node = head;
        int count = 0;
        while (node != null) {
            ++count;
            node = node.next;
        }
        int[] nums = new int[count];
        node = head;
        for (int i = count - 1; i >= 0; --i) {
            nums[i] = node.data;
            node = node.next;
        }
        return nums;
    }

    public static void main(String[] args) {
        NodeList nodeList = new NodeList();
//        nodeList.addNode(1);
//        nodeList.addNode(2);
//        nodeList.addNode(3);
//        nodeList.addNode(4);
//        nodeList.addNode(5);
//        PrintfNodeListReversingly(nodeList);
        PrintfNodeListNoStack(nodeList.header);
        int[] res = new int[tmp.size()];
        for(int i=0;i<res.length;i++){
            res[i] = tmp.get(i);
            System.out.println(res[i]);
        }
    }
}
