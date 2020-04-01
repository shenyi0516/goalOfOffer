package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/4/1 17:12
 */

/**
 * 给出一个字符串，字符串中有一个字符出现的次数超过一半，请找出这个字符。
 * 解题思路：摩尔投票法。
 * 为构建正负抵消，假设数组首个元素 n1为众数，遍历统计票数，
 * 当发生正负抵消时，剩余数组的众数一定不变 ，这是因为真正的众数为x。
 * 利用此特性，每轮假设都可以 缩小剩余数组区间 。
 * 当遍历完成时，最后一轮假设的数字即为众数（由于众数超过一半，最后一轮的票数和必为正数）
 * 令vote=0 为投票数。
 * 当vote==0 时，假设当前位置上的数字为众数。
 * 如果下一个数字相同，则vote++，否则vote--
 * 返回最后假设的结果。
 * 如果输入字符串中不一定出现超过一半的字符，则还需要验证最后的结果是否出现次数超过一半。
 */
public class Q39 {
    public int majorityElement(int[] nums) {
        int vote = 0;
        int x = 0;
        int counter = 0;
        for(int num:nums){
            if (vote == 0) x=num;
            if(x == num)
                vote++;
            else
                vote--;
        }
//        return x;
        //验证
        for(int num:nums){
            if(num == x)
                counter++;
        }
        return counter>nums.length/2?x:0;
    }
}
