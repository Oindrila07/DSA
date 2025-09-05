package org.DSA.BinaryTrees;

import java.util.Arrays;
import java.util.List;

import static org.DSA.BinaryTrees.Main.populate;

public class CountNodes {
    int count=0;
    public int countTreeNodes(TreeNode node){
        if(node==null)return count;
        countTreeNodes(node.left);
        count++;
        countTreeNodes(node.right);
        return count;
    }
}

class CountNodesMain {
    public static void main(String[] args) {
        TreeNode head=new TreeNode(1);
        List<Integer> list= Arrays.asList(0,1,2,3,4,5,-1,8,-1,-1,6,7,-1,-1,9);
        populate(head,list,1);
        int count=new CountNodes().countTreeNodes(head);
        System.out.println(count);
    }
}
