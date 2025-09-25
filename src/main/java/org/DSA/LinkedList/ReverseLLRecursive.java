package org.DSA.LinkedList;

public class ReverseLLRecursive {
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null)return head;
        return reverse(head,null,head.next);
    }

    private ListNode reverse(ListNode curr, ListNode prev, ListNode next){
        if(curr==null)return prev;
        next=curr.next;
        curr.next=prev;
        return reverse(next,curr,next);
    }
}
