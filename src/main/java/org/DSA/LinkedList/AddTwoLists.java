package org.DSA.LinkedList;

import java.util.Arrays;
import java.util.List;

public class AddTwoLists {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1=l1;
        ListNode temp2=l2;

        ListNode res=new ListNode(0);
        ListNode head=res;

        int carry=0;

        while(temp1!=null || temp2!=null){
            int x=temp1!=null?temp1.val:0;
            int y=temp2!=null?temp2.val:0;
            int sum=x+y+carry;

            if(sum>9){
                carry=sum/10;
                sum=sum%10;
            }else carry=0;

            head.val=sum;

            if(temp1!=null)
                temp1=temp1.next;
            if(temp2!=null)
                temp2=temp2.next;

            if(temp1!=null || temp2!=null){
                head.next=new ListNode();;
                head=head.next;
            }
        }

        if(carry>0){
            head.next=new ListNode(carry);
        }

        return res;
    }

    public static void main(String[] args) {
        ListNode l1=new ListNode();
        ListNode l2=new ListNode();

        List<Integer> list1=Arrays.asList(9,9,9,9,9,9,9);
        List<Integer> list2=Arrays.asList(9,9,9,9);

        ListNode temp=l1;
        temp.val=list1.get(0);

        for(int i=1;i<list1.size();i++){
            temp.next=new ListNode(list1.get(i));
            temp=temp.next;
        }

        temp=l2;
        temp.val=list2.get(0);

        for(int i=1;i<list2.size();i++){
            temp.next=new ListNode(list2.get(i));
            temp=temp.next;
        }

        ListNode res=new ListNode();
        res=addTwoNumbers(l1,l2);
        print(res);
    }

    public static void print(ListNode res){
        while(res!=null){
            System.out.print(res.val+" ");
            res=res.next;
        }
    }
}
