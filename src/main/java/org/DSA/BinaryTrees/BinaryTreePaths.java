package org.DSA.BinaryTrees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list=new ArrayList<>();
        if(root==null)return list;
        findPaths(list,root,""+root.val);
        return list;
    }

    private void findPaths(List<String> list, TreeNode node, String res){
        if(node==null || (node.left==null && node.right==null)){
            list.add(res);
            return;
        }
        if(node.left!=null)
            findPaths(list,node.left,res+"->"+node.left.val);
        if(node.right!=null)
            findPaths(list,node.right,res+"->"+node.right.val);
    }
}
