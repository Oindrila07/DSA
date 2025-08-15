package org.DSA.LinkedList;

import java.util.Arrays;
import java.util.List;

public class MergeTwoSortedLists {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null)return list2;
        if(list2==null)return list1;

        ListNode res=new ListNode();

        ListNode temp=res;

        ListNode temp1=list1;
        ListNode temp2=list2;

        while(temp1!=null && temp2!=null){
            if(temp1.val<=temp2.val){
                temp.val=temp1.val;
                temp1=temp1.next;
            }
            else{
                temp.val=temp2.val;
                temp2=temp2.next;
            }

            if(temp1!=null || temp2!=null){
                temp.next=new ListNode();
                temp=temp.next;
            }
        }

        while(temp1!=null){
            temp.val=temp1.val;
            temp1=temp1.next;
            if(temp1!=null){
                temp.next=new ListNode();
                temp=temp.next;
            }
        }

        while(temp2!=null){
            temp.val=temp2.val;
            temp2=temp2.next;
            if(temp2!=null){
                temp.next=new ListNode();
                temp=temp.next;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        ListNode l1=new ListNode();
        ListNode l2=new ListNode();

        List<Integer> list1= Arrays.asList(3,6,9,59,70);
        List<Integer> list2=Arrays.asList(48);

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
        res=mergeTwoLists(l1,l2);
        print(res);
    }

    public static void print(ListNode res){
        while(res!=null){
            System.out.print(res.val+" ");
            res=res.next;
        }
    }
}
