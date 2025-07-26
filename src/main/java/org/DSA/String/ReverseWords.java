package org.DSA.String;

public class ReverseWords {
    public static String reverseWords(String s) {
        String[] words=s.trim().split(" ");

        StringBuilder sb=new StringBuilder();

        for(int i=words.length-1;i>=0;i--){
            if(!words[i].equals("")){
                sb.append(words[i]);
                if(i>0){
                    sb.append(" ");
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s="a good   example";
        System.out.println(reverseWords(s));
    }
}
