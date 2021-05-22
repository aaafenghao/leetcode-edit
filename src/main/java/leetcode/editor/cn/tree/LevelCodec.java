package leetcode.editor.cn.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelCodec implements Codec {

    @Override
    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        Queue<TreeNode> list = new LinkedList();
        list.add(root);
        while (!list.isEmpty()){
            TreeNode poll = list.poll();
            if(poll == null){
                str.append(NULL).append(SEP);
                continue;
            }
            str.append(poll.val).append(SEP);
            list.add(poll.left);
            list.add(poll.right);
        }
        return str.toString();
    }

    @Override
    public TreeNode deserialize(String data) {
        if(data.isEmpty()){
            return null;
        }
        String[] nodes = data.split(SEP);
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> list = new LinkedList<>();
        list.add(root);
        for (int i = 1; i < nodes.length;) {
            TreeNode poll = list.poll();
            String item = nodes[i++];
            if(!item.equals(NULL)){
                poll.left = new TreeNode(Integer.parseInt(item));
                list.offer(poll.left);
            }else{
                poll.left = null;
            }
            String right = nodes[i++];
            if(!right.equals(NULL)){
                poll.right = new TreeNode(Integer.parseInt(right));
                list.offer(poll.right);
            }else{
                poll.right = null;
            }
        }
        return root;
    }
}
