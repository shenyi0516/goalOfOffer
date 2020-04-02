package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/4/2 20:41
 */

/**
 * 把数字翻译成字符串。
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * 解题思路：
 * 使用动态规划的方法，从最后一位开始计算翻译方法。
 * 给出状态转移方程：f(n) = f(n+1)+g(n,n+1)f(n+2)
 * 其中g(n,n+1)为第n位和第n+1位数字拼接起来是否在10~25范围内，
 * 是的话为1否则为0.
 * 注意事项：给出负数、0、25、26。
 */
public class Q46 {
    static public int translateNum(int num) {
        if(num < 0)
            return -1;
        char[] number = String.valueOf(num).toCharArray();
        if (number.length == 1)
            return 1;
        int[] count = new int[number.length];
        count[number.length-1] = 1;
        if (isIn10and25(number[number.length-2],number[number.length-1])){
            count[number.length-2] = 2;
        }else{
            count[number.length-2] = 1;
        }
        for (int i = number.length-3;i>=0;i--){
            if (isIn10and25(number[i],number[i+1]))
                count[i] = count[i+1] + count[i+2];
            else
                count[i] = count[i+1];
        }
        return count[0];
    }

    /**
     * 判断是否在10~25之间，是的话返回true；
     * @param num1 高位
     * @param num2 低位
     * @return
     */
    static boolean isIn10and25(char num1,char num2){

        if(num1-'0'<0 || num1-'0'>9 || num2-'0'<0||num2-'0'>9)
            return false;
        int res = Integer.valueOf(num1-'0')*10+Integer.valueOf(num2-'0');
        return (res>=10)&&(res<=25);
    }

    public static void main(String[] args) {
        System.out.println(translateNum(12258));
    }
}
