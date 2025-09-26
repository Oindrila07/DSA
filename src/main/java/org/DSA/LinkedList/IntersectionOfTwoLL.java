package org.DSA.LinkedList;

import java.util.HashSet;

public class IntersectionOfTwoLL {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> hash=new HashSet<>();
        ListNode temp=headA;
        while(temp!=null){
            hash.add(temp);
            temp=temp.next;
        }
        temp=headB;
        while(temp!=null){
            if(hash.contains(temp))return temp;
            temp=temp.next;
        }
        return null;
    }
}
