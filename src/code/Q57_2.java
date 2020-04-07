package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/4/4 20:55
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * 解题思路：
 * 1.按照上题的思路，同样设置两个指针。
 * p1设置在1处，p2设置在2处。
 * 如果p1+...+p2小于target
 * 则p2向后一位。
 * 如果等于则记录数组。
 * 如果大于则p1向后移动一位。
 * 2.利用求和公式。
 * (a1+an)n/2 = sum
 * an = a1+n-1
 * a1n+(n-1)n/2 = sum
 * 在已知sum情况下遍历n即可找到所有a1的值。
 * 由于(n-1)n/2是1到n-1的和，所以每次循环的时候只要target -= n++即可。
 *
 */
public class Q57_2 {
    public int[][] findContinuousSequence(int target) {
        ArrayList<int[]> result = new ArrayList<>();
        int i = 1;
        while (target > 0){
            target -= i++;
            int[] tmp = new int[i];
            if (target>0 && target%i == 0){
                for (int k = target/i,j=0;k<target/i+i;k++,j++){
                    tmp[j] = k;
                }
                result.add(tmp);
            }
        }
        Collections.reverse(result);
        return result.toArray(new int[0][]);
    }

    static public int[][] findContinuousSequence2(int target) {
        if (target<3)
            return null;
        ArrayList<int[]> result = new ArrayList<>();
        int left = 1;
        int right = 2;
        int middle = (1+target)/2;
        int curSum = left+right;
        while (left < middle){
            if (curSum == target){
                int[] tmp = new int[right-left+1];
                for (int i=left;i<right+1;i++)
                    tmp[i-left] = i;
                result.add(tmp);
                right++;
                curSum += right;
            }else if (target>curSum){
                right++;
                curSum += right;
            }else {
                curSum -= left;
                left++;
            }
        }
        return result.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        System.out.println(findContinuousSequence2(9));
    }
}
