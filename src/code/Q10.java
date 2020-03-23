package code;

/**
 *斐波那契数列，基本没有什么好说的，采用递推或者递归的方式就行了。
 * 采用递归的话可能会超时，采用递推的方式的话可以先保存到数组，这样的话速度更快一些。
 * 还存在一个nlogn的方法，涉及到矩阵乘法。
 */
public class Q10 {
    int[] array = new int[101];
    public int fib(int n) {
        if(n == 0 || n== 1)
            return n;
        else {
            array[0] = 0;
            array[1] = 1;
            for(int i=2;i<=n;i++){
                array[i] = (array[i-1]+array[i-2])%1000000007;
            }
            return array[n];
        }
    }
}
