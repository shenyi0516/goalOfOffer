package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/4/8 0:19
 */

/**
 * 约瑟夫环问题。
 * 给出递归方程：
 * f(n,m)=
 * [f(n-1,m)+m]%n n>1
 * 0 n=1;
 */
public class Q62 {
    public int lastRemaining(int n, int m) {
        if (n<1||m<1)
            return 1;
        int last = 0;
        for (int i=2;i<=n;i++)
            last = (last+m)%i;
        return last;
    }
}
