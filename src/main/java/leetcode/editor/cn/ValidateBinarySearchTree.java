//给定一个二叉树，判断其是否是一个有效的二叉搜索树。 
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索

package leetcode.editor.cn;
public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new ValidateBinarySearchTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        //首先想到的是根据二叉树的特性进行比较
        //可以进行中序遍历,然后进行比较大小
        return helper(root,null,null);
    }

    private boolean helper(TreeNode node, Integer lower, Integer upper) {
        if(node == null){
            return true;
        }
        int val = node.val;
        if(lower != null && lower.intValue() >= val ){
            return false;
        }
        if(upper != null && upper.intValue() <= val){
            return false;
        }

        if(!helper(node.left,lower,val)){
            return false;
        }
        if(!helper(node.right,val,upper)){
            return false;
        }
        return true;
    }


    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
//leetcode submit region end(Prohibit modification and deletion)

}