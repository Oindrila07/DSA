package org.DSA.LinkedList;

public class RemoveNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count=countNodes(head), counter=1;
        ListNode temp=head;
        if(temp.next==null)return null;
        if(count==n){
            head=head.next;
            return head;
        }

        while(temp!=null && counter<count-n){
            temp=temp.next;
            counter++;
        }

        temp.next=temp.next.next;
        return head;
    }

    private int countNodes(ListNode node){
        int count=1;
        while(node.next!=null){
            node=node.next;
            count++;
        }
        return count;
    }
}

/*
Edge Cases:
-----------
1) Only one node is present
2) When we are supposed to delete head node
 */
