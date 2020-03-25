package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/3/25 22:15
 */

/**
 * 输入一个n，按顺序打印出从1到最大的n位十进制数。
 * 主要考虑的是题目中没有说n的大小，n位的十进制数非常容易越界。
 * 这道题在LeetCode上直接返回Int[]其实没什么意思，这里直接考虑大数问题。
 */
public class Q17 {
   static public void printNumbers(int n) {
        if(n<=0)
            return;
        int[] number = new int[n];
        while (!Increment(number)){
            PrintNumber(number);
        }
    }

    /**
     * 判断是否达到最大数字的同时给数组+1，超过到最大数字之后返回true
     * @param number
     * @return
     */
    static boolean Increment(int[] number){
        boolean isOverFlow = false;
        int nTakeOver = 0;
        for(int i = number.length - 1;i>=0;i--){
            int nSum = number[i] + nTakeOver;
            if(i == number.length-1)
                nSum++;
            if(nSum >= 10){
                if(i == 0)
                    isOverFlow = true;
                else {
                    nSum -= 10;
                    nTakeOver = 1;
                    number[i] = nSum;
                }
            }
            else {
                number[i] = nSum;
                break;
            }
        }
        return isOverFlow;
    }

    /**
     * 输出数字，这里要注意的是不要输出最前面的0，但是如果单纯判断0就不输出的话会导致中间含有0的数字输出不正常
     * 所以一边要判断是不是0，一边要判断前面是否输出过数字了。
     * @param number
     */
    static void PrintNumber(int[] number){
       boolean isBeginZero = true;
        for(int i = 0;i<number.length;i++){
            if (isBeginZero && number[i]!=0)
                isBeginZero = false;
            if (!isBeginZero)
                System.out.print(number[i]);
        }
        System.out.print('\t');
    }

    public static void main(String[] args) {
        printNumbers(3);
    }
}
