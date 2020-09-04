package leetcode.editor.cn.tree;

import java.util.LinkedList;

/**
 * 前序遍历
 */
public class PreCodec implements Codec {


    @Override
    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        traverse(root,str);
        return str.toString();
    }

    public void traverse(TreeNode root,StringBuilder str){
        if(root == null){
            str.append(NULL).append(SEP);
        }
        //前序遍历
        str.append(root.val).append(SEP);
        traverse(root.left,str);
        traverse(root.right,str);
    }

    @Override
    public TreeNode deserialize(String data) {
        LinkedList<String> list = new LinkedList<>();
        for(String item:data.split(SEP)){
            list.add(item);
        }
        return deserialize(list);
    }

    public TreeNode deserialize(LinkedList<String> list){
        if(list.isEmpty()){
            return null;
        }
        String node = list.removeFirst();
        if(node.equals(NULL)){
            return null;
        }
        TreeNode treeNode = new TreeNode(Integer.parseInt(node));
        treeNode.left = deserialize(list);
        treeNode.right = deserialize(list);
        return treeNode;
    }
}
