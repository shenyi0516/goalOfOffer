package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/4/1 16:41
 */

import java.util.HashSet;
import java.util.LinkedList;

/**
 * 字符串的排列
 * 给出一个字符串，返回其所有字符的排列组合，返回值中不能有重复的元素。
 * 解题思路：用DFS可以很好地解决这个问题。
 * 先固定一个字符，然后固定第二位字符，以此类推，可以得到所有字符串的排列组合。
 * 每次固定字符时，把当前位置的字符依次和后面的字符进行交换，判断组合中是否已经存在了该字符，如果不存在的话则加入字符，否则返回。
 */
public class Q38 {
    LinkedList<String> res = new LinkedList<>();
    char[] c;
    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    private void dfs(int x) {
        if(x == c.length -1 ){
            res.add(String.valueOf(c));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for(int i = x;i<c.length;i++){
            if(set.contains(c[i]))
                continue;
            set.add(c[i]);
            swap(i, x);
            dfs(x+1);
            swap(i, x);
        }
    }

    void swap(int a,int b){
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }
}
