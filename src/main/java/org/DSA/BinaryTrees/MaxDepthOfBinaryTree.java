package org.DSA.BinaryTrees;

public class MaxDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        int depth=0;
        return findMaxDepth(root,depth);
    }
    private int findMaxDepth(TreeNode node, int depth){
        if(node==null)return depth;
        int left=0, right=0;

        left=findMaxDepth(node.left,depth+1);
        right=findMaxDepth(node.right,depth+1);
        return Math.max(left,right);
    }
}
