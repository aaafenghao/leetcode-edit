package leetcode.editor.cn;

import leetcode.editor.cn.tree.TreeNode;

/**
 * Git 的最近公共祖先
 */
public class GitParent {

    public static void main(String[] args) {

    }

    TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q){
        if(root == null){
            return null;
        }
        if(p == root || q == root){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        //后序遍历--从下到上的第一次相遇
        if(left != null && right != null){
            return root;
        }
        if(left == null && right == null){
            return null;
        }
        return left == null?right:left;
    }
}
