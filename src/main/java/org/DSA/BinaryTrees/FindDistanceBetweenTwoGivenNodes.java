package org.DSA.BinaryTrees;

import com.sun.source.tree.Tree;

import java.util.Arrays;
import java.util.List;

import static org.DSA.BinaryTrees.Main.populate;

public class FindDistanceBetweenTwoGivenNodes {
    int findDist(TreeNode root, int a, int b) {
        // Your code here
        TreeNode lca=findLCA(root,a,b);
        int dist=findDistance(lca,a,0)+findDistance(lca,b,0);
        return dist;
    }

    private TreeNode findLCA(TreeNode node, int a, int b){
        if(node==null || node.val==a || node.val==b)return node;
        TreeNode left=findLCA(node.left,a,b);
        TreeNode right=findLCA(node.right,a,b);
        if(left!=null && right!=null)return node;
        return left==null?right:left;
    }

    private int findDistance(TreeNode node, int value, int distance){
        if(node==null)return 0;
        if(node.val==value)return distance;
        int left=findDistance(node.left,value,distance+1);
        int right=findDistance(node.right,value,distance+1);

        return Math.max(left,right);
    }
}

class FindDistMain {
    public static void main(String[] args) {
        TreeNode head=new TreeNode(11);
        List<Integer> list= Arrays.asList(0,11, 22, 33, 44, 55, 66, 77);
        populate(head,list,1);
        System.out.println(new FindDistanceBetweenTwoGivenNodes().findDist(head,77,22));
    }
}

/*
🔑 Idea:
---------
The minimum distance between two nodes a and b in a Binary Tree is: dist(a,b)=depth(a)+depth(b)−2×depth(LCA(a,b))

So the core problem reduces to:
=> Find the LCA of a and b.
=> Find the distance from LCA to a.
=> Find the distance from LCA to b.
=> Add those two distances.
 */