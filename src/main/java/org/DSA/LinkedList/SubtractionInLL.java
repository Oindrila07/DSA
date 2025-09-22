package org.DSA.LinkedList;

public class SubtractionInLL {
    static Node subLinkedList(Node head1, Node head2) {
        // code here
        int n1=countNodes(head1), n2=countNodes(head2);
        if(n1<n2 || (n1==n2 && compare(head1,head2)<0))return subLinkedList(head2,head1);

        int carry=0;
        head1=reverse(head1);
        head2=reverse(head2);
        Node temp1=head1, temp2=head2;

        while(temp1!=null && temp2!=null){
            int a=temp1.data;
            int b=temp2.data+carry;
            if(a<b){
                a=10+a;
                carry=1;
            }
            else carry=0;
            temp1.data=a-b;
            temp1=temp1.next;
            temp2=temp2.next;
        }

        while(carry>0 && temp1!=null){
            int a=temp1.data;
            int b=carry;
            if(a<carry){
                carry=1;
                a=10+a;
            }
            else carry=0;
            temp1.data=a-b;
            temp1=temp1.next;
        }

        head1=reverse(head1);

        while(head1.data==0 && head1.next!=null){
            head1=head1.next;
        }

        return head1;
    }

    static private int countNodes(Node node){
        int count=0;

        while(node!=null){
            node=node.next;
            count++;
        }

        return count;
    }

    static private Node reverse(Node node){
        Node prev=null, next=null;

        while(node!=null){
            next=node.next;
            node.next=prev;
            prev=node;
            node=next;
        }

        return prev;
    }

    static private int compare(Node node1, Node node2){
        while(node1!=null && node2!=null){
            if(node1.data!=node2.data)return node1.data-node2.data;
            node1=node1.next;
            node2=node2.next;
        }
        return 0;
    }
}
