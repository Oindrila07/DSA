package org.DSA.Stack;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<StringBuilder> stack=new Stack<>();
        Stack<Integer> count=new Stack<>();
        int num=0;
        StringBuilder res=new StringBuilder();

        for(int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))){
                num=num*10+(s.charAt(i)-'0');
            }
            else if(s.charAt(i)=='['){
                count.push(num);
                num=0;
                stack.push(res);
                res=new StringBuilder();
            }
            else if(s.charAt(i)==']'){
                int cnt=count.pop();
                StringBuilder decode=stack.isEmpty()?new StringBuilder():stack.pop();

                while(cnt-->0){
                    decode.append(res);
                }
                res=decode;
            }
            else res.append(s.charAt(i));
        }

        return res.toString();
    }
}

class DecodeStringMain {
    public static void main(String[] args) {
        String s="3[a2[c]]";
        System.out.println(new DecodeString().decodeString(s));
    }
}
