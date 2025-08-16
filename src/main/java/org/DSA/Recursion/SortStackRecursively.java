package org.DSA.Recursion;

import java.util.Stack;

public class SortStackRecursively {
    public static void sortStack(Stack<Integer> st) {
        // Your code goes here
        if(st.isEmpty())return;

        int top=st.pop();
        sortStack(st);
        insertSorted(st,top);
    }

    private static void insertSorted(Stack<Integer> stack, int curr){
        if(stack.isEmpty() || curr>=stack.peek()){
            stack.push(curr);
            return;
        }

        int temp=stack.pop();
        insertSorted(stack,curr);
        stack.push(temp);
    }

    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();

        stack.push(4);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.peek());

        sortStack(stack);

        System.out.println(stack.peek());
        System.out.println(stack.toString());
    }
}

/*
⚡ Key Idea:
-----------
Think of recursion as a way to peel the stack apart one element at a time, sort the smaller problem, and then put the element back in the right place.

Recursive Decomposition:
=> Pop the top element.
=> Recursively sort the remaining stack.
=> Insert the popped element into the already sorted smaller stack.
=> Helper Function (Insert in Sorted Order):
=> If the stack is empty or the element is bigger than the top → just push it.
=> Otherwise, pop the top, recursively insert into the smaller stack, and then push the popped element back.

🔄 Approach Step by Step:
-------------------------
=> sortStack(stack)
=> Base case: if stack is empty, return.

Recursive step:
=> Pop the top element.
=> Call sortStack on the reduced stack (this ensures smaller stack gets sorted).
=> Call insertSorted to place the popped element in the correct position.

insertSorted(stack, element):
=> Base case: if stack is empty or element >= top, push it directly.
Recursive step:
=> Pop the top, call insertSorted on the rest, then push the top back.

🎯 Intuition:
It’s just like insertion sort, but done recursively:
Each recursive call ensures the stack below is sorted.
Then we carefully insert the current element where it belongs.

⏱️ Time & Space Complexity:
---------------------------
Time Complexity: O(n²) in worst case (each insertion can take O(n), and we do it for n elements).
Space Complexity: O(n) due to recursion call stack.
 */
