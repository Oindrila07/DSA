package org.DSA.Stack;

import java.util.Stack;

public class QueueUsingStack {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public QueueUsingStack() {
        stack1=new Stack<>();
        stack2=new Stack<>();
    }

    public void push(int x) {
        stack2.push(x);
    }

    public int pop() {
        if(!stack1.isEmpty())return stack1.pop();

        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }

        return stack1.pop();
    }

    public int peek() {
        if(!stack1.isEmpty())return stack1.peek();

        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }

        return stack1.peek();
    }

    public boolean empty() {
        return stack2.isEmpty() && stack1.isEmpty();
    }
}

class Example{
    public static void main(String[] args) {
        QueueUsingStack queue=new QueueUsingStack();

        queue.push(1);
        queue.push(3);
        queue.push(5);
        queue.push(4);

        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.peek());
    }
}
