package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/4/2 23:12
 */

/**
 * 把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。
 * 求按从小到大的顺序的第 n 个丑数。
 * 解题思路：
 * 采用动态规划的方法。
 * 对于丑数来说，必定为前面某个丑数乘以因子的积。
 * 设动态规划列表dp，dp[i]代表第i+1个丑数。
 * dp[i]满足方程：
 * dp[a]*2>dp[i-1]>dp[a-1]*2
 * dp[b]*3>dp[i-1]>dp[b-1]*3
 * dp[c]*5>dp[i-1]>dp[c-1]*5
 * 每轮计算dp[i]后，需要更新索引a,b,c 的值，使其始终满足方程条件，以便下轮计算。
 * 实现方法：分别独立判断 dp[i]和dp[a]×2 ,dp[b]×3 ,dp[c]×5 的大小关系，
 * 若相等则将对应索引 a , b , c 加 1 。
 * dp[i] = min(dp[a]*2,dp[b]*3,dp[c]*5)
 */
public class Q49 {
    public int nthUglyNumber(int n) {
        int a = 0,b = 0,c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i=1;i<n;i++){
            dp[i] = Math.min(Math.min(dp[a]*2,dp[b]*3),dp[c]*5);
            if (dp[i] == dp[a]*2) a++;
            if (dp[i] == dp[b]*3) b++;
            if (dp[i] == dp[c]*5) c++;
        }
        return dp[n-1];
    }
}
