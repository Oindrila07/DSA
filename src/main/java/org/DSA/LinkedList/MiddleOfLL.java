package org.DSA.LinkedList;

public class MiddleOfLL {
    public ListNode middleNode(ListNode head) {
        ListNode mid=head;
        int count=countNodes(head);
        int idx=1;

        while(idx<count/2+1){
            mid=mid.next;
            idx++;
        }

        return mid;
    }

    private int countNodes(ListNode node){
        int count=0;

        while(node!=null){
            node=node.next;
            count++;
        }

        return count;
    }
}
