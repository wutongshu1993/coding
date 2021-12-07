package treeNode;

public class BuildTree {
    /**
     * 105. 从前序与中序遍历序列构造二叉树
     * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
     *
     * @param preorder
     * @param inorder
     * @return
     */
    TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIndex;
        for (rootIndex = inStart; rootIndex <= inEnd; rootIndex++) {
            if (inorder[rootIndex] == preorder[preStart]) {// 查找中序遍历中根结点的index
                break;
            }
        }
        int leftSize = rootIndex - inStart;
        System.out.println(root.val);
        root.left = build(preorder, preStart + 1, preStart + leftSize, inorder, inStart, rootIndex - 1);
        root.right = build(preorder, preStart + leftSize + 1, preEnd, inorder, rootIndex + 1, inEnd);
        return root;
    }

    /**
     * @param postorder
     * @param inorder
     * @return
     */
    TreeNode buildTree2(int[] inorder, int[] postorder) {
        return build2(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
    }

    TreeNode build2(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd) {
        if (postStart > postEnd || inStart > inEnd) {
            return null;
        }
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex;
        for (rootIndex = inStart; rootIndex <= inEnd; rootIndex++) {
            if (inorder[rootIndex] == rootVal) {// 查找中序遍历中根结点的index
                break;
            }
        }
        int leftSize = rootIndex - inStart;
        root.left = build2(postorder, postStart, postStart+leftSize-1 , inorder, inStart, rootIndex - 1);
        root.right = build2(postorder, postStart+leftSize, postEnd-1, inorder, rootIndex + 1, inEnd);
        return root;
    }

    public static void main(String[] args) {

        TreeNode root = new BuildTree().buildTree2(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});
        System.out.println(root);
    }
}
