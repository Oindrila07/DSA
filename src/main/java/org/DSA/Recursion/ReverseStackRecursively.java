package org.DSA.Recursion;

import java.util.Stack;

public class ReverseStackRecursively {
    public static void reverseStack(Stack<Integer> st) {
        // Your code goes here
        if(st.isEmpty())return;

        int top=st.pop();
        reverseStack(st);
        insert(st,top);
    }

    private static void insert(Stack<Integer> stack, int curr){
        if(stack.isEmpty()){
            stack.push(curr);
            return;
        }

        int top=stack.pop();
        insert(stack,curr);
        stack.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();

        stack.push(4);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.toString());

        reverseStack(stack);

        System.out.println(stack.toString());
    }
}
