package code;

/**
 * 给出二叉树的某个节点，输出中序遍历的下一个节点。二叉树含有左右子树的指针之外还有父节点的指针。
 * 考虑如下情况：
 * 1.该节点既有左子树又有右子树，那么下一个节点为右子树中最左边那个节点。
 * 2.该节点没有右子树，那么如果该节点是父节点的左子树，那么下一个节点就是父节点。
 * 3.该节点没有右子树，那么如果该节点是父节点的右子树，那么一直向上遍历，找一个节点i，i为i父亲节点的左子节点，那么i就是下一个节点，如果最后遍历到根节点，那么该节点是最后一个节点。
 */
public class Q08 {
    static class TreeNode{
        TreeNode father = null;
        TreeNode left = null;
        TreeNode right = null;
        char value;
        TreeNode(char value){
            this.value = value;
        }
        public TreeNode addLeft(char cr){
            TreeNode left = new TreeNode(cr);
            this.left = left;
            left.father = this;
            return left;
        }
        public TreeNode addRight(char cr){
            TreeNode right = new TreeNode(cr);
            this.right = right;
            right.father = this;
            return right;
        }
    }

    static public TreeNode GetNext(TreeNode node){
        if(node == null){
            System.out.println("");
            return null;
        }
        if(node.right != null){
            System.out.println(getRightLeft(node.right).value);
            return getRightLeft(node.right);
        }
        else if (node.father != null){
            TreeNode father =node.father;
            if(father.left == node){
                System.out.println(node.father.value);
                return father;
            }else {
                TreeNode next = findFatherLeft(father);
                if(next != null)
                    System.out.println(next.value);
                else
                    System.out.println("");
                return findFatherLeft(father);
            }
        }
        else {
            System.out.println("");
            return null;
        }
    }

    static public TreeNode findFatherLeft(TreeNode node) {
        TreeNode father = node.father;
        if (father == null)
            return null;
        if(father.left == node){
            return node;
        }else {
            return findFatherLeft(father);
        }
    }

    static public TreeNode getRightLeft(TreeNode node) {
        if(node.left != null){
            return getRightLeft(node.left);
        }else {
            return node;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode('a');
        TreeNode b = root.addLeft('b');
        TreeNode d = b.addLeft('d');
        TreeNode e = b.addRight('e');
        TreeNode h = e.addLeft('h');
        TreeNode i = e.addRight('i');
        TreeNode c = root.addRight('c');
        TreeNode f = c.addLeft('f');
        TreeNode g = c.addRight('g');
//        GetNext(root);
//        GetNext(e);
//        GetNext(g);
//        GetNext(f);
        GetNext(i);
    }
}
