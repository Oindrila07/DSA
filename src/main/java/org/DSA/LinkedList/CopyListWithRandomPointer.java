package org.DSA.LinkedList;

import java.util.HashMap;

public class CopyListWithRandomPointer {
    public Node2 copyRandomList(Node2 head) {
        if(head==null)return head;
        Node2 res=new Node2(head.val);
        Node2 temp1=head.next, temp2=res;
        HashMap<Node2,Node2> map=new HashMap<>();
        map.put(head,res);
        while(temp1!=null){
            temp2.next=new Node2(temp1.val);
            temp2=temp2.next;
            map.put(temp1,temp2);
            temp1=temp1.next;
        }
        temp1=head;
        temp2=res;
        while(temp1!=null){
            temp2.random=map.get(temp1.random);
            temp1=temp1.next;
            temp2=temp2.next;
        }
        return res;
    }
}

class Node2 {
    int val;
    Node2 next;
    Node2 random;

    public Node2(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}


/*
Approach:
---------
=> Create a hashmap to map original nodes to their corresponding copied nodes.
=> Traverse the original linked list using a pointer temp1.
=> While temp1 is not null:
    - Create a new node with the same value as the current node and store it in the map with the current node as the key.
    - Move temp1 to the next node in the original list.
    - Reset the temp1 pointer to the head of the original linked list.

=> Traverse the original linked list again using temp1.
=> While cur is not null:
    -> Retrieve the copied node from the hash dictionary using temp1 as the key.
    -> Set the next pointer of the copy node to the copied node obtained from the hash dictionary using temp1.next as the key.
    -> Set the random pointer of the copy node to the copied node obtained from the hash dictionary using temp1.random as the key.
    -> Move temp1 to the next node in the original list.
    -> Return the copied head node obtained from the hash dictionary using the original head node as the key.

This algorithm first creates a mapping of original nodes to their copied nodes and then iterates through the original list twice to connect the next and random pointers of the copied nodes. Finally, it returns the head of the copied linked list.
 */