package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/3/27 18:05
 */

/**
 * 给出一个矩阵按照顺时针输出矩阵中的值。
 * 解题思路：
 * 循环的条件：(columns >startX*2 && row > startY*2)
 * 如何进行打印：
 * 1.从左到右，这一步是必须的。
 * 2.从上到下，这一步不是必须的，当start< rows-1-start的时候，不需要从上到下输出。
 * 3.从右到左，这一步至少需要两行两列，所以start<rows-1-start && start < columns-1-start
 * 4.从下到上，这一步至少需要三行两列，所以start<rows-1-start && start < columns-2-start
 */
public class Q29 {
    static int[] result;
    static int counter;
    static public int[] spiralOrder(int[][] matrix) {
        result = new int[0];
        if(matrix == null || matrix.length <= 0 || matrix[0].length <= 0)
            return result;
        int start = 0;
        counter = 0;
        result = new int[matrix.length*matrix[0].length];
        while (matrix.length>start*2&&matrix[0].length>start*2){
            PrintfMatrix(matrix,start);
            start++;
        }
        return result;
    }

     static private void PrintfMatrix(int[][] matrix, int start) {
        int endX = matrix.length-1-start;
        int endY = matrix[0].length-1-start;
        for(int i=start;i<=endX;i++){
            result[counter++] = matrix[start][i];
        }
        if(start < endY){
            for(int i=start+1;i<=endY;i++){
                result[counter++] = matrix[i][endX];
            }
        }
        if (start< endY&&start<endX){
            for (int i=endX-1;i>=start;i--)
                result[counter++] = matrix[endY][i];
        }
        if (start<endY-1&&start<endX){
            for (int i=endY-1;i>start;i--)
                result[counter++] = matrix[i][start];
        }
    }

}
