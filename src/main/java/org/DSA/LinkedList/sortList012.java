public class sortList012 {
    public static void main(String[] args) {
        ListNode head=new ListNode(2);
        head.next=new ListNode(2);
        head.next.next=new ListNode(0);
        head.next.next.next=new ListNode(2);
        ListNode.print(head);
        head=new Solution().sortList(head);
        ListNode.print(head);
    }
}

class ListNode{
    public int data;
    public ListNode next;
    ListNode() { data = 0; next = null; }
    ListNode(int x) { data = x; next = null; }
    ListNode(int x, ListNode next) { data = x; this.next = next; }
    public static void print(ListNode head){
        while(head!=null){
            System.out.print(head.data+" -> ");
            head=head.next;
        }
        System.out.println();
    }
}

class Solution {
    public ListNode sortList(ListNode head) {
        //YOUR CODE GOES HERE
        ListNode head0=null, head1=null, head2=null;
        ListNode temp=head, temp0=null, temp1=null, temp2=null;
        while(temp!=null){
            if(temp.data==0){
                if(head0==null){
                    head0=temp;
                    temp0=head0;
                    temp=temp.next;
                    temp0.next=null;
                }
                else{
                    temp0.next=temp;
                    temp=temp.next;
                    temp0=temp0.next;
                    temp0.next=null;
                }
            }
            else if(temp.data==1){
                if(head1==null){
                    head1=temp;
                    temp1=head1;
                    temp=temp.next;
                    temp1.next=null;
                }
                else{
                    temp1.next=temp;
                    temp=temp.next;
                    temp1=temp1.next;
                    temp1.next=null;
                }
            }
            else {
                if(head2==null){
                    head2=temp;
                    temp2=head2;
                    temp=temp.next;
                    temp2.next=null;
                }
                else{
                    temp2.next=temp;
                    temp=temp.next;
                    temp2=temp2.next;
                    temp2.next=null;
                }
            }
        }
        if(head0!=null){
            head=head0;
            temp0.next=head1;
            if(head1!=null){
                temp1.next=head2;
            }
            else{
                temp0.next=head2;
            }
        }
        if(head0==null && head1!=null){
            head=head1;
            temp1.next=head2;
        }
        if(head0==null && head1==null){
            head=head2;
        }
        return head;
    }
}