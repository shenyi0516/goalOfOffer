package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/4/4 22:08
 */

/**
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。
 * 例如输入字符串"I am a student. "，则输出"student. a am I"。
 */
public class Q58 {
    public String reverseWords(String s) {
        String[] strings = s.split("//s+");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=strings.length - 1;i>=0;i--) {
            if (!strings[i].equals(" "))
                stringBuilder.append(strings[i]+" ");
        }
        return stringBuilder.toString().trim();
    }
}
