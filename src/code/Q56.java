package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/4/4 16:54
 */

/**
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * 解题思路：
 * 异或特性：
 * 1.一个数异或自己本身为0。
 * 2.一个数异或0为自己本身。
 * 先计算出所有数字的异或和，找到其中不为0的一位k。
 * n&-n可以求一个二进制数的最低位的1对应的数。
 * 按照k是否为0把数字分为两组，分别求出异或和，最后的结果即为两个数字。
 * 特殊情况：
 * 输入数组为空，数组长度小于2。
 */
public class Q56 {
    public int[] singleNumbers(int[] nums) {
        if(nums == null || nums.length < 2)
            return null;
        int resultOR = 0;
//        for (int i=0;i<nums.length;i++)
//            resultOR ^= nums[i];
        for (int number: nums) {
            resultOR ^= number;
        }
        int onePosition = resultOR &(-resultOR);
        int num1 = 0;
        int num2 = 0;
//        for (int i=0;i<nums.length;i++){
//            if ((nums[i]&onePosition)== onePosition)
//                num1 ^= nums[i];
//            else
//                num2 ^= nums[i];
//        }
        for (int number:nums) {
            if ((number&onePosition) == onePosition)
                num1 ^= number;
            else
                num2 ^= number;
        }
        //也可以只求一个num1，然后用num1^onePosition来求出num2这样更快
        return new int[]{num1,num2};
    }
}
