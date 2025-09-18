package org.DSA.LinkedList;

public class AddTwoLists2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(countNodes(l1)<countNodes(l2))return addTwoNumbers(l2,l1);
        ListNode head1=reverse(l1);
        ListNode head2=reverse(l2);
        ListNode temp1=head1, temp2=head2;
        int carry=0;

        while(temp1!=null && temp2!=null){
            int sum=(temp1.val+temp2.val+carry);
            if(sum>9){
                carry=sum/10;
                sum=sum%10;
            }
            else carry=0;
            temp1.val=sum;
            temp1=temp1.next;
            temp2=temp2.next;
        }

        while(temp1!=null){
            int sum=(temp1.val+carry);
            if(sum>9){
                carry=sum/10;
                sum=sum%10;
            }
            else carry=0;
            temp1.val=sum;
            temp1=temp1.next;
        }

        ListNode res=reverse(head1);
        if(carry>0){
            ListNode node=new ListNode(carry);
            node.next=res;
            res=node;
        }

        return res;
    }

    private ListNode reverse(ListNode node){
        ListNode prev=null, next=null;

        while(node!=null){
            next=node.next;
            node.next=prev;
            prev=node;
            node=next;
        }

        return prev;
    }

    private int countNodes(ListNode node){
        int count=0;

        while(node!=null){
            count++;
            node=node.next;
        }
        return count;
    }
}
