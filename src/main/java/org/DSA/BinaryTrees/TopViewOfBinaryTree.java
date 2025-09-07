package org.DSA.BinaryTrees;

import java.util.*;

public class TopViewOfBinaryTree {
    static ArrayList<Integer> topView(Node root) {
        // code here
        ArrayList<Integer> list=new ArrayList<>();
        if(root==null)return list;

        Queue<Pair> queue=new ArrayDeque<>();
        Map<Integer,Integer> map=new TreeMap<>();

        queue.offer(new Pair(0,root));

        while(!queue.isEmpty()){
            int size=queue.size();
            while(size-->0){
                Pair pair=queue.poll();
                Node node=pair.curr;
                int col=pair.col;

                if(node.left!=null)queue.offer(new Pair(col-1,node.left));
                if(node.right!=null)queue.offer(new Pair(col+1,node.right));
                if(!map.containsKey(col)){
                    map.put(col,node.data);
                }
            }
        }

        for(Integer num:map.values()){
            list.add(num);
        }

        return list;
    }
}
class Pair {
    int col;
    Node curr;

    Pair(int col, Node curr){
        this.col=col;
        this.curr=curr;
    }
}
