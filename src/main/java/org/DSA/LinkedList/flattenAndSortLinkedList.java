public class flattenAndSortLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);

        head.next = new ListNode(2);
        head.next.child = new ListNode(10);

        head.next.next = new ListNode(1);
        head.next.next.child = new ListNode(7);
        head.next.next.child.child = new ListNode(11);
        head.next.next.child.child.child = new ListNode(12);

        head.next.next.next = new ListNode(4);
        head.next.next.next.child = new ListNode(9);
        
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.child = new ListNode(6);
        head.next.next.next.next.child.child = new ListNode(8);
        
        System.out.println("Original LL: ");
        ListNode.print(head);
        head=new Solution().flattenLinkedList(head);
    }
    static int countNodes(ListNode head){
        int count=0;
        while(head!=null){
            count++;
            head=head.next;
        }
        return count;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode child;

    ListNode() {
        val = 0;
        next = null;
        child = null;
    }

    ListNode(int data1) {
        val = data1;
        next = null;
        child = null;
    }

    ListNode(int data1, ListNode next1, ListNode next2) {
        val = data1;
        next = next1;
        child = next2;
    }
    public static void print(ListNode node){
        while(node!=null){
            System.out.print(node.val+" -> ");
            if(node.child!=null){
                System.out.print(" |child Node| ");
                print(node.child);
            }
            node=node.next;
        }
        System.out.println();
    }
}
class Solution {
    public ListNode flattenLinkedList(ListNode head) {
        ListNode node=flatten(head);
        System.out.println("after flattening: ");
        ListNode.print(head);
        head=sort(head);
        System.out.println("after sorting: ");
        ListNode.print(head);
        return head;
    }
    private ListNode flatten(ListNode node){
        if(node==null)return node;
        ListNode next=node.next;
        if(node.child!=null){
            node.next=node.child;
            node.child=null;
            node=flatten(node.next);
        }
        node.next=next;
        if(node.next!=null){
            node=node.next;
            return flatten(node);
        }
        return node;
    }
    private ListNode sort(ListNode node){
        if(node==null || node.next==null)return node;
        ListNode mid=findMid(node);
        ListNode head1=node, head2=mid.next;
        mid.next=null;
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
                temp.next=temp1;
                temp1=temp1.next;
            }
            else{
                temp.next=temp2;
                temp2=temp2.next;
            }
            temp=temp.next;
        }
        if(temp1!=null){
            temp.next=temp1;
        }
        if(temp2!=null){
            temp.next=temp2;
        }
        return dummyHead.next;
    }
    private ListNode findMid(ListNode node){
        ListNode slow=node, fast=node.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}