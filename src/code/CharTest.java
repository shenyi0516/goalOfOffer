package code;

/**
 * @author Shen Yi
 * @version 1.0
 * @date 2020/3/26 18:25
 */
public class CharTest {
    public static void main(String[] args) {
        int[] nums = {7,9,6,4};
        int[] helper = {5,7};
        System.arraycopy(helper,0,nums,0,helper.length);
        int[] newNums = nums;
    }
    public static void number(TreeNode node){
        node = new TreeNode(1);
    }
}
