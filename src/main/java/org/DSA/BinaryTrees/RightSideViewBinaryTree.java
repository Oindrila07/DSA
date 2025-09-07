package org.DSA.BinaryTrees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class RightSideViewBinaryTree {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if(root==null)return list;

        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<=size-1;i++){
                TreeNode node=queue.poll();
                if(node.left!=null)queue.offer(node.left);
                if(node.right!=null)queue.offer(node.right);
                if(i==size-1)list.add(node.val);
            }
        }

        return list;
    }
}
