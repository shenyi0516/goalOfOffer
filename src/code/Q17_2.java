package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/3/25 22:51
 */

/**
 * 题目同上，采用递归的方式输出。
 * 当输出1~999时，可以考虑
 */
public class Q17_2 {
    public static void printToMaxOfNDigits(int n) {
        int[] array=new int[n];
        if(n <= 0)
            return;
        printArray(array, 0);
    }

    private static void printArray(int[] array,int n) {
        for(int i = 0; i < 10; i++) {
            if(n != array.length) {
                array[n] = i;
                printArray(array, n+1);
            } else {
                boolean isFirstNo0 = false;
                for(int j = 0; j < array.length; j++) {
                    if(array[j] != 0) {
                        System.out.print(array[j]);
                        if(!isFirstNo0)
                            isFirstNo0 = true;
                    } else {
                        if(isFirstNo0)
                            System.out.print(array[j]);
                    }
                }
                System.out.println();
                return ;
            }
        }
    }


    public static void main(String[] args) {
        printToMaxOfNDigits(2);
    }
}
