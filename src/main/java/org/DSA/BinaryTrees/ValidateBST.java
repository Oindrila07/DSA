package org.DSA.BinaryTrees;

public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        long lower=Long.MIN_VALUE;
        long upper=Long.MAX_VALUE;
        return inOrderTraversal(root,lower,upper);
    }

    private boolean inOrderTraversal(TreeNode node, long lower, long upper){
        if(node==null)return true;
        if(node.val>=upper || node.val<=lower)return false;
        return inOrderTraversal(node.left,lower,node.val) && inOrderTraversal(node.right,node.val,upper);
    }
}

/*
INTUITION:
----------
A common mistake is to only check if a node's left child is smaller and its right child is larger. This is insufficient. A node's value must be valid within a range determined by all of its ancestors, not just its immediate parent.
For example, a node in the right subtree of a node X must be greater than X. However, if X is in the left subtree of the root, that same node must also be less than the root.
This leads to the core intuition: validate each node against a [lower_bound, upper_bound] range that gets progressively narrower as the traversal descends the tree.

THE APPROACH:
-------------
The approach is to use a recursive Depth-First Search (DFS) traversal. A helper function will be defined to traverse the tree, passing down the valid range (lower and upper bounds) for each node.

The reason for this approach: It efficiently propagates the constraints from parent nodes down to their descendants. At any given node, the function has all the information needed (the node's value and its valid range) to make a determination.

ALGORITHM BREAKDOWN

Step 1: Define a recursive helper function isValid(node, lower_bound, upper_bound). Initialize the first call with the root and null bounds, as the root has no constraints.

Step 2: Establish the base case. If the current node is null, it is a valid subtree. Return true.

Step 3: Validate the current node's value against the bounds.

If lower_bound is not null and node.val <= lower_bound, the BST property is violated. Return false.
If upper_bound is not null and node.val >= upper_bound, the BST property is violated. Return false.
Step 4: Make two recursive calls for the children, updating the bounds accordingly.

For the left child, the current node's value becomes the new upper_bound. The call is isValid(node.left, lower_bound, node.val).
For the right child, the current node's value becomes the new lower_bound. The call is isValid(node.right, node.val, upper_bound).
Step 5: The final result for the current node is valid only if both the left and right recursive calls return true. Return the logical AND of these two calls.

The recursion terminates when all leaf nodes are processed.
 */