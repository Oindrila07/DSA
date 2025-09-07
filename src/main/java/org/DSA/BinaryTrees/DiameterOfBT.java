package org.DSA.BinaryTrees;

public class DiameterOfBT {
    int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }

    private int depth(TreeNode node){
        if(node==null) return 0;
        int left=depth(node.left);
        int right=depth(node.right);
        max=Math.max(max,left+right);
        return 1+Math.max(left,right);
    }
}

/*
Definition of diameter:  Longest Path between any 2 nodes
 */
