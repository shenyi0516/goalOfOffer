package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/4/4 20:48
 */

/**
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。
 * 如果有多对数字的和等于s，则输出任意一对即可。
 * 解题思路：双指针碰撞法。
 * 首先固定一个指针在数组头，另一个在数组尾。
 * 如果p1+p2>target
 * 则p2向前移动
 * 否则p1向后移动。
 * 直到两个指针相遇或者p1+p2>target。
 * 注意事项：数组为空。
 */
public class Q57 {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 1)
            return null;
        int left = 0;
        int right = nums.length - 1;
        while (right > left){
            if ((nums[left] + nums[right]) > target)
                right--;
            else if ((nums[left] + nums[right]) < target)
                left++;
            else
                return new int[] {nums[left],nums[right]};
        }
        return null;
    }
}
