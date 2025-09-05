package org.DSA.BinaryTrees;

public class MinimumAbsDiff {
    int minDiff=Integer.MAX_VALUE;
    TreeNode prev=null;

    public int getMinimumDifference(TreeNode root) {
        if(root==null)return 0;
        findMinDiff(root);
        return minDiff;
    }

    private void findMinDiff(TreeNode node){
        if(node==null)return;
        findMinDiff(node.left);
        if(prev!=null){
            minDiff=Math.min(minDiff, Math.abs(node.val-prev.val));
        }
        prev=node;
        findMinDiff(node.right);
    }
}
