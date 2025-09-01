package org.DSA.BinaryTrees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversalIterative {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        if(root==null)return list;
        stack.push(root);

        while(!stack.isEmpty()){
            int size=stack.size();
            for(int i=0;i<size;i++){
                TreeNode node=stack.pop();
                list.add(node.val);
                if(node.right!=null)stack.push(node.right);
                if(node.left!=null)stack.push(node.left);
            }
        }

        return list;
    }
}
