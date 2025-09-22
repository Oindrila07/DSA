package org.DSA.LinkedList;

import java.util.Stack;

public class FlattenMultiLevelDoublyLL {
    public Node flatten(Node head) {
        Node temp=head;
        Stack<Node> stack=new Stack<>();

        while(temp!=null){
            if(temp.child!=null){
                if(temp.next!=null)stack.push(temp.next);
                temp.next=temp.child;
                temp.child=null;
                temp.next.prev=temp;
                temp=temp.next;
                continue;
            }
            if(!stack.isEmpty() && temp.next==null){
                Node node=stack.pop();
                temp.next=node;
                node.prev=temp;
            }

            temp=temp.next;
        }

        return head;
    }
}

class Node {
    int data;
    Node prev=null;
    Node next=null;
    Node child=null;

    Node(int data){
        this.data=data;
    }

    Node(int data, Node prev, Node next, Node child){
        this.data=data;
        this.prev=prev;
        this.next=next;
        this.child=child;
    }
}
