package org.DSA.BinaryTrees;

import java.util.Arrays;
import java.util.List;

import static org.DSA.BinaryTrees.Main.display;
import static org.DSA.BinaryTrees.Main.populate;

public class Codec {
    int index=0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)return "N";
        String encoded=root.val+","+serialize(root.left)+","+serialize(root.right);
        return encoded;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr=data.split(",");
        TreeNode head=populateTree(arr);
        return head;
    }

    private TreeNode populateTree(String[] arr){
        if(index>=arr.length || arr[index].equals("N")){
            index++;
            return null;
        }
        TreeNode node=new TreeNode(Integer.parseInt(arr[index++]));
        node.left=populateTree(arr);
        node.right=populateTree(arr);
        return node;
    }
}

class CodecMain {
    public static void main(String[] args) {
        TreeNode head=new TreeNode(1);
        List<Integer> list= Arrays.asList(0,1,2,3,-1,-1,4,5);
        populate(head,list,1);
        display(head,"");
        Codec obj=new Codec();
        String serialized=obj.serialize(head);
        System.out.println(serialized);
        TreeNode node=obj.deserialize(serialized);
        display(node,"");
    }
}

/*
Intuition:
----------
We can leverage a simple pre-order traversal of the tree to record its structure. Specifically, we record the node value if it is not null, and N if it is null. This serialization fully captures the shape of the tree. Then, to deserialize, we reverse the process by reading each token (value or N) and recursively building the tree. This ensures a 1:1 mapping from serialized data to the original tree structure.

Approach:
---------
1. Serialize:
-------------
=> Perform a pre-order DFS: root -> left -> right.
=> If the node is null, append "N" to our list.
=> Otherwise, append the numeric value of the node.
=> Join the results with commas to form the final string.


2.Deserialize:
--------------
=> Split the serialized string by commas into a list of tokens.
=> Use a recursive function that reads a token:
=> If it's "N", return null.
=> Otherwise, parse the value, create a node, and recursively build its left and right subtrees.
=> Move a global or external pointer/index to iterate through the tokens.
=> This ensures we visit every node exactly once during serialization and again during deserialization, resulting in an O(n) time complexity.

Complexity
Time complexity: O(n)
Space complexity: O(n)
 */