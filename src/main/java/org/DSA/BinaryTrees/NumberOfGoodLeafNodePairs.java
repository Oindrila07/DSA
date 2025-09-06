package org.DSA.BinaryTrees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfGoodLeafNodePairs {
    int count=0;
    public int countPairs(TreeNode root, int distance) {
        find(root,distance);
        return count;
    }

    private List<Integer> find(TreeNode node, int distance){
        if(node==null)return new ArrayList<>();
        if(node.left==null && node.right==null)return Arrays.asList(1);
        List<Integer> leftDist=find(node.left,distance);
        List<Integer> rightDist=find(node.right,distance);

        List<Integer> list=new ArrayList<>();
        for(int l:leftDist){
            for(int r:rightDist){
                if(l+r<=distance)count++;
            }
        }
        if(!leftDist.isEmpty()) list.addAll(leftDist);
        if(!rightDist.isEmpty()) list.addAll(rightDist);

        for(int i=0;i<list.size();i++){
            list.set(i,list.get(i)+1);
        }

        return list;
    }
}

/*
Intuition:
----------
Problem Statement:
You are given the root of a binary tree and an integer distance.

A leaf is a node with no children.
A pair of leaves (leaf1, leaf2) is good if:
The length of the shortest path between them is ≤ distance.
You need to count how many good leaf pairs exist in the tree.

Step 1: Think about the path:
-----------------------------
The path between two leaves always goes upwards from one leaf to their lowest common ancestor (LCA), and then downwards to the other leaf.
So, if you know the distance of each leaf from a node, you can combine those distances when checking pairs.

Step 2: What info to return from recursion?:
--------------------------------------------
If we traverse the tree bottom-up (DFS), at each node:
We don’t just want to know "how many pairs exist" — we also want the list of distances from this node to all leaves in its subtree.
Why? Because when we’re at a node, we can try pairing one leaf from the left subtree and one leaf from the right subtree to form good pairs.

So:
From a node, return an array (or list) of distances of all leaves below it.

Step 3: How to combine left and right subtrees?:
------------------------------------------------
At a node:

=> Get distances from the left subtree → leftDistances.
=> Get distances from the right subtree → rightDistances.

For each l in leftDistances and each r in rightDistances, check if l + r ≤ distance.
If yes, that’s a good pair → increment the count.

Return a new distance list for this node:
Take every distance in leftDistances and rightDistances, and add 1 (because moving one edge up).

Keep only those distances ≤ distance (since anything larger can never form a valid pair higher up).

Step 4: Base case:
------------------
If the node is None → return empty list.

If the node is a leaf → return [1] (distance = 1, since from parent to leaf is one edge).
Some solutions use [0], but [1] is more intuitive since we always "add 1" when going up.

Step 5: Collect results:
------------------------
Use a global counter (or pass a mutable reference) to track how many good pairs you’ve found.
Run DFS on the root.
Return the counter.

Complexity:
-----------
At each node, we may compare O(d²) pairs (where d = number of distances ≤ distance).
Since distance is at most 10 (per constraints), this is fine.
Overall complexity: O(N * distance²), where N = number of nodes.
 */
