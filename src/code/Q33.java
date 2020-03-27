package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/3/28 0:49
 */

import java.util.Arrays;

/**
 * 给出一组数字，判断该组数字是否为某个二叉搜索树的后序遍历。
 * 二叉搜索树满足以下条件：
 * 1.如果根节点的左子树不为空，那么左子树上所有节点的值小于根节点。
 * 2.如果根节点的右子树不为空，那么右子树上所有节点的值大于根节点。
 * 3.左右子树也为二叉搜索树。
 * 解题思路：
 * 给出一组数字，首先对其进行分割，最后一个为根节点，前面n个小于根节点的数为左子树。
 * 后面m个数为右子树，如果，右子树中存在小于根节点的节点，则该子树不合法。
 * 递归地进行判断左子树和右子树是否为合法的二叉搜索树。
 */
public class Q34 {
    static public boolean verifyPostorder(int[] postorder) {
        if (postorder == null)
            return false;
        if ( postorder.length == 0)
            return true;
        int root = postorder[postorder.length - 1];
        int i = 0;
        for (;i<postorder.length-1;i++){
            if(postorder[i]>root)
                break;
        }
        int j = i;
        for (;j<postorder.length-1;j++){
            if(postorder[j]<root)
                return false;
        }
        boolean left = true;
        if(i>0){
            int[] leftArr = Arrays.copyOf(postorder, i);
            left = verifyPostorder(leftArr);
        }
        boolean right = true;
        if(i<postorder.length - 1){
            int[] rightArr = Arrays.copyOfRange(postorder,i,postorder.length-1);
            right = verifyPostorder(rightArr);
        }
        return left&&right;
    }

    public static void main(String[] args) {
        int[] ints = {7,4,6,5};
        System.out.println(verifyPostorder(ints));
    }
}
