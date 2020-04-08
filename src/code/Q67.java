package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/4/8 16:46
 */

import javax.management.MBeanTrustPermission;

/**
 * 写一个函数 StrToInt，实现把字符串转换成整数这个功能。
 * 解题思路：主要要考虑多种边界情况。
 * 首先去除字符串中前后所有的空格。
 * 然后判断第一个字符是否为数字、正负号，如果不是则返回0
 * 如果是则判断到第几个字符为止是数字。
 * 如果只有一个正负号则返回。
 * 根据不同的情况生成数字最后返回。
 */
public class Q67 {
    static public int strToInt(String str) {
        if (str == null || str.length() <=0)
            return 0;
        str = str.trim();
        if (str.length()<=0)
            return 0;
        char[] numbers = str.toCharArray();
        if ((numbers[0]<'0'||numbers[0]>'9')&&(numbers[0]!='-')&&(numbers[0]!='+'))
            return 0;
        int end = 0;
        for (int i=1;i<str.length();i++){
            if (numbers[i]<='9'&&numbers[i]>='0'){
                end = i;
            }else {
                break;
            }
        }
        if (end == 0 && (numbers[0] == '-' || numbers[0] == '+'))
            return 0;
        long res = 0;
        if (numbers[0] == '+'){
            str = str.substring(1,end+1);
            for(int i=0;i<str.length();i++){
                res = res*10+(str.charAt(i)-'0');
                if (res>Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;
            }
            return (int)res;
        }else if (numbers[0] == '-'){
            str = str.substring(1,end+1);
            for(int i=0;i<str.length();i++){
                res = res*10+(str.charAt(i)-'0');
                if (-res<Integer.MIN_VALUE)
                    return Integer.MIN_VALUE;
            }
            return (int)-res;
        }else {
            str = str.substring(0,end+1);
            for(int i=0;i<str.length();i++){
                res = res*10+(str.charAt(i)-'0');
                if (res>Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;
            }
            return (int)res;
        }
    }

    public static void main(String[] args) {
        System.out.println(strToInt("3.14159"));
    }
}
