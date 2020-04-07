package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/4/8 1:23
 */

/**
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，
 * 其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 * 解题思路：采用左右数组遍历法。
 * 设立一个数组C C[i]=A[0]*...*A[i-1]
 * 数组D D[i] = A[i+1]*...*A[n]
 * 最后的结果为int[i] =C[i]*D[i]
 * 其实以上操作可以在一个数组内完成。
 */
public class Q66 {
    public int[] constructArr(int[] a) {
        if (a == null || a.length<2)
            return a;
        int[] res = new int[a.length];
        res[0] = 1;
        for (int i=1;i<a.length;i++)
            res[i] = res[i-1]*a[i-1];
        int temp= 1;
        for (int i=a.length-2;i>=0;i--){
            temp *= a[i+1];
            res[i] *= temp;
        }
        return res;
    }
}
