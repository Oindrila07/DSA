package org.DSA.LinkedList;

public class ReverseLL {
    public ListNode reverseList(ListNode head) {
        ListNode prev=null, next=null, temp=head;

        while(temp!=null){
            next=temp.next;
            temp.next=prev;
            prev=temp;
            temp=next;
        }

        return prev;
    }
}
