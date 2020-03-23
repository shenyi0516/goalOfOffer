package code;

public class Q07_2 {
    /**
     * 别人的方法，速度较快
     */
  static public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
  }

    int inIndex=0;
    int preIndex=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder,inorder,(long)Integer.MAX_VALUE+1);
    }
    public TreeNode helper(int[] preorder,int[] inorder,long stop){
        if(preIndex>=preorder.length){
            return null;
        }
        if(inorder[inIndex]==stop){
            inIndex++;
            return null;
        }
        int val=preorder[preIndex++];
        TreeNode root=new TreeNode(val);
        //使用两个全局变量来指示pre和in中那些变量已经遍历过了，左子树先进行遍历，遍历完之后指针的位置刚好指在右子树的区间上，遍历右子树。
        root.left=helper(preorder,inorder,val);
        root.right=helper(preorder,inorder,stop);
        return root;
    }
}
