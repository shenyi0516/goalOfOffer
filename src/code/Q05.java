package code;

/**
 * 字符串空格替换
 * JAVA和C#中的string都是不可变的，即使修改也是改变了引用，所以直接使用stringBuilder和stringBuffer比较合适
 */
public class Q05 {
    static String string = "We are happy";
    static String string1 = "Wearehappy";
    static String string2 = "We  are happy";
    static String string3 = "";
    static String string4 = " ";
    static String string5 = null;
    static String string6 = " We are happy";//头部有空格
    static String string7 = "We are happy ";//尾部有空格

    static String ReplaceBlank(String string){
        if(string == null || string.length() <= 0){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i< string.length();i++){
            if(String.valueOf(string.charAt(i)).equals(" ")){
                sb.append("%20");
            }else {
                sb.append(string.charAt(i));
            }
        }

        return String.valueOf(sb);
    }

    public static void main(String[] args) {
        System.out.println(ReplaceBlank(string));
        System.out.println(ReplaceBlank(string1));
        System.out.println(ReplaceBlank(string2));
        System.out.println(ReplaceBlank(string3));
        System.out.println(ReplaceBlank(string4));
        System.out.println(ReplaceBlank(string5));
        System.out.println(ReplaceBlank(string6));
        System.out.println(ReplaceBlank(string7));
    }

}
