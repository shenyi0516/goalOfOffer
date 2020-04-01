package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/4/2 0:52
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给出一个正整数数组，把数组中所有的数拼接起来成为一个数，返回其中最小的一个。
 * 解题思路：
 * 利用自定义字符串排序的方法，如果s1+s2<s2+s1，则返回s1+s2。
 * 字符串排序完成之后再把字符串拼接起来。
 */
public class Q45 {
    public String minNumber(int[] nums) {
        List<String> stringList = new ArrayList<>();
        for (int num:nums){
            stringList.add(String.valueOf(num));
        }
        stringList.sort((s1,s2)->(s1+s2).compareTo(s2+s1));
        StringBuilder res = new StringBuilder();
        for (String str:stringList){
            res.append(str);
        }
        return res.toString();
    }
}
