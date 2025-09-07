package org.DSA.BinaryTrees;

import java.util.*;

public class BottomViewOfBinaryTree {
    public ArrayList<Integer> bottomView(Node root) {
        // Code here
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
                map.put(col,node.data);
            }
        }

        for(Integer num:map.values()){
            list.add(num);
        }

        return list;
    }
}
