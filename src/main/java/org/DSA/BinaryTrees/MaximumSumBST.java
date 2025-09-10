package org.DSA.BinaryTrees;

public class MaximumSumBST {
    int max=0;
    public int maxSumBST(TreeNode root) {
        helper(root);
        return max;
    }

    private int[] helper(TreeNode node){
        if(node==null)return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        // Explanation:
        // Base case: a null node is trivially a BST.
        // We return {min, max, sum} = {+∞, -∞, 0}
        // +∞ for min ensures it won’t affect parent node's min
        // -∞ for max ensures it won’t affect parent node's max
        // 0 for sum because null contributes nothing

        int[] left=helper(node.left);
        int[] right=helper(node.right);
        // Explanation:
        // Recursively compute left and right subtrees.
        // Each returns an array {min value, max value, sum} of that subtree if it's a BST.
        // If a subtree is invalid, it returns the “broken” marker { -∞, +∞, 0 }.

        if(left[1]>=node.val || right[0]<=node.val){
            return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
        }
        // Explanation:
        // Check BST property for current node:
        // left.max < node.val < right.min
        // left[1] is the max in left subtree
        // right[0] is the min in right subtree
        // If violated → subtree rooted at 'node' is invalid
        // Return “broken” marker to propagate invalidity upwards

        int sum=left[2]+right[2]+node.val;
        max=Math.max(max,sum);
        // Explanation:
        // Compute sum of current subtree since it is a valid BST
        // Update global maximum if this sum is larger than previously found sums

        int lower=Math.min(node.val,left[0]);
        int upper=Math.max(node.val,right[1]);
        // Explanation:
        // Determine the min and max values in the current BST
        // lower: smallest value in the subtree = min(node.val, left.min)
        // upper: largest value in the subtree = max(node.val, right.max)
        // These are needed by parent to validate BST property

        return new int[]{lower,upper,sum};
        // Explanation:
        // Return an array containing min, max, and sum for this subtree
        // This allows parent nodes to check BST property and compute sums
    }
}

