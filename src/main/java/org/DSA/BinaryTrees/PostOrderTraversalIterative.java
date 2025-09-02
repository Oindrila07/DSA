package org.DSA.BinaryTrees;

import java.util.*;

public class PostOrderTraversalIterative {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        HashSet<TreeNode> hash=new HashSet<>();
        if(root==null)return list;

        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode node=stack.peek();
            while(node.left!=null){
                stack.push(node.left);
                node=node.left;
            }
            while(!stack.isEmpty()){
                node=stack.peek();
                if(node.right!=null && !hash.contains(node.right)){
                    stack.push(node.right);
                    hash.add(node.right);
                    break;
                }
                list.add(stack.pop().val);
            }
        }

        return list;
    }

    public List<Integer> postorderTraversalWithoutHashSet(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        if(root==null) return list;

        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode node=stack.pop();
            if(node.left!=null)stack.push(node.left);
            if(node.right!=null)stack.push(node.right);
            list.add(node.val);
        }

        Collections.reverse(list);

        return list;
    }
}
