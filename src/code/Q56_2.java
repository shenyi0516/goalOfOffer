package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/4/4 17:14
 */

/**
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。
 * 请找出那个只出现一次的数字。
 * 解题思路：
 * 如果每个数字出现了3次，那么把所有数字的二进制表示相加，各位上也应该能被3整除。
 * 所有如果某一位能被3整除说明要找的数字这位为0，否则为1。
 * JAVA取位操作 n&(1<<i),0<i<=32
 * 把一个数的某一位设为1
 * n ^= (1 << i)
 */
public class Q56_2 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i=0;i<32;i++){
            int count = 0;
            for (int number:nums){
                //注意这边&之后的数是0100这样，所以不能使用==1，只能使用!=0
                if ((number & (1<<i)) != 0)
                    count++;
            }
            if (count%3 == 1)
                res ^= (1<<i);
        }
        return res;
    }
}
