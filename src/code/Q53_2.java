package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/4/4 15:08
 */

/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * 解题思路：一个排好序的数组，并且是从0~n-1递增的，说明该数组的下标和值一致，
 * 由于缺少了某一个数m，那么m之后的数组int[n]=n+1
 * 利用二分查找的方式，中间的数如果int[n]=n+1则判断他前面一个数是否满足int[n-1]=n-1
 * 若是，则返回n。
 * 否则，则向前查找。
 * 如果中间的数满足int[n]=n
 * 则向后查找。
 * 特殊情况:输入数组为空,只有一个数字的数组。
 */
public class Q53_2 {
    static public int missingNumber(int[] nums) {
        int number = -1;
        if (nums != null && nums.length>0){
            number = GetNumber(nums,0,nums.length-1);
        }
        return number;
    }

    static private int GetNumber(int[] nums, int start, int end) {
        if (start > end)
            return -1;
        int middle = (start+end)>>1;
        int number = nums[middle];
        if (number != middle){
            if (middle == 0 || nums[middle - 1] == middle - 1)
                return middle;
            else
                end = middle - 1;
        }else
            start = middle + 1;
        //注意考虑边界情况。
        if (start == nums.length)
            return start;
        return GetNumber(nums,start,end);
    }

    public static void main(String[] args) {
        int[] nums = {0,1,3};
        System.out.println(missingNumber(nums));
    }
}
