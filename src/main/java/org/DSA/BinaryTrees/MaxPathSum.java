package org.DSA.BinaryTrees;

public class MaxPathSum {
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        calculate(root);
        return max;
    }

    private int calculate(TreeNode node){
        if(node==null)return 0;
        int left=Math.max(0,calculate(node.left));
        int right=Math.max(0,calculate(node.right));
        int sum=node.val+left+right;
        if(sum<node.val)sum=node.val;
        max=Math.max(max,sum);
        return node.val+Math.max(left,right);
    }
}

/*
1. Why do we use:
int left = Math.max(0, calculate(node.left));
int right = Math.max(0, calculate(node.right));

=> calculate(node.left) = the best path sum contribution from the left subtree.
But what if the left subtree’s best contribution is negative?
Example: left branch sum = -5.
Adding it to the current node would make the path worse, not better.

=> So we say:
If contribution < 0 → ignore it, treat as 0.
If contribution ≥ 0 → keep it.

👉 That’s why we wrap with Math.max(0, …).
It ensures we only take useful branches.


2. Why return: return node.val + Math.max(left, right);
When going up to the parent, we can only return one branch:
=> Either take the left path + current node, or the right path + current node.
=> We cannot take both because a parent path would “fork,” which is not allowed — path must be continuous.

So we return:
node.val + Math.max(left, right) = the best single-branch path starting from this node.
 */
