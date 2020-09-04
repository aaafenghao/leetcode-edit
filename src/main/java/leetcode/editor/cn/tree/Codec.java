package leetcode.editor.cn.tree;

public interface Codec {

      String SEP = ",";

      String NULL = "#";

     String serialize(TreeNode root);

     TreeNode  deserialize(String data);
}
