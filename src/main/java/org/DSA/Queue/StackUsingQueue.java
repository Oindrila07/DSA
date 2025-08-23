package org.DSA.Queue;

import org.DSA.Stack.QueueUsingStack;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackUsingQueue {
    private Queue<Integer> queue;

    public StackUsingQueue() {
        queue=new ArrayDeque<>();
    }

    public void push(int x) {
        queue.offer(x);

        int len=queue.size();
        int index=0;

        while(index<len-1){
            queue.offer(queue.poll());
            index++;
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}

class Example{
    public static void main(String[] args) {
        StackUsingQueue stack=new StackUsingQueue();

        stack.push(1);
        stack.push(3);
        stack.push(5);
        stack.push(4);

        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.top());
    }
}
