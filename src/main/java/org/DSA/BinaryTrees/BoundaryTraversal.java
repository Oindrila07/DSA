package org.DSA.BinaryTrees;

import java.util.ArrayList;

public class BoundaryTraversal {
    ArrayList<Integer> boundaryTraversal(Node node) {
        // code here
        ArrayList<Integer> list=new ArrayList<>();

        if(node.left==null && node.right==null){
            list.add(node.data);
            return list;
        }

        list.add(node.data);

        populateLeft(node.left, list);
        populateLeaves(node, list);
        populateRight(node.right, list);

        return list;
    }

    private void populateLeft(Node node, ArrayList<Integer> list){
        if(node==null || (node.left==null && node.right==null))return;
        list.add(node.data);
        if(node.left!=null)populateLeft(node.left, list);
        else populateLeft(node.right, list);
    }

    private void populateLeaves(Node node, ArrayList<Integer> list){
        if(node==null)return;
        if(node.left==null && node.right==null){
            list.add(node.data);
            return;
        }
        populateLeaves(node.left,list);
        populateLeaves(node.right,list);
    }

    private void populateRight(Node node, ArrayList<Integer> list){
        if(node==null || (node.left==null && node.right==null))return;
        if(node.right!=null)populateRight(node.right, list);
        else populateRight(node.left, list);
        list.add(node.data);
    }
}
