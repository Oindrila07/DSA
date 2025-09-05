package org.DSA.BinaryTrees;

import static org.DSA.BinaryTrees.Main.display;

public class FindCommonParentForSiblings {
    public TreeNode findParentNode(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node=check(root, p, q);
        return node;
    }
    private TreeNode check(TreeNode node, TreeNode p, TreeNode q){
        if(node==null)return node;

        if((node.left!=null && node.right!=null && node.left.val==p.val && node.right.val==q.val) ||
                (node.val==p.val && ((node.left!=null && node.left.val==q.val) || node.right!=null && node.right.val==q.val)) ||
                (node.val==q.val && (node.left!=null && node.left.val==p.val || node.right!=null && node.right.val==p.val))){
            return node;
        }

        TreeNode temp=check(node.left, p, q);
        if(temp==null)temp=check(node.right, p, q);

        return temp;
    }
}

class FindParentMain {
    public static void main(String[] args) {
        TreeNode head=new TreeNode(2);
        head.left=new TreeNode(1);
        head.right=new TreeNode(3);

        TreeNode p=head.left;
        TreeNode q=head.right;

        TreeNode res=new FindCommonParentForSiblings().findParentNode(head, p, q);

        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(5);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);

        root.left.right.left = new TreeNode(7);
        p=root.left.right.left;
        root.left.right.right = new TreeNode(4);
        q=root.left.right.right;

        display(root,"");
        res=new FindCommonParentForSiblings().findParentNode(root, p, q);
        System.out.println(res.val);
    }
}
