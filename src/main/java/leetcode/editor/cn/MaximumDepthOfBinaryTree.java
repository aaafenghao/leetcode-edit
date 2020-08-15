//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索

package leetcode.editor.cn;


import java.util.LinkedList;

public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new MaximumDepthOfBinaryTree().new Solution();
        Integer[] array = new Integer[]{3,9,20,null,null,15,7};
        TreeNode root = MaximumDepthOfBinaryTree.createTree(array, 0);
        int i = solution.maxDepth1(root);
        System.out.println(i);
    }

    public static TreeNode createTree(Integer[] array,int index){
        TreeNode node = null;
        if(array.length > index){
            Integer value = array[index];
            if(value == null){
                return null;
            }
            node = new TreeNode(value);
            node.left = createTree(array,2 * index +1);
            node.right = createTree(array, 2 * index + 2);
            return node;
        }
        return node;
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
    /**
     * 递归实现
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }else{
            int left_i = maxDepth(root.left);
            int right_i = maxDepth(root.right);
            return Math.max(left_i,right_i)+1;
        }

    }

    public int maxDepth1(TreeNode root){
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int maxDepth = 0;
        while (!queue.isEmpty()){
            maxDepth ++;
            int size = queue.size();
            for (int i = 0;i<size;i++){
                TreeNode treeNode = queue.pollFirst();
                if(treeNode.left != null){
                    queue.add(treeNode.left);
                }
                if(treeNode.right != null){
                    queue.add(treeNode.right);
                }
            }
        }
        return maxDepth;
    }




}
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
//leetcode submit region end(Prohibit modification and deletion)

}