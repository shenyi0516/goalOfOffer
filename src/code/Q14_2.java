package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/3/25 17:23
 */

/**
 * 于Q14内容一致，主要要考虑的是数据过大，但是由于结果只需要返回mod1000000007，所以可以考虑如下方案。
 * 1.JAVA可以直接使用BigInteger
 * 2.对于动态规划来说，fMax[]中的数每次都进行取模操作。
 * 3.对于贪心算法来说，计算出count3之后，可以使用快速幂取模。
 * 这里只列出方案3
 */
public class Q14_2 {
    public int cuttingRope(int n) {
        if(n <= 3) return n - 1;
        int b = n % 3, p = 1000000007;
        long rem = 1, x = 3;
        for(int a = n / 3 - 1; a > 0; a /= 2) {
            if(a % 2 == 1) rem = (rem * x) % p;
            x = (x * x) % p;
        }
        if(b == 0) return (int)(rem * 3 % p);
        if(b == 1) return (int)(rem * 4 % p);
        return (int)(rem * 6 % p);
    }

}
