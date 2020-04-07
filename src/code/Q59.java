package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/4/4 22:34
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * 解题思路：
 * 1.采用单调双向队列。
 * 维护一个队列用来保存当前滑动窗口的最大值的下标。
 * 每当队列移动的时候，如果队列为空则直接加入。
 * 如果队列不为空，则判断加入的元素是否大于队列头的元素。
 * 如果是，则将队列中所有元素弹出，然后将新元素加入队列。
 * 如果不是，则判断队列尾是否有数字
 * 如果有数字，则判断尾数字是否小于新元素。
 * 如果是，则弹出所有小于新元素的尾数字，加入新元素。
 * 如果不是，则加入新元素。
 * 如果无数字，则加入尾部。
 * 最后判断队列头元素是否在滑动窗口中
 * 如果不是，则弹出。
 * 2.采用一个max保存当前滑动窗口的最大值和maxIndex保存最大值下标。
 * 每次滑动的时候先判断maxIndex是否在当前滑动窗口内
 * 如果是，则比较新元素的大小，
 * 如果新元素较大则更新
 * 否则不更新。
 * 如果不在窗口内，
 * 则查找窗口的最大值。
 *
 */
public class Q59 {
    static public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0 || nums.length<k)
            return nums;
        int[] result = new int[nums.length-k+1];
        int index = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i=0;i<nums.length;i++){
            if (queue.isEmpty())
                queue.add(i);
            else if (nums[queue.peek()] <= nums[i]){
                queue.clear();
                queue.add(i);
            }else {
                while (!queue.isEmpty() && nums[queue.getLast()]<nums[i])
                    queue.pollLast();
                queue.add(i);
            }
            if (!queue.isEmpty() && queue.peek() <= i-k)
                queue.pollFirst();
            if (i>=k-1 && !queue.isEmpty())
                result[index++] = nums[queue.peek()];
        }
        return result;
    }
    static public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums == null || k <= 0 || nums.length<k)
            return nums;
        int[] result = new int[nums.length-k+1];
        int maxIndex = -1;
        int max = Integer.MIN_VALUE;
        for (int i=0;i<nums.length-k+1;i++){
            if (maxIndex >= i){
                if (nums[i+k-1]>max){
                    max = nums[i+k-1];
                    maxIndex = i+k-1;
                }
            }else {
                max = nums[i];
                for (int j=i;j<=i+k-1;j++){
                    if (max < nums[j]){
                        max = nums[j];
                        maxIndex = j;
                    }
                }
            }
            result[i] = max;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {9,10,9,-7,-4,-8,2,-6};
        System.out.println(maxSlidingWindow(nums,5));
    }
}
