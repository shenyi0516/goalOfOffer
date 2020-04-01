package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/4/2 0:00
 */

/**
 * 给出一个数字序列，返回其中第n位的数字。
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 * 对于求第1001位的数字来说，
 * 前10位是0~9，接下来的180位是10~99，接下来2700位是100~999,1001-10-180=811<2700，所以在3位数中。
 * 3位数每位占3个格子，所以811=270*3+1，即100后面第270个数字，370的中间一位7。
 */
public class Q44 {
    public static int findNthDigit(int n) {
        if (n<0)
            return -1;
        int digits = 1;
        while (true){
            //注意溢出
            long numbers = countOfIntegers(digits);
            if (n<numbers*digits)
                return digitAtIndex(n,digits);
            n -= digits*numbers;
            digits++;
        }
    }

    /**
     * 计算不同位数的数字有多少个。
     * @param digits
     * @return
     */
    static int countOfIntegers(int digits){
        if (digits == 1)
            return 10;
        else
            return 9*(int)Math.pow(10,digits-1);
    }
    static int digitAtIndex(int index,int digits){
        //注意溢出
        long number = beginNumber(digits)+index/digits;
        int indexFromRight = digits-(index%digits);
        for (int i =1;i<indexFromRight;i++)
            number /= 10;
        return (int)number%10;
    }
    static long beginNumber(int digits){
        if (digits == 1)
            return 0;
        return (long)Math.pow(10,digits-1);
    }

    public static void main(String[] args) {
        System.out.println(findNthDigit(1000000000));
    }
}
