package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/3/25 15:02
 */

/**
 * 矩阵中的路径，输入一个矩阵和字符串，判断是否存在一条路径包含所有的字符，同一个格子不能重复进入两次。
 * 思路：DFS+剪枝
 * 当进入一个点的时候，输入参数为当前元素在矩阵 board 中的行列索引 i 和 j ，当前目标字符在 word 中的索引 k 。
 * 剪枝情况：
 * 1.矩阵越界。
 * 2.当前元素不等于目标字符。
 * 3.当前位置已经访问过。
 * 递推工作：
 * 1.标记当前元素。
 * 2.探索下一个单元格。
 * 3.还原当前元素。
 * 特殊测试用例：
 * 1.边界值，只有一行或者一列的矩阵，矩阵和路径中所有字母都是相同的。
 * 2.空指针。
 */
public class Q12 {
    public static boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[i].length;j++){
                if(dfs(board,chars,i,j,0)) return true;
            }
        }
        return false;
    }

   public static boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if(i<0||j<0||i>=board.length||j>=board[i].length||board[i][j]!=word[k])
            return false;
        if(k == word.length-1)//退出条件
            return true;
        //标记该单元格已经访问过。
       char tmp = board[i][j];
       board[i][j] = '/';
       boolean res = dfs(board, word, i, j-1, k+1)||dfs(board,word,i,j+1,k+1)||dfs(board,word,i+1,j,k+1)||dfs(board,word,i-1,j,k+1);
       board[i][j]=tmp;
       return res;
    }

    public static void main(String[] args) {
        char[][] board = {{'a'}};
        String word = "ab";
        System.out.println(exist(board,word));
    }
}
