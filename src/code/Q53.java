package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/4/4 14:52
 */

/**
 * 在排序数组中查找数字。
 * 统计一个数字在排序数组中出现的次数。
 * 解题思路：由于是排好序的数组，可以使用二分查找的方式。
 * 先拿中间的数字和k做比较，如果中间的数字比较大，说明k在前半段，否则在后半段。
 * 如果中间的数字等于k，则判断k前面一个数字是否也为k，如果是的话则继续向前查找，否则说明这是第一个k。
 * 同理可以查找出最后一个k。
 * 特殊情况：
 * 输入为null的数组。
 */
public class Q53 {
    static public int search(int[] nums, int target) {
        if (nums == null || nums.length < 1)
            return 0;
        int first = GetFirstK(nums,0,nums.length-1,target);
        int last = GetLastK(nums,0,nums.length-1,target);
        if (first>-1&&last>-1)
            return last-first+1;
        else
            return 0;
    }

    static public int GetFirstK(int[] nums,int start,int end,int target){
        if (start>end)
            return -1;
        int middle = (start+end)>>1;
        int middleNumber = nums[middle];
        if (middleNumber == target){
            if (middle>0&&nums[middle-1] != target || middle == 0){
                return middle;
            }else {
                end = middle - 1;
            }
        }
        else if (middleNumber > target){
            end = middle - 1;
        }else {
            start = middle + 1;
        }
        return GetFirstK(nums,start,end,target);
    }

    static public int GetLastK(int[] nums,int start,int end,int target){
        if (start>end)
            return -1;
        int middle = (start+end)>>1;
        int middleNumber = nums[middle];
        if (middleNumber == target){
            if (middle<nums.length - 1 && nums[middle+1] != target || middle == nums.length - 1){
                return middle;
            }else {
                start = middle + 1;
            }
        }
        else if (middleNumber > target){
            end = middle - 1;
        }else {
            start = middle + 1;
        }
        return GetLastK(nums,start,end,target);
    }

    public static void main(String[] args) {
        int[] nums = {};
        int target = 8;
        System.out.println(search(nums,target));
    }
}
