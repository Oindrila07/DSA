package org.DSA.Queue;

class Node{
    int data;
    Node next;

    Node(){}

    Node(int data){
        this.data=data;
    }
}

class LinkedListQueue {
    Node front, rear;

    public LinkedListQueue() {

    }

    public void push(int x) {
        if(rear==null){
            rear=new Node(x);
        }
        else{
            rear.next=new Node(x);
            rear=rear.next;
        }

        if(front==null){
            front=rear;
        }
    }

    public int pop() {
        int x=front.data;
        front=front.next;
        return x;
    }

    public int peek() {
        return front.data;
    }

    public boolean isEmpty() {
        return front==null;
    }
}


class LLQueueMain {
    public static void main(String[] args) {
        LinkedListQueue queue=new LinkedListQueue();
        queue.push(2);
        System.out.println(queue.pop());
        System.out.println(queue.isEmpty());
    }
}