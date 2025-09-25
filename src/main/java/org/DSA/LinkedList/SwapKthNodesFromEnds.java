package org.DSA.LinkedList;

public class SwapKthNodesFromEnds {
    public Node swapKth(Node head, int k) {
        // code here
        int n=countNodes(head);
        if(k>n)return head;

        Node first=head, second=head, firstPrev=null, secondPrev=null, firstNext=null, secondNext=null;

        for(int i=1;i<k;i++){
            firstPrev=first;
            first=first.next;
        }
        for(int i=1;i<n-k+1;i++){
            secondPrev=second;
            second=second.next;
        }

        if(firstPrev!=null){
            firstPrev.next=second;
        }
        else head=second;

        if(secondPrev!=null){
            secondPrev.next=first;
        }
        else head=first;

        if(first.next==second){
            Node temp=second.next;
            second.next=first;
            first.next=temp;
        }
        else if(second.next==first){
            Node temp=first.next;
            first.next=second;
            second.next=temp;
        }
        else{
            Node temp=first.next;
            first.next=second.next;
            second.next=temp;
        }

        return head;
    }

    private int countNodes(Node node){
        int count=0;
        while(node!=null){
            node=node.next;
            count++;
        }
        return count;
    }
}
