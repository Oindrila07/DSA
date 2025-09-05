package org.DSA.BinaryTrees;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node=check(root, p, q);
        return node;
    }
    private TreeNode check(TreeNode node, TreeNode p, TreeNode q){
        if(node==null || p.val==node.val || q.val==node.val)return node;
        TreeNode left=check(node.left,p,q);
        TreeNode right=check(node.right,p,q);
        if(left!=null && right!=null)return node;
        return left!=null?left:right;
    }
}

class LCAMain {
    public static void main(String[] args) {
        TreeNode head=new TreeNode(2);
        head.left=new TreeNode(1);
        head.right=new TreeNode(3);

        TreeNode p=head.left;
        TreeNode q=head.right;

        TreeNode res=new LowestCommonAncestor().lowestCommonAncestor(head, p, q);

        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(5);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);

        root.left.right.left = new TreeNode(7);
        p=root.left.right.left;
        root.left.right.right = new TreeNode(4);
        q=root.left.right.right;

        res=new LowestCommonAncestor().lowestCommonAncestor(root,p,q);
        System.out.println(res.val);
    }
}
