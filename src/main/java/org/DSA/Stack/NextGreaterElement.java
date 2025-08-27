package org.DSA.Stack;

import java.util.ArrayList;
import java.util.Stack;

public class NextGreaterElement {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        Stack<Integer> stack=new Stack<>();

        ArrayList<Integer> list=new ArrayList<>();

        for(int i=0;i<arr.length;i++){
            list.add(-1);//initialize all elements as -1
        }

        //traverse from back towards front
        for(int index=arr.length-1;index>=0;index--){
            while(!stack.isEmpty() && arr[index]>=stack.peek()){//keep looping until stack becomes empty and current element is smaller than the top element
                stack.pop();
            }

            //after popping required elements, if stack is empty, set -1
            if(stack.isEmpty()){
                list.set(index,-1);
            }
            else list.set(index,stack.peek());//else set the top value from stack

            stack.push(arr[index]);//and push every element into the stack
        }

        return list;
    }
}

class NextGreaterElMain {
    public static void main(String[] args) {
        int[] arr = {6, 8, 0, 1, 41, 88, 58, 69, 93, 42, 44, 25, 12, 47, 41, 88, 58, 69, 93, 42, 44, 25, 12, 47};
        System.out.println(new NextGreaterElement().nextLargerElement(arr));
    }
}
