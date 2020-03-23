package code;

/**
 * 一个二维数组，每一行都按从左到右的方式递增，每一列都以从上到下的方式递增，输入一个整数，判断二维数组中是否含有这样一个整数。
 */
public class Q04 {
    static int[][] arr = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
    static int number = 6;
    static boolean Find(int[][] arr, int number){
        if(arr == null)
            return false;
        //没有考虑到输入矩阵为空矩阵的情况 输入[],0
        if(arr.length <= 0)
            return false;
        int row = 0;
        int columns = arr[row].length - 1;
        while (row < arr.length && columns >= 0){
            if(arr[row][columns] == number){
                System.out.println(""+row+"\t"+columns);
                return true;
            }else if(arr[row][columns] > number){
                columns --;
            }else {
                row ++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(Find(arr, number));
    }
}
