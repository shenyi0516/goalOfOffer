package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/4/4 22:26
 */

/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 * 解题思路：使用substring函数
 * substring函数会修改原字符串。
 */
public class Q58_2 {
    public String reverseLeftWords(String s, int n) {
//        String s1 = s.substring(0,n);
//        String s2 = s.substring(n);
//        return s2+s1;
        //不需要创建新的字符串对象，所以速度更快。
        return s.substring(n) + s.substring(0,n);
    }
}
