package org.DSA.BinaryTrees;

import java.util.ArrayList;
import java.util.List;

public class InOrderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();

        traverse(list, root);
        return list;
    }

    private void traverse(List<Integer> list, TreeNode root){
        if(root==null)return;
        traverse(list, root.left);
        list.add(root.val);
        traverse(list,root.right);
    }
}
