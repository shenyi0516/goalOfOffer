package code;

import java.util.LinkedList;
import java.util.Stack;

public class Q09_2 {
    class CQueue {
        //使用java的同学请注意，如果你使用Stack的方式来做这道题，会造成速度较慢；
        // 这个原因的话是因为Stack继承了Vector接口，而Vector底层是AbstractList，是一个数组，那么就要考虑空间扩容的问题了。
        // 可以使用LinkedList来做Stack的容器，
        // 因为LinkedList实现了Deque接口，所以Stack能做的事LinkedList都能做，其本身结构是个链表，扩容消耗少。
        //LinkedList加入元素使用add，弹出元素同样适用pop
        Stack<Integer> stack1;
        Stack<Integer> stack2;
//        LinkedList<Integer> stack1;
//        LinkedList<Integer> stack2;

        public CQueue() {
            stack1 = new Stack<Integer>();
            stack2 = new Stack<Integer>();
//            stack1 = new LinkedList<>();
//            stack2 = new LinkedList<>();
        }

        /**
         * 别人的方法，所有元素不需要同时存在于同一stack中，入队的时候加到stack1中，出队的时候直接从stack2中进行操作，只有当stack为空的时候再交换就行。
         * @param value
         */
        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            if(stack1.isEmpty() && stack2.isEmpty())
                return -1;
            else if(!stack2.isEmpty()){
                return stack2.pop();
            }
            else {
                while (!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
                return stack2.pop();
            }
        }
    }
}
