package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/3/27 21:50
 */

import java.util.Stack;

/**
 * 给出两个序列，第一个序列表示入栈顺序，判断第二个序列是否为第一个序列的出栈顺序，栈中元素均不相等。
 * 解题思路：
 * 例如给出序列{1,2,3,4,5}和{4,5,3,2,1}
 * 先按顺序将序列压入栈，直到找到第二个序列的第一个元素4
 * 然后弹出，表示能够第一个输出4，然后把剩下的元素压入栈，直到第二个元素5出现
 * 弹出5后，序列1中已经没有元素了，判断栈顶元素是否为3,
 * 是的话弹出，继续判断栈顶元素是否和序列2的下一个元素2相等，以此类推。
 * 需要考虑的情况：
 * 输入两个空序列、两个序列长度不相等(本题似乎默认长度相等)
 */
public class Q31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Boolean flag = false;
        if(popped == null && pushed == null)
            return true;
        if (popped == null)
            return false;
        if (pushed == null)
            return false;
        if(popped.length == 0 && pushed.length == 0)
            return true;
        if(popped.length>0 && pushed.length>0){
            int nextPush = 0;//指向第一个序列的指针
            int nextPop = 0;
            Stack<Integer> stack = new Stack<Integer>();
            while (nextPop<popped.length){
                while (stack.isEmpty() || stack.peek() != popped[nextPop]){
                    if(nextPush == pushed.length)
                        break;
                    stack.push(pushed[nextPush]);
                    nextPush++;
                }
                if(stack.peek() != popped[nextPop])
                    break;
                stack.pop();
                nextPop++;
            }
            if(stack.isEmpty() && nextPop == popped.length)
                flag = true;
        }
        return flag;
    }
}
