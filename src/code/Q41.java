package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/4/1 22:09
 */

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 给出一个数据流，实现一个数据结构能够给出中位数，如果是偶数个数则为中间两个数的平均值。
 * 解题思路：数据结构由两个堆组成，一个小顶堆，存放数据流中较大的一半，另外一个大顶堆，存放数据流中较小的一半。
 * 当读出一个数据的时候，首先放入大顶堆，然后把大顶堆的最大元素放入小顶堆，
 * 如果是奇数个数的话则还需要把小顶堆的最小元素放入大顶堆中，保证所有小顶堆的元素大于大顶堆。
 * 如果输入数据为偶数，则返回两个堆顶元素的平均值，否则返回大顶堆的堆顶元素。
 */
public class Q41 {
    class MedianFinder {
        Queue<Integer> smallHeap;
        Queue<Integer> bigHeap;
        int size = 0;
        /** initialize your data structure here. */
        public MedianFinder() {
            bigHeap = new PriorityQueue<>();
            smallHeap = new PriorityQueue<>((x,y)->y-x);
            size = 0;
        }

        public void addNum(int num) {
            size++;
            bigHeap.offer(num);
            smallHeap.offer(bigHeap.poll());
            if((size&1)==1)
                bigHeap.offer(smallHeap.poll());
        }

        public double findMedian() {
            if (smallHeap.isEmpty() && bigHeap.isEmpty())
                return 0;
            if(smallHeap.isEmpty())
                return bigHeap.peek();
            if (bigHeap.isEmpty())
                return smallHeap.peek();
            if((size&1)==1)
                return (double)bigHeap.peek();
            else
                return (double)(bigHeap.peek()+smallHeap.peek())/2.0;
        }
    }
}
