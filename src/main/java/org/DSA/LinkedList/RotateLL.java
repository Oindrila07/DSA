package org.DSA.LinkedList;

public class RotateLL {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null)return head;
        int len=countNodes(head);
        k=k%len;
        ListNode temp=head;
        ListNode l1=reverse(temp,(len-k));
        ListNode l2=reverse(temp.next,k);
        temp.next=l2;
        return reverse(l1,len);
    }

    private ListNode reverse(ListNode node, int k){
        ListNode temp=node;
        ListNode prev=null, next=null;
        int idx=0;
        while(temp!=null && idx<k){
            next=temp.next;
            temp.next=prev;
            prev=temp;
            temp=next;
            idx++;
        }
        if(temp!=null)node.next=temp;
        return prev;
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
