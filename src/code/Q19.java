package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/3/26 0:03
 */

/**
 * 请实现一个函数用来匹配包含'. '和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
 * 采用dp的方式，从后往前给出状态转移方程。
 * 给定dp[i][j]，dp[i][j]的值为比较s[0：i-1]和p[0:j-1]的结果。
 * 1.if(s[i-1] == p[j-1])
 * 此时，dp[i][j] = dp[i-1][j-1]
 * 2.if(s[i-1] != p[j-1])
 * 2.1 if(p[j-1] == '.') dp[i][j] = dp[i-1][j-1]
 * 2.2 if(p[j-1] == '*') 此时需要往前j需要往前一位
 * 2.2.1 if(p[j-2] == s[i-1] || p[j-2] == '.') dp[i][j] = dp[i-1][j]
 * 2.2.2 if(p[j-2] != s[i-1]) dp[i][j] = dp[i][j-2]
 * 2.3 if(p[j-1] != '.'&& p[j-1] != '*') dp[i][j] = false
 * 最后返回dp[s.length][p.length]
 */
public class Q19 {
    static public boolean isMatch(String s, String p) {
        char[] charS = s.toCharArray();
        char[] charP = p.toCharArray();
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        if(s.length() == 0 && p.length() == 0)
            return true;
        //这边需要对第一行进行初始化，当p以"x*"类型开头的时候dp[0][2]应该等于true
        for(int j=1;j<=p.length();j++)
        {
            //p[j-1]为*可以把j-2和j-1处的字符删去，只有[0,j-3]都为true才可以
            //因此dp[j-2]也要为true，才可以说明前j个为true
            if(p.charAt(j-1)=='*'&&dp[0][j-2])
                dp[0][j] = true;
        }
        for(int i = 1;i<s.length()+1;i++){
            for(int j = 1;j<p.length()+1;j++){
                if(charS[i-1] == charP[j-1]){
                    dp[i][j] = dp[i-1][j-1];
                }else if(charP[j-1] == '.'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(charP[j-1] == '*'){
                    if(j == 1)
                        dp[i][j] = false;
                    else if(charP[j-2] == charS[i-1] || charP[j-2] == '.'){
                        //这边需要进行特殊处理，当输入"aaa"和"ab*a*c*a"时，dp[1][5]即可以为dp[0][5]也可以为dp[1][3]
                        //即当出现"a"和"a*"a*既可以为0也可以为多个字符，所以此时需要进行或操作，只要其中有一个为true即可。
                        dp[i][j] = dp[i-1][j] || dp[i][j-2];
                    }else {
                        dp[i][j] = dp[i][j-2];
                    }
                }else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        System.out.println(isMatch("",
                ".*"));
    }
}
