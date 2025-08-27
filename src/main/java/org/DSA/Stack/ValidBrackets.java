package org.DSA.Stack;

import java.util.Stack;

public class ValidBrackets {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();

        int index=1;
        stack.push(s.charAt(0));

        while(index<s.length()){
            if(!stack.isEmpty()){
                if((s.charAt(index)==')' && stack.peek()!='(')
                        || (s.charAt(index)=='}' && stack.peek()!='{')
                        || (s.charAt(index)==']' && stack.peek()!='[')
                ) return false;

                if((stack.peek()=='(' && s.charAt(index)==')') ||
                        stack.peek()=='{' && s.charAt(index)=='}' ||
                        stack.peek()=='[' && s.charAt(index)==']'
                ){
                    stack.pop();
                    index++;
                    continue;
                }
            }

            stack.push(s.charAt(index));
            index++;
        }

        return stack.isEmpty();
    }
}

class ValidBracketsMain{
    public static void main(String[] args) {
        String s = "(){}[";
        System.out.println(new ValidBrackets().isValid(s));
    }
}
