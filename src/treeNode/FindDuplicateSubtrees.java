package treeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 652. 寻找重复的子树（中等）
 * https://leetcode-cn.com/problems/find-duplicate-subtrees/
 */
public class FindDuplicateSubtrees {
    List<TreeNode> findDuplicateSubtrees(TreeNode root){
        traverse(root);
        return res;
    }
    List<TreeNode> res = new ArrayList<>();
    HashMap<String, Integer> map = new HashMap<>();
    String traverse(TreeNode root){
        if(root == null){
            return "#";
        }
        String leftStr = traverse(root.left);
        String rightStr = traverse(root.right);
        String rootStr = root.val+","+leftStr+","+rightStr;
        if(!map.containsKey(rootStr)){
            map.put(rootStr, 1);
        }else if (map.get(rootStr) == 1){
            res.add(root);
            map.put(rootStr, 2);
        }
        return rootStr;
    }
}
