package org.DSA.LinkedList;

public class StartingPointOfCycleInLL {
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null)return null;
        ListNode slow=head, fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)break;
        }

        fast=head;
        while(slow!=null && fast!=null && slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }

        return slow;
    }
}
