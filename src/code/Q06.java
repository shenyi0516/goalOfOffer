package code;

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

    static void PrintfNodeListNoStack(Node node){
        if(node != null){
            if(node.next != null){
                PrintfNodeListNoStack(node.next);
            }
            System.out.println(node.data);
        }
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

    }
}
