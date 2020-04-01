package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/4/1 20:15
 */

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 给出一个数组，返回最小的K个数。
 * 1.使用Partition算法。
 * 我们的目的是寻找最小的 k 个数。
 * 假设经过一次 partition 操作，枢纽元素位于下标 m，也就是说，左侧的数组有 m 个元素，是原数组中最小的 m 个数。
 * 那么：
 * 若 k = m，我们就找到了最小的 k 个数，就是左侧的数组；
 * 若 k<m ，则最小的 k 个数一定都在左侧数组中，我们只需要对左侧数组递归地 partition 即可；
 * 若 k>m，则左侧数组中的 m 个数都属于最小的 k 个数，
 * 我们还需要在右侧数组中寻找最小的 k-m 个数，对右侧数组递归地 partition 即可。
 * 2.使用JAVA的大顶堆
 * 当题目中出现大量数据或者是不得修改元数据的时候，可以采用这种方式，JAVA有现成的PriorityQueue，修改比较方式后就是大顶堆。
 */
public class Q40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(k==0||arr.length==0)
            return new int[0];
        return QuickSearch(arr,0,arr.length-1,k-1);
    }

    private int[] QuickSearch(int[] arr,int start, int end,int k) {
        int j = partition(arr,start,end);
        if(j == k)
            return Arrays.copyOf(arr,j+1);
        return j>k?QuickSearch(arr,start,j-1,k):QuickSearch(arr,j+1,end,k);
    }

    /**
     * 采用快排的方式排序
     * @param arr 数组
     * @param start 起始位置
     * @param end 结束位置
     * @return 排序好的数组
     * 取数组中的第一位，从前往后找到第一个大于arr[start]的数
     * 从后往前找到第一个小于arr[start]的数
     * 交换两者的位置。
     * 直至i=j，此时j的位置就是arr[start]应该在的位置，返回j，根据情况向左或者向右递归。
     */
    private int partition(int[] arr, int start, int end) {
        int v =arr[start];
        int i = start, j = end+1;
        while (true){
            while (i++<end && arr[i]<v);
            while (j-->start && arr[j]>v);
            if(i>=j)
                break;
            int tmp = arr[j];
            arr[j] = arr[i];
            arr[i] = tmp;
        }
        arr[start] = arr[j];
        arr[j] = v;
        return j;
    }

    /**
     * 方法2
     * @param arr 数组
     * @param k 前k个数
     * @return 数组
     */
    public int[] getLeastNumbers2(int[] arr, int k) {
        if(k==0||arr.length==0)
            return new int[0];
        Queue<Integer> heap = new PriorityQueue<>(k,(i1,i2)->Integer.compare(i2,i1));
        for(int e:arr){
            if(heap.isEmpty() || heap.size()<k||e<heap.peek())
                heap.offer(e);
            if(heap.size()>k)
                heap.poll();
        }
        int[] res = new int[heap.size()];
        int j = 0;
        for (int e:heap){
            res[j++] = e;
        }
        return res;
    }
}
