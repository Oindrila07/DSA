package org.DSA.TwoPointers;

public class LongestSubstringWithoutRepeatingChars {
    public static void main(String[] args) {
        String s="pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s) {
        int[] freq=new int[256];

        int i=0, j=0, len=0, count=0;

        while(j<s.length()){
            if(freq[s.charAt(j)]>0){
                len=Math.max(len,count);

                while(i<s.length() && freq[s.charAt(j)]>0){
                    freq[s.charAt(i)]--;
                    i++;
                }
            }

            freq[s.charAt(j)]++;
            count=(j-i+1);
            j++;
        }

        return Math.max(len,count);
    }
}
