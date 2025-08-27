package org.DSA.Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class MaxElement {
    public static List<Integer> getMax(List<String> operations) {
        // Write your code here
        List<Integer> list=new ArrayList<>();

        Stack<Integer> stack1=new Stack<>();
        Stack<Integer> stack2=new Stack<>();

        for(int i=0;i<operations.size();i++){
            int[] arr= Arrays.stream(operations.get(i).split(" ")).
                    mapToInt(Integer::parseInt).
                    toArray();

            if(arr.length>1 && arr[0]==1){
                stack1.push(arr[1]);

                if(stack2.isEmpty() || stack2.peek()<=arr[1]){
                    stack2.push(arr[1]);
                }
            }
            else if(arr[0]==2){
                int x=stack1.pop();

                if(!stack2.isEmpty() && stack2.peek().equals(x))stack2.pop();
            }
            else if(!stack2.isEmpty())list.add(stack2.peek());
        }

        return list;
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("1 97","2","1 20","2","1 26","1 20","3","1 91","3","2","2","3");
        System.out.println(getMax(list));
    }
}

/*
Implemented using the idea of maxStack
 */
