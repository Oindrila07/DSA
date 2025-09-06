package org.DSA.BinaryTrees;

public class FalttenBinrayTreeToLL {
    TreeNode prev=null;
    public void flatten(TreeNode root) {
        convert(root);
    }

    private void convert(TreeNode node){
        if(node==null)return;

        convert(node.right);
        convert(node.left);

        if(prev!=null){
            node.right=prev;
            node.left=null;
        }
        prev=node;
    }
}

/*
✅ Standard recursive approach (using reverse preorder)

The clean trick:
Traverse in right → left → node order.

At each step:
------------
Point node.right = prev.
Set node.left = null.
Update prev = node.

This way, you never lose subtrees and always build the list backward.
 */