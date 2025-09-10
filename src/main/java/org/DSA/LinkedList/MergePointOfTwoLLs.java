package org.DSA.LinkedList;

import java.util.Scanner;

public class MergePointOfTwoLLs {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();

        while(t-->0){
            int index=sc.nextInt();
            int count1=sc.nextInt();
            LinkedListNode<Integer> head1=new LinkedListNode<>(sc.nextInt());
            count1--;
            LinkedListNode<Integer> list1=head1;
            while(count1-->0){
                list1.next=new LinkedListNode<>(sc.nextInt());
                list1=list1.next;
            }
            int count2=sc.nextInt();
            LinkedListNode<Integer> head2=new LinkedListNode<>(sc.nextInt());
            count2--;
            int i=0, value=head2.data;
            LinkedListNode<Integer> list2=head2;
            while(count2-->0){
                list2.next=new LinkedListNode<>(sc.nextInt());
                list2=list2.next;
            }
            LinkedListNode<Integer> temp=head1;
            while(temp!=null && i!=index){
                temp=temp.next;
                i++;
            }
            list2.next=temp;
            list2=list2.next;
            value=list2.data;

            System.out.println(value);
        }
    }
}

class LinkedListNode<T> {
    T data;
    LinkedListNode<T> next;

    LinkedListNode(){}

    LinkedListNode(T data){
        this.data=data;
    }
}
