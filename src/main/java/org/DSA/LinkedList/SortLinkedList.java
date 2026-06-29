import java.util.*;
public class Main {
    public static void main(String[] args) {
        ListNode head=new ListNode(4);
        head.next=new ListNode(2);
        head.next.next=new ListNode(1);
        head.next.next.next=new ListNode(5);
        head.next.next.next.next=new ListNode(3);
        ListNode.print(head);
        head=new Solution().sortList(head);
        ListNode.print(head);
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    public static void print(ListNode head){
        while(head!=null){
            System.out.print(head.val+" -> ");
            head=head.next;
        }
        System.out.println();
    }
}
class Solution {
    public ListNode sortList(ListNode head) {
        return sort(head);
    }
    private ListNode sort(ListNode node){
        if(node==null || node.next==null)return node;
        ListNode mid=findMid(node);
        ListNode left=node, right=mid.next;
        mid.next=null;
        ListNode node1=sort(left);
        ListNode node2=sort(right);
        node=merge(node1,node2);
        return node;
    }
    private ListNode merge(ListNode node1, ListNode node2){
        ListNode head=new ListNode(-101);
        ListNode temp=head;
        while(node1!=null && node2!=null){
            if(node1.val<=node2.val){
                temp.next=node1;
                node1=node1.next;
            }
            else{
                temp.next=node2;
                node2=node2.next;
            }
            temp=temp.next;
        }
        if(node1!=null){
            temp.next=node1;
        }
        if(node2!=null){
            temp.next=node2;
        }
        return head.next;
    }
    private ListNode findMid(ListNode head){
        ListNode slow=head, fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}