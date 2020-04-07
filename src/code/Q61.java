package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/4/8 0:00
 */

import java.util.Arrays;

/**
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 * 解题思路：先对数组进行排序，然后统计0的个数，并且判断相邻两个元素之间是否能够使用0来填补间隔。
 * 满足最大减去最小 <5 && 没有对子 就一定是顺子
 */
public class Q61 {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int zeroNumber = 0;
        for (int i=0;i<nums.length-1;i++) {
            if (nums[i] != 0){
                if (nums[nums.length-1] - nums[i] >=5)
                    return false;
                if (nums[i]==nums[i+1])
                    return false;
            }
        }
        return true;
    }
}
