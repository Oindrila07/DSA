package org.DSA.BinaryTrees;

public class BinaryTreeToDLL {
    Node prev=null;
    Node head=null;
    Node bToDLL(Node root) {
        // code here
        inOrderTraversal(root);
        return head;
    }

    private void inOrderTraversal(Node node){
        if(node==null)return;
        inOrderTraversal(node.left);
        if(prev==null){
            head=node;
        }
        else{
            prev.right=node;
            node.left=prev;
        }

        prev=node;

        inOrderTraversal(node.right);
    }
}

class Node {
    int data;
    Node left, right;

    Node() {
        this.data = 0;
        this.left = this.right = null;
    }

    Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}