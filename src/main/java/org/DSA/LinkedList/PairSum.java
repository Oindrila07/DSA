package org.DSA.LinkedList;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class PairSum {
    public List<Integer> findPair(ListNode node, int target){
        HashSet<Integer> hash=new HashSet<>();
        while(node!=null){
            if(hash.contains(target-node.val)){
                return Arrays.asList(node.val, target-node.val);
            }
            hash.add(node.val);
            node=node.next;
        }
        return Arrays.asList(-1,-1);
    }
}
