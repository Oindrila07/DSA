package org.DSA.BinaryTrees;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return check(root, 0)!=-1;
    }

    private int check(TreeNode node, int ht){
        if(node==null)return ht;
        int left=check(node.left, ht+1);
        int right=check(node.right, ht+1);
        if(Math.abs(left-right)>1)return -1;
        return Math.max(left,right);
    }
}
