package org.DSA.BinaryTrees;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        swap(root);
        return root;
    }

    private void swap(TreeNode node){
        if(node==null || (node.left==null && node.right==null))return;
        TreeNode temp=node.left;
        node.left=node.right;
        node.right=temp;
        swap(node.left);
        swap(node.right);
    }
}
