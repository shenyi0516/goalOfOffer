package code;

import java.util.Stack;

public class Q09 {
    class CQueue {
        Stack<Integer> stack1;
        Stack<Integer> stack2;

        public CQueue() {
            stack1 = new Stack<Integer>();
            stack2 = new Stack<Integer>();
        }

        /**
         * 我的方法，判断目前所有元素是在stack1还是2，根据不同情况进行操作。
         * @param value
         */
        public void appendTail(int value) {
            if(stack1.isEmpty() && stack2.isEmpty())
                stack1.push(value);
            else if(stack1.isEmpty()){
                while (!stack2.isEmpty()){
                    stack1.push(stack2.pop());
                }
                stack1.push(value);
            }
            else {
                stack1.push(value);
            }
        }

        public int deleteHead() {
            if(stack1.isEmpty() && stack2.isEmpty())
                return -1;
            else if(stack1.isEmpty()){
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
