package org.DSA.Stack;

import java.util.Stack;

class MinStack {
    Stack<Integer> stack;
    Stack<Integer> stackMin;

    public MinStack() {
        stack=new Stack<>();
        stackMin=new Stack<>();
    }

    public void push(int val) {
        stack.push(val);

        if(stackMin.isEmpty() || val<=stackMin.peek()){
            stackMin.push(val);
        }
    }

    public void pop() {
        int x=stack.pop();

        if(!stackMin.isEmpty() && stackMin.peek().equals(x)){
            stackMin.pop();
        }
    }

    public int top() {
        return !stack.isEmpty()?stack.peek():-1;
    }

    public int getMin() {
        return !stackMin.isEmpty()?stackMin.peek():-1;
    }
}

class Main {
    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);

        System.out.println(stack.top());
        System.out.println(stack.getMin());

        stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.getMin());

        stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.getMin());
    }
}