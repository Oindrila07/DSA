package org.DSA.BinaryTrees;

public class CountCompleteTreeNodes {
    int count=0;
    public int countNodes(TreeNode root) {
        if(root==null)return 0;

        int left=heightLeft(root.left,1);
        int right=heightRight(root.right,1);

        if(left==right)return (int)(Math.pow(2,left))-1;
        countTreeNodes(root);
        return count;
    }

    private int heightLeft(TreeNode node, int ht){
        if(node==null)return ht;
        return heightLeft(node.left,ht+1);
    }

    private int heightRight(TreeNode node, int ht){
        if(node==null)return ht;
        return heightRight(node.right,ht+1);
    }

    private void countTreeNodes(TreeNode node){
        if(node==null)return;
        countTreeNodes(node.left);
        count++;
        countTreeNodes(node.right);
    }
}
