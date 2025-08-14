package org.DSA.SlidingWindow;

public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        if(t.length()>s.length())return "";

        int[] tChars=new int[256];// Frequency of characters in t
        int[] sChars=new int[256];// Frequency of characters in current window

        for(char c:t.toCharArray()){
            tChars[c]++;
        }

        int i=0,j=0, len=Integer.MAX_VALUE, startIndex=-1, required=0, count=0;

        // Count how many unique chars are required:
        for(int num:tChars){
            if(num>0)count++;
        }

        while(j<s.length()){
            sChars[s.charAt(j)]++;// Add current char at j to window

            // If this char matches exactly the required freq in t
            if(tChars[s.charAt(j)]>0 && sChars[s.charAt(j)]==tChars[s.charAt(j)])required++;

            // Shrink window from the left if all required chars are matched
            while(i<=j && required==count){
                // Update min length if smaller window found
                if(len>(j-i+1)){
                    len=j-i+1;
                    startIndex=i;
                }

                // If removing s[i] breaks the requirement, decrement required
                if(tChars[s.charAt(j)]>0 && sChars[s.charAt(i)]==tChars[s.charAt(i)])required--;

                // Remove s[i] from window and move left pointer
                sChars[s.charAt(i)]--;
                i++;
            }

            j++;
        }

        return len==Integer.MAX_VALUE?"":s.substring(startIndex,startIndex+len);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s,t));
    }
}

/*
Intuition:
----------
We’re trying to find the smallest substring in s that contains all the characters in t (including duplicates).
A sliding window is perfect here because:
=> We only expand j to include more characters.
=> We shrink i to remove unnecessary characters while still keeping all required characters in the window.
=> We track counts of each character to know when our window contains all required chars.

Approach:
---------
1) Character Frequency Map for t:
=> We store tChars as a frequency map of characters in t to know exactly how many times each char is required.

2) Track Unique Requirement:
=> Instead of matching total characters, we track count = number of unique characters in t.
=> required will track how many unique characters are currently fully matched in the window.

3) Expand with j:
=> Add s[j] into our current window (sChars).
=> If adding this char makes it match the required count in tChars, we increment required.

4) Shrink with i:
=> If all unique chars are matched (required == count), try shrinking from the left:
=> Update the minimum length window if this one is smaller.
=> Before moving i, check if removing s[i] breaks a requirement. If so, decrement required.

Always decrement sChars[s[i]] and move i forward.

Return the Smallest Window

If no valid window found, return "".
Otherwise, return the substring from startIndex of length len.
 */