package org.DSA.BinaryTrees;

import java.util.*;

public class InOrderTraversalIterative {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if(root==null) return list;
        Stack<TreeNode> stack=new Stack<>();

        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode node=stack.peek();
            while(node.left!=null){
                stack.push(node.left);
                node=node.left;
            }
            while(!stack.isEmpty()){
                node=stack.pop();
                list.add(node.val);
                if(node.right!=null){
                    stack.push(node.right);
                    break;
                }
            }
        }

        return list;
    }
}
