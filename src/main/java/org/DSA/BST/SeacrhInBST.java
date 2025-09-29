package org.DSA.BST;

public class SeacrhInBST {
    public TreeNode searchBST(TreeNode root, int val) {
        return search(root,val);
    }

    private TreeNode search(TreeNode node, int val){
        if(node==null || node.val==val)return node;
        if(node.val>val)return search(node.left,val);
        return search(node.right,val);
    }
}
