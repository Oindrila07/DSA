package org.DSA.BinaryTrees;

import java.util.Arrays;
import java.util.List;

import static org.DSA.BinaryTrees.Main.populate;

public class CountGoodNodes {
    public int goodNodes(TreeNode root) {
        return countNodes(root,0);
    }

    private int countNodes(TreeNode node, int maxSoFar){
        if(node==null)return 0;

        int count=node.val>=maxSoFar?1:0;
        maxSoFar=Math.max(maxSoFar,node.val);
        count+=countNodes(node.left,maxSoFar)+countNodes(node.right,maxSoFar);
        return count;
    }
}
class CountGoodNodeMain {
    public static void main(String[] args) {
        TreeNode head=new TreeNode(3);
        List<Integer> list= Arrays.asList(0,3,1,4,3,-1,1,5);
        populate(head,list,1);

        System.out.println(new CountGoodNodes().goodNodes(head));
    }
}