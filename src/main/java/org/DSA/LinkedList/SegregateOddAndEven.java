package org.DSA.LinkedList;

public class SegregateOddAndEven {
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null)return head;
        ListNode odd=head, even=head.next;
        ListNode evenHead=even;
        while(odd!=null && even!=null && even.next!=null){
            odd.next=even.next;
            even.next=even.next.next;
            odd=odd.next;
            even=even.next;
        }
        odd.next=evenHead;
        return head;
    }
}
