package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/3/24 1:30
 */

/**
 * 旋转数组的最小数字。
 * 考虑三种情况：
 * 1.正常情况下，移动了i个数到数组的末尾，i>0，那么array[0]一定大于array[n]，这种情况下可以直接使用二分查找，
 * 当mid>right时，说明在后面的递增数组，left=mid+1。
 * 2.当i=0时，直接返回array[0]，也就是array[0]<array[n]
 * 3.当数组中存在相同元素的时候，如果出现left=right=mid的情况，只能按照顺序查找。
 * 事实上我觉得，如果出现left=right，完全可以把right向前移动，直至不相等。
 */
public class Q11 {
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length-1;
        if(numbers[left]<numbers[right])
            return numbers[0];
        while (left<right){
            int mid = (left+right)/2;
            if(numbers[mid]>numbers[right])
                left = mid+1;
            else if(numbers[mid] < numbers[right])
                right = mid;
            else
                right--;
        }
        return numbers[left];
    }
}
