public class flattenAndSortChildLL {
    public ListNode flattenLinkedList(ListNode head) {
        ListNode node=flatten(head);
        head=sort(head);
        return head;
    }
    private ListNode flatten(ListNode node){
        if(node==null)return node;
        ListNode next=node.next, child=node;
        while(child.child!=null){
            child=child.child;
        }
        child.child=next;
        node.next=null;
        return flatten(next);
    }
    private ListNode sort(ListNode node){
        if(node==null || node.child==null)return node;
        ListNode mid=findMid(node);
        ListNode head1=node, head2=mid.child;
        mid.child=null;
        head1=sort(head1);
        head2=sort(head2);
        node=merge(head1,head2);
        return node;
    }
    private ListNode merge(ListNode node1, ListNode node2){
        ListNode temp1=node1, temp2=node2;
        ListNode dummyHead=new ListNode(-1), temp=dummyHead;
        while(temp1!=null && temp2!=null){
            if(temp1.val<=temp2.val){
                temp.child=temp1;
                temp1=temp1.child;
            }
            else{
                temp.child=temp2;
                temp2=temp2.child;
            }
            temp=temp.child;
        }
        if(temp1!=null){
            temp.child=temp1;
        }
        if(temp2!=null){
            temp.child=temp2;
        }
        return dummyHead.child;
    }
    private ListNode findMid(ListNode node){
        ListNode slow=node, fast=node.child;
        while(fast!=null && fast.child!=null){
            slow=slow.child;
            fast=fast.child.child;
        }
        return slow;
    }
}