package leetcode.editor.cn.tree;

/**
 * 完全二叉树的节点数
 *
 * 完全二叉树--每一层都是紧凑靠左
 * 满二叉树--是一种特殊的完全二叉树,每一层都是满的
 *
 * 时间复杂度是logN * logN
 * 循环logN 每次循环需要logN
 */
public class CountTree {

    public static void main(String[] args) {

    }

    public int countTree(TreeNode root){
        TreeNode r = root, p = root;
        int h1 = 0,h2=0;
        while (r.left != null){
            r = r.left;
            h1++;
        }
        while (p.right != null){
            p = p.right;
            h2++;
        }
        if(h1 == h2){
            return (int)Math.pow(2,h1)-1;
        }
        return 1+countTree(root.right) + countTree(root.left);
    }
}
