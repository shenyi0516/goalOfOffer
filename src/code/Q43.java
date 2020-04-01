package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/4/1 23:50
 */

/**
 * 给出一个数字，判断0从到该数字，1一共出现了多少次。、
 * 解题思路：
 * 对于1234来说，可以分为1~999,1000~1234
 * 此时，n=1234，high=1, pow=1000, last=234，
 * 最后结果为f(pow-1) + last + 1 + f(last);
 * 对于3234，high=3, pow=1000, last=234
 * pow + high*f(pow-1) + f(last);
 * 所以
 */
public class Q43 {
    public int countDigitOne(int n) {
        return f(n);
    }

    private int f(int n) {
        if (n<=0)
            return 0;
        String number = String.valueOf(n);
        int pow = (int)Math.pow(10,number.length()-1);
        int high = number.charAt(0)-'0';
        int last = n - high*pow;
        if(high == 1)
            return f(pow-1)+last+1+f(last);
        else
            return pow+high*f(pow-1)+f(last);
    }
}
