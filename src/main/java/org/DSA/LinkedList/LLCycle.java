package org.DSA.LinkedList;

public class LLCycle {
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null)return false;
        ListNode slow, fast;
        slow=fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)return true;
        }

        return false;
    }
}
