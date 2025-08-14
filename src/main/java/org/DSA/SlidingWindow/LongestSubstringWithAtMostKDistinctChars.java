package org.DSA.SlidingWindow;

public class LongestSubstringWithAtMostKDistinctChars {
    public static int kDistinctChars(int k, String str) {
        // Write your code here
        int[] freq=new int[26];

        int i=0, j=0, len=0, count=0;

        while(j<str.length()){
            if(freq[str.charAt(j)-'a']<=0)count++;
            freq[str.charAt(j)-'a']++;

            while(i<=j && count>k){
                freq[str.charAt(i)-'a']--;
                if(freq[str.charAt(i)-'a']<=0)count--;
                i++;
            }

            len=Math.max(len,(j-i+1));
            j++;
        }

        return len;
    }

    public static void main(String[] args) {
        String s="yxtliihdnnrlhjomdhfektogqbnxs";
        int k=11;
        System.out.println(kDistinctChars(k,s));
    }
}
