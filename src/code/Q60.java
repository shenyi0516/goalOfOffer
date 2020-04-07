package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/4/7 21:48
 */

/**
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。
 * 输入n，打印出s的所有可能的值出现的概率。
 * 解题思路：
 * n个骰子每个6面，总排列数为pow(6,n)。
 * 令f(n,s)为骰子数为n，和为s的情况数量。
 * n=1时，f(1,s)=1,2,3,4,5，6.
 * n>1时，f(n,s) = f(n-1,s-1)+f(n-1,s-2)+f(n-1,s-3)+f(n-1,s-4)+f(n-1,s-5)+f(n-1,s-6)
 * 创建两个数组，每个数组大小为6*n+1,在一轮循环中，一个数组的第n项等于另一个数组的第n-1~n-6项的和。
 * 最后输出int[i]/pow(6,n)。
 */
public class Q60 {
        public double[] twoSum(int n) {
            int max_value = 6;
            double[] res = new double[(max_value-1)*n+1];
            if (n<1)
                return null;
            int[][] probabilities = new int[2][max_value*n+1];
            int flag = 0;
            for (int i=1;i<=max_value;i++)
                probabilities[flag][i] = 1;
            for (int k=2;k<=n;k++){
                for (int i=0;i<k;i++){
                    probabilities[1-flag][i] = 0;
                }
                for (int i=k;i<=max_value*k;i++){
                    probabilities[1-flag][i] = 0;
                    for (int j=1;j<=i&&j<=max_value;j++)
                        probabilities[1-flag][i] += probabilities[flag][i-j];
                }
                flag = 1-flag;
            }
            double total = Math.pow((double)max_value,n);
            for (int i=n;i<=max_value*n;i++){
                res[i-n] = probabilities[flag][i] /total;
            }
            return res;
        }
}
