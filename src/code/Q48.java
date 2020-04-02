package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/4/2 21:57
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 最长不含重复字符的子字符串
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * 解题思路：
 * 采用动态规划的方法，给出状态转移方程。
 * f(n) = d(n)>f(n-1)?f(n-1)+1:d(n)
 * 需要额外的26长度的数组来保存每个字符上次出现的位置。
 * 注意事项：
 * 字符串为空
 * leetcode上面没有说输入一个一定是字母，所以长度为26的数组不够用，需要一个map或者是字典。
 * 也可以使用滑动窗口，使用两个指针，
 * 如果出现一个未出现的字符则快指针向前一格，并把字符加入set中
 * 如果出现一个set中已存在的字符，则快指针不动，慢指针向前移动至字符上次出现的位置，并且把经过的字符remove出set
 * 每次指针变化后与保存的最大值比较，如果比最大值大则更新最大值。
 */
public class Q48 {
    static public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int maxLength = 0;
        int curLength = 0;
        Map<Character,Integer> map = new HashMap<>();
        for (int i=0;i<chars.length;i++){
            if (!map.containsKey(chars[i])){
                map.put(chars[i],i);
                curLength += 1;
            }else {
                int dis = i - map.get(chars[i]);
                map.put(chars[i], i);
                if (dis>curLength){
                    curLength += 1;
                }else {
                    curLength = dis;
                }
            }
            if (curLength>maxLength)
                maxLength = curLength;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(" "));
    }
}
