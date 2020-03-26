package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/3/26 20:44
 */

/**
 *考虑的情况是解耦。
 * 输入一个数组,使得该数组奇数在前，偶数在后。
 * 剑指offer上的方法是设置首尾两个指针，前指针找到一个偶数，后指针找到第一个奇数，交换两个数，直至后指针在前指针前面。
 * LeetCode上的方法，设置快慢两个指针，快指针向前找到一个奇数，然后交换位置，慢指针向前一位，直至快指针遍历完全部。
 */
public class Q21 {
    public int[] exchange(int[] nums) {
        int[] res = {};
        if(nums == null)
            return res;
        if(nums.length<1)
            return res;
        int begin = 0;
        int end = nums.length-1;
        while (end>begin){
            while (begin<end && !isEven(nums[begin])){
                begin++;
            }
            while (begin<end && isEven(nums[end])){
                end--;
            }
            if(begin<end){
                int tmp = nums[begin];
                nums[begin] = nums[end];
                nums[end] = tmp;
            }
        }
        return nums;
    }
    public static int[] exchange1(int[] nums) {
        if(nums == null || nums.length == 0)
            return nums;
        int fast = 0;
        int slow = 0;
        while (fast<nums.length){
            if((nums[fast] & 1) != 0){
                swap(nums,fast,slow);
                slow++;
            }
            fast++;
        }
        return nums;
    }
    static void swap(int[] arr, int fast, int slow){
        int tmp = arr[fast];
        arr[fast] = arr[slow];
        arr[slow] = tmp;
    }
    boolean isEven(int number){
        return (number&1)==0;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(exchange1(nums));
    }
}
