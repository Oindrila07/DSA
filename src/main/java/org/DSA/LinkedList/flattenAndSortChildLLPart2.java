class flattenAndSortChildLLPart2 {
    public ListNode flattenLinkedList(ListNode head) {
        ListNode dummyHead=new ListNode(-1), t1=dummyHead, t2=null, next=null;
        t1.child=head;
        next=head.next;
        head.next=null;
        while(next!=null){
            t2=next;
            next=next.next;
            t2.next=null;
            t1=merge(t1,t2);
        }
        return dummyHead.child;
    }
    private ListNode merge(ListNode t1, ListNode t2){
        ListNode dummy=new ListNode(-2), temp=dummy;
        while(t1!=null && t2!=null){
            if(t1.val<=t2.val){
                temp.child=t1;
                t1=t1.child;
            }
            else{
                temp.child=t2;
                t2=t2.child;
            }
            temp=temp.child;
        }
        if(t1!=null){
            temp.child=t1;
        }
        if(t2!=null){
            temp.child=t2;
        }
        return dummy.child;
    }
}