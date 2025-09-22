package org.DSA.LinkedList;

//sequential merge of lists: (Better Approach)
//TC = O(NK)

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)return null;
        ListNode res=lists[0];
        for(int i=1;i<lists.length;i++){
            res=merge(res,lists[i]);
        }

        return res;
    }

    private ListNode merge(ListNode list1, ListNode list2){
        ListNode temp1=list1, temp2=list2;
        ListNode head=new ListNode(0);
        ListNode tail=head;
        while(temp1!=null && temp2!=null){
            if(temp1.val<=temp2.val){
                tail.next=temp1;
                tail=tail.next;
                temp1=temp1.next;
            }
            else if(temp1.val>temp2.val){
                tail.next=temp2;
                tail=tail.next;
                temp2=temp2.next;
            }
        }

        while(temp1!=null){
            tail.next=temp1;
            temp1=temp1.next;
            tail=tail.next;
        }
        while(temp2!=null){
            tail.next=temp2;
            temp2=temp2.next;
            tail=tail.next;
        }
        return head.next;
    }
}
