package org.DSA.LinkedList;

public class DeleteMidOfLL {
    public ListNode deleteMiddle(ListNode head) {
        if(head.next==null)return null;
        int n=countNodes(head);
        int mid=n/2+1;
        ListNode temp=head;

        for(int i=1;i<mid-1;i++){
            temp=temp.next;
        }

        temp.next=temp.next.next;
        return head;
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
