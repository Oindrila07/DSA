package org.DSA.BinaryTrees;

public class SumTree {
    boolean isSumTree(Node root) {
        // Your code here
        return check(root)!=-1;
    }

    private int check(Node node){
        if(node==null)return 0;
        if(node.left==null && node.right==null)return node.data;

        int leftSum=check(node.left);
        int rightSum=check(node.right);

        if(leftSum+rightSum!=node.data)return -1;

        return node.data+leftSum+rightSum;
    }
}

/*
🛠️ The Idea:
------------
Naively, you might think:
For each node, compute sum of left subtree and right subtree, then compare.
But computing subtree sums directly for every node → O(N²) time (because each subtree gets recomputed many times).
Instead, we use a post-order traversal with a helper function that:
Returns the sum of the subtree rooted at this node if it is a Sum Tree.
Returns -1 as a special marker if the subtree is not a Sum Tree.
This way, every node is visited exactly once → O(N).


🚀 How the Code Works:
-----------------------
isSumTree(root): Calls check(root).

If it returns -1, means some violation happened → return false.

Otherwise, return true.

check(node)

Post-order recursion:

Base cases
If node == null: return 0 (null contributes nothing).
If leaf: return node.data (leaf is trivially a Sum Tree).

Recursive calls:
Compute leftSum = check(node.left).
Compute rightSum = check(node.right).

If either returns -1 → immediately bubble up -1.

Check current node’s property
If leftSum + rightSum != node.data:
→ violation of Sum Tree rule → return -1.

Return the total sum for parent use
If valid, return node.data + leftSum + rightSum.

Why? Because the parent node needs the total sum of this entire subtree when validating its own sum property.
 */