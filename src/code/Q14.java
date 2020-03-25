package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/3/25 16:24
 */

import static java.lang.StrictMath.fma;
import static java.lang.StrictMath.pow;

/**
 * 给出一段长度为n的绳子，把绳子剪成m段，m和n都是整数，使得每段绳子的长度乘积最大。
 * 1.动态规划
 * 给出计算公式f(n) = max(f(n-k)*f(k))
 * 最后得出的f(length)即为最大乘积。
 * 2.贪心算法
 * 当n>=5时，3（n-3）>=2(n-2),所以可以得出，此时每次剪3长度的绳子下来可以使得乘积最大。
 * 当n==4的，2*2>1*3，所以此时剪2长度下来可是使得乘积最大。
 */
public class Q14 {
    //贪心
    public int cuttingRope(int n) {
        int count3 = 0;
        if(n == 2)
            return 1;
        if(n == 3)
            return 2;
        if(n == 4)
            return 4;
        while (n>=5){
            n = n-3;
            count3++;
        }
        return (int)Math.pow(3,count3)*n;
    }
    //动态规划,注意越界问题。
     static public int cuttingRopeD(int n) {
        int[] fMax = new int[n+1];
        if(n<2)
            return 0;
        if(n==2)
            return 1;
        if(n==3)
            return 2;
         fMax[0] = 0;
         fMax[1] = 1;
         fMax[2] = 2;
         fMax[3] = 3;
        for(int i=4;i<n+1;i++){
            int max = 0;
            for(int j=1;j<= i/2;j++){
                int product = fMax[i - j]*fMax[j];
                if(product > max)
                    max = product;
            }
            fMax[i] = max;
        }
        return fMax[n];
    }

    public static void main(String[] args) {
        System.out.println(cuttingRopeD(2));
    }
}
