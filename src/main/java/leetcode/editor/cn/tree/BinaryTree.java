package leetcode.editor.cn.tree;

import sun.reflect.generics.tree.Tree;

/**
 * 二叉树的前中后序遍历
 *
 * 前序遍历--根节点在前,然后同级先左后右
 * 中序遍历--先左后根,然后再右
 * 后续遍历--先左后右，然后根
 *
 * 二叉搜索树操作集锦
 *
 * 算法设计的总路线:明确一个节点要做的事情，然后剩下的事情抛给框架
 *
 */
public class BinaryTree {

    public static void main(String[] args) {

    }

    //算法设计的总路线
    public void traverse(TreeNode root){
        //root需要做什么
        //其他的抛给框架
        traverse(root.left);
        traverse(root.right);
    }

    /**
     * 所有的节点值+1
     * @param root
     */
    public void plusOne(TreeNode root){
        if(root == null){
            return;
        }
        root.val +=1;
        plusOne(root.right);
        plusOne(root.left);
    }

    /**
     * 判断两颗二叉搜索树是否完全相等
     * @param root
     * @param root1
     * @return
     */
    public boolean isSameTree(TreeNode root, TreeNode root1){
        if(root == null && root1 == null){
            return true;
        }
        if(root ==null || root1 == null){
            return false;
        }
        if(root.val != root1.val){
            return false;
        }
        return isSameTree(root.left,root1.left) && isSameTree(root.right,root1.right);
    }

    /**
     * 判断是否是一个有效的二叉搜索树
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root){
        return isValidBST(root,null,null);
    }

    //左小右大
    public boolean isValidBST(TreeNode root,TreeNode min,TreeNode max){
        if(root == null){
            return true;
        }
        if(min != null && root.val <= min.val){
            return false;
        }
        if(max != null && root.val >= max.val){
            return false;
        }
        return isValidBST(root.left,min,root) && isValidBST(root.right,root,max);
    }

    /**
     * 二叉树是否存在指定值
     * @param root
     * @param target
     * @return
     */
    public boolean isInBST(TreeNode root,int target){
        if(root == null){
            return false;
        }
        if(root.val == target){
            return true;
        }
        return isInBST(root.left,target) || isInBST(root.right,target);
    }

    public boolean isInBST1(TreeNode root,int target){
        if(root == null){
            return false;
        }
        if(root.val == target){
            return true;
        }
        if(root.val < target){
            return isInBST1(root.right,target);
        }
        if(root.val > target){
            return isInBST1(root.left,target);
        }
        return false;
    }

    public TreeNode insertIntoBST(TreeNode root,int val){
        if(root == null){
            return new TreeNode(val);
        }
        if(val > root.val){
            root.right = insertIntoBST(root.right,val);
        }
        if(val < root.val){
            root.left = insertIntoBST(root.left,val);
        }
        return null;
    }

    public TreeNode deleteNode(TreeNode root,int key){
        if(root == null){
            return null;
        }
        if(root.val == key){
            if(root.left == null){
                return root.right;
            }
            if(root.right == null){
                return root.left;
            }
            TreeNode min = getMin(root.left);

             root.val = min.val;
             root.right = deleteNode(root.right,min.val);
        }
        if(key > root.val){
            root.right = deleteNode(root.right,key);
        }
        if(key < root.val){
            root.left = deleteNode(root.left,key);
        }
        return null;
    }

    TreeNode getMin(TreeNode root){
        while (root.left != null){
            root = root.left;
        }
        return root;
    }


    class TreeNode{
        public TreeNode left;
        public TreeNode right;
        public int val;

        public TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }


    /**
     * 序列化和反序列化
     */

    //前序



}
