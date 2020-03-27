package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/3/27 16:51
 */

/**
 * 给出树A，树B,判断树B是否是树A的子树。
 * 解题思路:首先递归地查找树A中是否包含有与树B根节点相同值的节点。
 * 如果存在，则递归地判断该节点的左子树和右子树是否和树B相同，如果相同则返回true，不相同的话则继续递归。
 * 值得注意的地方：
 * 输入两个为空的树。
 * 计算机中比较double类型的数由于存在精度问题，所以不能直接比较。
 * java中可以使用1.设定误差范围，abs(a-b)小于设定的范围则说明相等。
 * 2.使用BigDecimal，BigDecimal只能由字符串构建，所以需要使用valueOf
 */
public class Q26 {
    boolean isSubStructure(TreeNode A, TreeNode B){
        boolean result  = false;
        if(A != null && B != null){
            if(Equal(A.val, B.val)){
                result = IsTree1HaveTree2(A,B);
            }
            if(!result)
                result = isSubStructure(A.left,B);
            if(!result)
                result = isSubStructure(A.right,B);
        }
        return result;
    }

    public boolean IsTree1HaveTree2(TreeNode pRoot1, TreeNode pRoot2) {
        if (pRoot2 == null)
            return true;
        if(pRoot1 == null)
            return false;
        if(!Equal(pRoot1.val,pRoot2.val))
            return false;
        return IsTree1HaveTree2(pRoot1.left,pRoot2.left)&&IsTree1HaveTree2(pRoot1.right,pRoot2.right);
    }

    public boolean Equal(int val, int val1) {
       return Math.abs(val-val1)<0.0000001;
    }
}
