package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/3/27 21:33
 */

import java.util.Stack;

/**
 * 定义一个栈的数据结构，在该类型中实现一个能够得到栈的最小元素的Min函数。
 * 调用min()/pop()/push()的时间复杂度都是n(1)
 * 解题思路：
 * 由于是n(1)的时间复杂度，那说明在输入的时候就需要对最小元素进行保存，这样需要额外维护一个数据结构。
 * 设定一个最小值的栈stackOfMin，当stack压入元素的时候，判断该元素是否是目前栈中的最小值
 * 如果是的话把该元素的值也压入stackOfMin中
 * 如果不是的话把最小值压入stackOfMin中
 * 这样，每次当压入或者弹出元素的时候，stackOfMin也会压入或弹出当前状态的最小值，时间复杂度为n(1)
 */
public class Q30 {
    class MinStack {
        Stack<Integer> stack;
        Stack<Integer> stackOfMin;
        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack<Integer>();
            stackOfMin = new Stack<Integer>();
        }

        public void push(int x) {
            if(stack.isEmpty()){
                stack.push(x);
                stackOfMin.push(x);
            }else {
                stackOfMin.push(Math.min(stackOfMin.peek(),x));
                stack.push(x);
            }
        }

        public void pop() {
            if (stack.isEmpty()){
                return ;
            }else {
                stack.pop();
                stackOfMin.pop();
            }
        }

        public int top() {
            if(stack.isEmpty()){
                return 0x80000000;
            }else{
                return stack.peek();
            }
        }

        public int min() {
            if(stackOfMin.isEmpty()){
                return 0x80000000;
            }else{
                return stackOfMin.peek();
            }
        }
    }
}
