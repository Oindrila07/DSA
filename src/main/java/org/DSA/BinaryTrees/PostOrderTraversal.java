package org.DSA.BinaryTrees;

import java.util.ArrayList;
import java.util.List;

public class PostOrderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();

        traverse(list, root);
        return list;
    }

    private void traverse(List<Integer> list, TreeNode root){
        if(root==null)return;
        traverse(list,root.left);
        traverse(list, root.right);
        list.add(root.val);
    }
}
