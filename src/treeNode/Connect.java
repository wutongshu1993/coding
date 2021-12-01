package treeNode;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 */
public class Connect {
    public Node connect(Node root) {
        if(root==null){
            return null;
        }
        connectTwo(root.left, root.right);
        return root;
    }

    /**
     * 将 root1 和 root2 两个节点连接起来
     * @param root1
     * @param root2
     * @return
     */
    public void connectTwo(Node root1, Node root2){
        if(root1 == null){
            return;
        }
        root1.next = root2;
        connectTwo(root1.left, root1.right);
        connectTwo(root2.left, root2.right);
        connectTwo(root1.right, root2.left);
    }
}
