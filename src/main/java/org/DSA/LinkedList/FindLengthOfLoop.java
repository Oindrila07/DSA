package org.DSA.LinkedList;

public class FindLengthOfLoop {
    public int lengthOfLoop(ListNode head) {
        // code here
        boolean found=false;
        ListNode slow=head, fast=head, loopHead;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                found=true;
                break;
            }
        }

        if(!found)return 0;

        fast=head;

        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
            if(slow==fast){
                break;
            }
        }

        loopHead=slow;
        slow=slow.next;
        int count=1;

        while(slow!=loopHead){
            slow=slow.next;
            count++;
        }

        return count;
    }
}
