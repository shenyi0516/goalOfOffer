package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/4/1 22:53
 */
/**
 * 给出一个int数组，返回连续子数组的最大和。
 * 解题思路：
 * 1.在读取数组的时候保存当前累加的子数组和以及最大子数组和。
 * 当前累加子数组和为0时，抛弃从0开始的数字和，把当前累加和设置为下一个数字。
 * 最后返回最大子数组和。
 * 2.动态规划
 * 给出状态转移方程：f(i) = f(i-1)>0?f(i-1)+arr[i]:arr[i]
 * 最后求出max（f(i)）
 */
public class Q42 {
    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int now = 0;
        int i = 0;
        while (i<nums.length){
            if (now <= 0)
                now = 0;
            now += nums[i];
            if (max<now)
                max=now;
            i++;
        }
        return max;
    }

    /**
     * 动态规划
     * @param nums
     * @return 最大值
     * 递归超时了 还是用递推吧
     */
    static int res;
    public static int maxSubArray2(int[] nums) {
        int res = nums[0];
        for(int i=1;i<nums.length;i++){
            nums[i] = Math.max(nums[i],nums[i-1]+nums[i]);
            res = Math.max(nums[i], res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1};
        System.out.println(maxSubArray2(arr));
    }
}
