package org.DSA.LinkedList;

public class ReverseNodesInKGroups {
    public ListNode reverseKGroup(ListNode head, int k) {
        int count=countNodes(head);
        ListNode temp=head, prev=null;
        boolean updated=false;
        int idx=0;
        while(temp!=null && idx<count){
            if(idx+k>count)break;
            ListNode node=reverse(temp,k);
            if(!updated){
                head=node;
                updated=true;
            }
            else prev.next=node;
            prev=temp;
            temp=temp.next;
            idx+=k;
        }
        return head;
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
        node.next=temp;
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
