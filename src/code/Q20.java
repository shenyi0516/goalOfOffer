package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/3/26 17:29
 */

/**
 * 给出一个字符串，判断该字符串是否为数字。
 * 分类讨论：
 * 1.不包含e的情况
 * 去除字符串开头和结尾的空格，判断第一位是否为+、-，如果是的话直接看后面的。
 * 1.1. 如果包含小数点，则以小数点前后进行划分，小数点之前只能为空、整数。小数点之后只能为空或者整数，但不能两边都为空。
 * 1.2 如果不包含小数点，则判断这个数是否为合法整数。
 * 2. 包含e的情况
 * 2.1 按e拆分成前后两个底数和指数，底数符合情况1，指数符合情况1.2
 * 总结步骤：
 * 0.先去掉字符串的空格和最前面的符号，然后依次判断是否为指数、小数、整数。
 * 1.函数一，判断是否为合法无符号整数。
 * 2.函数二，判断是否为合法小数。
 * 3.函数三，判断是否为合法指数。
 * 4.函数四，判断是否为合法整数。
 */
public class Q20 {
    public static boolean isNumber(String s) {
        if (s == null)
            return false;
        if (s.length() == 0)
            return false;
        s = s.trim();
        if(s.equals(""))
            return false;
        char[] chars = s.toCharArray();
        if(chars[0] == '+' ||chars[0] == '-')
            s = new String(chars,1,chars.length-1);
        int pointNum = s.indexOf(".");
        int eNum = Math.max(s.indexOf("e"),s.indexOf("E"));
        if(eNum != -1){
            return isExp(s,eNum);
        }else if(pointNum != -1){
            return isFloat(s,pointNum);
        }else {
            return isInteger(s);
        }
    }

    public static boolean isUnsignedInteger(String string) {
        char[] chars = string.toCharArray();
        if (string.equals("")){
            return false;
        }
        for (int i=0;i<string.length();i++){
            if(chars[i]<'0'|| chars[i]>'9')
                return false;
        }
        return true;
    }

    public static boolean isInteger(String string){
        char[] chars = string.toCharArray();
        if (string.equals(""))
            return false;
        if (chars[0] == '+' || chars[0] == '-'){
            String newString = new String(chars,1,chars.length-1);
            return isUnsignedInteger(newString);
        }else {
            return isUnsignedInteger(string);
        }
    }

    /**
     *
     * @param string 含小数点的字符串
     * @param pointNum 第一个小数点的位置
     * @return
     */
    public static boolean isFloat(String string, int pointNum){
        char[] chars = string.toCharArray();
        String before = new String(chars,0,pointNum);
        String after = new String(chars,pointNum+1,string.length()- 1 - pointNum);
        if(before.equals("") && after.equals("")){
            return false;
        }else if (before.equals("")){
            return isUnsignedInteger(after);
        }else if(after.equals("")){
            return isInteger(before);
        }else {
            return isInteger(before)&&isUnsignedInteger(after);
        }
    }

    public static boolean isExp(String string,int expNum){
        char[] chars = string.toCharArray();
        String base = new String(chars,0,expNum);
        String exp = new String(chars,expNum+1,string.length() - 1 - expNum);
        if (base.equals("") || exp.equals(""))
            return false;
        else {
            char[] baseChars = base.toCharArray();
            for(int i=0;i<base.length();i++){
                if(baseChars[i] == '.'){
                    return isFloat(base,i)&&isInteger(exp);
                }
            }
            return isInteger(base)&&isInteger(exp);
        }
    }

    public static void main(String[] args) {
        System.out.println(isNumber("+.8"));
    }
}
