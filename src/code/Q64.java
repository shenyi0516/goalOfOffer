package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/4/8 1:02
 */

/**
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * 解题思路：
 * 1.利用构造函数。
 * 2.利用&&的短路机制。
 */
public class Q64 {
    public int sumNums(int n) {
        int sum = n;
        boolean b = (n > 0) && ((sum += sumNums(n - 1)) > 0);
        return sum;
    }
}
