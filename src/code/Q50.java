package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/4/2 23:36
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格
 * 解题思路：
 * 由于输入的是字符，那么可以创建一个hash表用来存储，
 * 出现过1次的字符值为true，否则为false。
 * 最后遍历hash表返回第一个为true的key
 * 使用256位的数组则速度更快，但是空间更大。
 */
public class Q50 {
    public char firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        //这里还可以使用int[] arr = int[256];
        Map<Character,Boolean> map = new HashMap<>();
        for (int i=0;i< chars.length;i++){
            if (!map.containsKey(chars[i]))
                map.put(chars[i],true);
            else
                map.put(chars[i],false);
        }
        for (char c:chars)
            if (map.get(c))
                return c;
        return ' ';
    }
}
