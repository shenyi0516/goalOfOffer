package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/4/8 1:12
 */

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 * 解题思路：
 * 使用位运算，a+b等价于a^b+((a&b)<<1)。
 * 令a=(a&b)<<1,b=a^b,直至a=0说明进位完毕。
 */
public class Q65 {
    public int add(int a, int b) {
        while (a!=0){
            int tmp = a^b;
            a = ((a&b)<<1);
            b = tmp;
        }
        return b;
    }
}
