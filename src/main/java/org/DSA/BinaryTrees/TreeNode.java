package org.DSA.BinaryTrees;

public class TreeNode {
    int val;
    org.DSA.BinaryTrees.TreeNode left;
    org.DSA.BinaryTrees.TreeNode right;

    TreeNode(int val){
        this.val=val;
    }
    TreeNode(int val, org.DSA.BinaryTrees.TreeNode left, org.DSA.BinaryTrees.TreeNode right){
        this.val=val;
        this.left=left;
        this.right=right;
    }
}
