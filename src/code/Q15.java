package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/3/25 20:43
 */

/**
 * 判断一个二进制数中含有多少个1
 * 解法1：无符号右移
 * 解法2：对于二进制数n来说，n &（n-1）可以使得n的最右边一个1变为0，所以只要反复循环直至n=0，就可以得出一共含有多少个1。
 * 测试用例：负数、0
 */
public class Q15 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n!=0){
            n &= (n-1);
            count ++;
        }
        return count;
    }
}
