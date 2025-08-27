package org.DSA.Stack;

import java.util.Stack;

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack=new Stack<>();
        boolean[] visited=new boolean[26];

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(!visited[ch-'a']){
                while(!stack.isEmpty() && stack.peek()>ch  && i<s.lastIndexOf(stack.peek())){
                    char x=stack.pop();
                    visited[x-'a']=false;
                }
                stack.push(ch);
                visited[ch-'a']=true;
            }
        }

        StringBuilder sb=new StringBuilder();

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        sb.reverse();

        return sb.toString();
    }
}

class RemoveDupsMain {
    public static void main(String[] args) {
        System.out.println(new RemoveDuplicateLetters().removeDuplicateLetters("cbacdcbc"));
    }
}

/*
Intuition:
----------
So the problem states to remove duplicate letters and return the substring which is lexicographically the smallest:

=> The idea is to create a stack and store all the characters in increasing order
=> Traverse the string and for each character do the following:
1) while the stack is not empty and the top character from the stack > current character and also if it is the top character's last occurrence:
    then pop the characters out until the conditions fail
2) then push the character onto the stack
3) mark the character as visited.

=> This way the characters are stored in order
=> No duplicates are considered
=> It also ensures that if a character appears for the last time and is greater than the current character, then we do not pop that
 */
