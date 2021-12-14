package treeNode;

import java.util.LinkedList;

/**
 * 297. 二叉树的序列化与反序列化
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 */
public class Serialize {
    String SEP = ",";
    String NULL = "null";
    public String serialize(TreeNode root) {
        if (root == null) {
            return NULL;
        }
        return traverse(root);
    }

    public String traverse(TreeNode root) {
        if (root == null) {
            return NULL;
        }
        String left = traverse(root.left);
        String right = traverse(root.right);
        return root.val + SEP + left + SEP + right;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == NULL) {
            return null;
        }
        LinkedList<String> nodes = new LinkedList<>();
        for(String s : data.split(SEP)) {
            nodes.addLast(s);
        }
        return traverse(nodes );
    }
    public TreeNode traverse(LinkedList<String> nodes){
        if(nodes.isEmpty()){
            return null;
        }
        String first = nodes.removeFirst();
        if(first.equals(NULL)){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(first));
        root.left = traverse(nodes);
        root.right = traverse(nodes);
        return root;
    }
}
