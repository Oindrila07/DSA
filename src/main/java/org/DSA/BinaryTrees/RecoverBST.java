package org.DSA.BinaryTrees;

public class RecoverBST {
    TreeNode prev=null;
    TreeNode first=null;
    TreeNode second=null;

    public void recoverTree(TreeNode root) {
        inOrderTraversal(root);
        int temp=first.val;
        first.val=second.val;
        second.val=temp;
    }

    private void inOrderTraversal(TreeNode node){
        if(node==null)return;
        inOrderTraversal(node.left);
        if(prev!=null && prev.val>node.val){
            if(first==null){
                first=prev;
            }
            second=node;
        }
        prev=node;
        inOrderTraversal(node.right);
    }
}

/*
✅ Correct Approach:
--------------------
=> Do an inorder traversal of the tree (gives you a sorted sequence if BST is valid).
=> Track the previous node (prev) while traversing.
=> If you find prev.val > current.val, that’s a violation.
=> On the first violation, mark first = prev and second = current.
=> On the second violation, update second = current.
=> After traversal, swap first.val and second.val.

This works whether the swapped nodes are adjacent or far apart.
 */