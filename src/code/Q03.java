package code;

public class Q03 {
    static int[] arr1 = {2, 3, 1, 0, 2, 5, 3};
    static int[] arr2 = {2, 3, 1, 0, 2, 5, 9};
    static int[] arr3 = {};
    static int[] arr4 = null;
    static int[] arr5 = {2, 3, 1, 0, 2, 5, -1};
    static int[] arr6 = {2, 3, 5, 4, 3, 2, 6, 7};
    static int[] arr7 = {1, 2, 3};
    /**
     * 找出任意一个重复的数字, 可以改变数组
     * @param numbers
     * @return
     */
    static boolean duplicate(int[] numbers){
        if(numbers == null || numbers.length <= 0)
            return false;
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] > numbers.length - 1 || numbers[i] < 0)
                return false;
        }
        for (int i = 0; i< numbers.length; i++){
            while (numbers[i] != i){
                if(numbers[i] == numbers[numbers[i]]){
                    System.out.println(numbers[i]);
                    return true;
                }
                int temp = numbers[i];
                numbers[i] = numbers[numbers[i]];
                numbers[temp] = temp;

            }
        }
        return false;
    }

    /**
     * 数组长度为n+1，数组中的数字都在1~n之间，找出任意一个重复的数字
     * @param numbers
     * @return
     */
    static int getDuplicate(int[] numbers){
        if(numbers == null || numbers.length <= 0)
            return -1;
        int end = numbers.length - 1;
        int start = 1;
        while (end >= start){
            int middle = (end - start)/2 +start;
            int count = getCount(start, end, numbers);
            if (start == end){
                if(count > 1)
                    return start;
                else
                    break;
            }
            if(count > end - start + 1){
                end = middle;
            }else {
                start = middle + 1;
            }
        }

        return -1;
    }

    static int getCount(int start, int end, int[] numbers){
        if(numbers == null)
            return 0;
        int count = 0;
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] <= end && numbers[i] >= start){
                count ++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(getDuplicate(arr7));
    }
}
