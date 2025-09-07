package org.DSA.BinaryTrees;

import java.util.*;

public class VerticalTraversalOfBinaryTrees {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<CoOrdinates> queue=new ArrayDeque<>();
        queue.offer(new CoOrdinates(0,0,root));
        TreeMap<Integer, List<int[]>> map=new TreeMap<>();

        while(!queue.isEmpty()){
            int size=queue.size();
            List<int[]> list;
            while(size-->0){
                CoOrdinates c=queue.poll();
                TreeNode node=c.curr;
                int row=c.row;
                int col=c.col;
                if(node.left!=null)queue.offer(new CoOrdinates(row+1,col-1,node.left));
                if(node.right!=null)queue.offer(new CoOrdinates(row+1,col+1,node.right));
                list=map.containsKey(col)?map.get(col):new ArrayList<>();
                list.add(new int[]{row,node.val});
                map.put(col,list);
            }
        }

        List<List<Integer>> result=new ArrayList<>();
        for(Map.Entry e:map.entrySet()){
            List<int[]> temp=(List<int[]>)e.getValue();
            Collections.sort(temp, (a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
            List<Integer> list=new ArrayList<>();
            for(int[] arr:temp){
                list.add(arr[1]);
            }
            result.add(list);
        }

        return result;
    }
}

class CoOrdinates {
    int row;
    int col;
    TreeNode curr;

    CoOrdinates(int row, int col, TreeNode curr){
        this.row=row;
        this.col=col;
        this.curr=curr;
    }
}

/*
Intuition:
----------
=> Use level order traversal
=> store the co-ordinates and values in a map
=> the values should be orders bases on - col -> row -> value, thats why use TreeMap<Integer,List<int[]>>
                                                                                        |           |
                                                                                        col        row, values
 */