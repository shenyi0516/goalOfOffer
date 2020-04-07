package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/4/4 23:38
 */

import java.util.LinkedList;

/**
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，
 * 要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * 方法同上题。
 */
public class Q59_2 {
    class MaxQueue {
        LinkedList<Integer> queue;
        LinkedList<Integer> maxQueue;
        public MaxQueue() {
            queue = new LinkedList<>();
            maxQueue = new LinkedList<>();
        }

        public int max_value() {
            if (!maxQueue.isEmpty())
                return maxQueue.peek();
            else
                return -1;
        }

        public void push_back(int value) {
            queue.add(value);
            while (!maxQueue.isEmpty() && maxQueue.getLast() < value)
                maxQueue.pollLast();
            maxQueue.add(value);
        }

        public int pop_front() {
            int tmp = queue.isEmpty()?-1:queue.pollFirst();
            if (!maxQueue.isEmpty()&&maxQueue.peek() == tmp)
                maxQueue.pollFirst();
            return tmp;
        }
    }
}
