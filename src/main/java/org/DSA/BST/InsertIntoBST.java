package org.DSA.BST;

public class InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null)return new TreeNode(val);
        insert(root,val);
        return root;
    }

    private void insert(TreeNode node, int val){
        if(node.val<val){
            if(node.right==null){
                node.right=new TreeNode(val);
                return;
            }
            else {
                insert(node.right,val);
                return;
            }
        }
        if(node.val>val && node.left==null){
            node.left=new TreeNode(val);
            return;
        }
        else {
            insert(node.left,val);
            return;
        }
    }
}
