package org.DSA.LinkedList;

public class PalindromeLL {
    public boolean isPalindrome(ListNode head) {
        ListNode mid, first=head;
        int count=countNodes(head);
        mid=findMid(head,count);
        ListNode second=reverse(mid);

        while(second!=null){
            if(second.val!=first.val)return false;
            first=first.next;
            second=second.next;
        }

        return true;
    }

    private int countNodes(ListNode node){
        int count=0;

        while(node!=null){
            node=node.next;
            count++;
        }

        return count;
    }

    private ListNode findMid(ListNode node, int count){
        int mid=count%2==0?count/2:(count/2)+1;
        int counter=1;

        while(counter<mid){
            node=node.next;
            counter++;
        }

        return node;
    }

    private ListNode reverse(ListNode node){
        ListNode prev=null;
        ListNode next=node.next;
        node=node.next;

        while(node!=null){
            next=node.next;
            node.next=prev;
            prev=node;
            node=next;
        }

        return prev;
    }
}
