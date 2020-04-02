package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/4/2 21:12
 */

/**
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、
 * 直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，
 * 请计算你最多能拿到多少价值的礼物？
 * 解题思路：使用动态规划。
 * 给出状态转移方程f(i,j)=Max(f(i-1,j),f(i,j-1))+value(i,j);
 * 初始化边界状态f(0,0)、f(0,j)、f(i,0)
 * 考虑特殊情况：空矩阵、只有一行、一列、一格的矩阵。
 * 如果不能修改原数组的话，需要grid.length的长度空间用来存放结果。
 * dp[j] = Math.max(dp[j],dp[j-1])+grid[i-1][j-1];
 * dp中前面j个数字表示第i行前面j个格子的礼物的最大价值
 * 后面n-j个格子保存i-1行n-j个格子礼物最大价值。
 */
public class Q47 {
    public int maxValue(int[][] grid) {
        if(grid == null)
            return 0;
        for (int i=1;i<grid.length;i++)
            grid[i][0] = grid[i-1][0]+grid[i][0];
        for (int j=1;j<grid[0].length;j++)
            grid[0][j] = grid[0][j-1]+grid[0][j];
        for (int i=1;i<grid.length;i++)
            for (int j=1;j<grid[0].length;j++){
                grid[i][j] = Math.max(grid[i-1][j],grid[i][j-1])+grid[i][j];
            }
        return grid[grid.length-1][grid[0].length-1];
    }
    public int maxValue2(int[][] grid) {
        int M = grid.length, N = grid[0].length;
        int[] dep = new int[N+1];
        for (int i = 1; i<=M; i++){
            for (int j = 1; j <=N; j++){
                dep[j] = Math.max(dep[j],dep[j-1])+grid[i-1][j-1];
            }
        }
        return dep[N];
    }
}
