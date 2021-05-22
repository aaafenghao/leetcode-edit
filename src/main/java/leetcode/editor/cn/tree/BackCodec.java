package leetcode.editor.cn.tree;

import java.util.LinkedList;

public class BackCodec implements Codec {

    @Override
    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        serialize(root,str);
        return str.toString();
    }

    public void serialize(TreeNode root,StringBuilder str){
        if(root == null){
            str.append(NULL).append(SEP);
        }
        serialize(root.left,str);
        serialize(root.right,str);
        str.append(root.val).append(SEP);
    }

    @Override
    public TreeNode deserialize(String data) {
        LinkedList<String> linkedList = new LinkedList<>();
        for (String item:data.split(SEP)){
            linkedList.add(item);
        }
        return deserialize(linkedList);
    }

    public TreeNode deserialize(LinkedList<String> list){
        if(list.isEmpty()){
            return null;
        }
        String node = list.removeLast();
        if(node.equals(NULL)){
            return null;
        }
        TreeNode treeNode = new TreeNode(Integer.parseInt(node));
        treeNode.right = deserialize(list);
        treeNode.left = deserialize(list);
        return treeNode;
    }
}
