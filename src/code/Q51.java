package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/4/2 23:50
 */

import java.util.Arrays;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组，求出这个数组中的逆序对的总数。
 * 解题思路：采用归并排序的方法。
 * 重点在于在两个指针比较的过程中，
 * 如果第一个子数组中的数字大于第二个子数组中的数字，
 * 则可以构成逆序对，并且逆序对的数目就是第二个子数组中剩余数字的个数。
 */
public class Q51 {
    static int res;
    static public int reversePairs(int[] nums) {
        res = 0;
        if (nums == null || nums.length <= 1)
            return res;
        mergeSort(nums, 0,nums.length-1);
        return res;
    }

    static private void mergeSort(int[] nums, int left, int right) {
        if (left == right)
            return;
        int middle = left+((right - left)/2);
        mergeSort(nums,left,middle);
        mergeSort(nums,middle+1,right);
        merge(nums,left,middle,right);
    }

    static private void merge(int[] nums, int left, int middle, int right) {
        int[] helper = new int[right-left+1];
        int i = 0;
        int pos1 = left;
        int pos2= middle+1;
        while (pos1<=middle&&pos2<=right){
            if (nums[pos1]<=nums[pos2])
                helper[i++] = nums[pos1++];
            else if (nums[pos1]>nums[pos2]){
                helper[i++] = nums[pos2++];
                res += (middle-pos1+1);
            }
        }
        while (pos1<=middle){
            helper[i++] = nums[pos1++];
        }
        while (pos2<=right){
            helper[i++] = nums[pos2++];
        }
        //这边要注意不要写错，arraycopy(int[]1,int[]1start,int[]2,int2[]start,length)是把int[]2中从start开始复制length给1
        System.arraycopy(helper,0,nums,left,helper.length);
    }

    public static void main(String[] args) {
        int[] ints = {7,5,6,4};
        System.out.println(reversePairs(ints));
    }
}
