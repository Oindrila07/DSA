package org.DSA.BinaryTrees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversalIterative {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        if(root==null)return list;
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.offer(root);

        traverse(list, root, queue);
        return list;
    }

    private void traverse(List<List<Integer>> list, TreeNode root, Queue<TreeNode> queue){
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> res=new ArrayList<>();
            while(size-->0){
                TreeNode node=queue.poll();
                res.add(node.val);
                if(node.left!=null)queue.offer(node.left);
                if(node.right!=null)queue.offer(node.right);
            }
            list.add(res);
        }
    }
}
