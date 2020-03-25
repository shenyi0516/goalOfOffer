package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/3/25 21:30
 */

/**
 * 实现函数doublePower(double base,int exponent)，计算出以base为底数，exponent为指数的值，不考虑大数问题。
 * 考虑几个问题：
 * 1.底数为负数、0，底数为负数的时候不影响结果，但是为0的时候要考虑pow(0,0)这样的情况
 * 2.指数为负数或者0，指数为负数的时候可以先计算出pow（base，abs(exponent)），然后取倒数，所以当底数为0的时候需要特别考虑
 * 3.快速幂
 * 4.java中double类型如果精度过高不能直接比较。
 * 5.java int取负可能溢出。
 */
public class Q16 {
    public double myPow(double x, int n) {
        long b = n;
        if(x==0)
            return 0;
        if(n==0)
            return 1;
        if(n<0){
            x = 1/x;
            b = -b;
        }
        double res = 1.0;
        while(b > 0){
            if((b&1) == 1)
                res *= x;
            x = x*x;
            b >>= 1;
        }
        return res;
    }
}
