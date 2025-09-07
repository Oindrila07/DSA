package org.DSA.BinaryTrees;

public class LowestCommonAncestorOfBT {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, p, q);
    }

    private TreeNode helper(TreeNode node, TreeNode p, TreeNode q){
        if(node==null || node.val==p.val || node.val==q.val)return node;
        TreeNode left=helper(node.left,p,q);
        TreeNode right=helper(node.right,p,q);

        if(left!=null && right!=null)return node;
        return left==null?right:left;
    }
}

/*
🔑 The Approach Used:
---------------------
This is the standard recursive DFS approach to find the Lowest Common Ancestor (LCA) in a Binary Tree (not just BST).

Key observations:

If the current node is null → no ancestor here, return null.

If the current node is p or q → return it up the recursion (possible ancestor).

Otherwise, recursively search in left and right subtrees.

If both left and right calls return non-null, it means:

one target was found in the left subtree,

the other was found in the right subtree.
→ Current node is the lowest common ancestor.

If only one side is non-null, it means both p and q are found in that side (or not found at all in the other). → Propagate the non-null value upward.



🖼 Example:
-----------
       3
      / \
     5   1
    / \ / \
   6  2 0  8
     / \
    7   4

Find LCA of p=5, q=1.

helper(3) → left returns 5, right returns 1 → both non-null → return 3.

Find LCA of p=5, q=4.

helper(3) → left subtree eventually returns 5 (since it’s ancestor of 4), right returns null.

So the answer is 5.
 */
