package org.DSA.SlidingWindow;

public class LongestRepeatingCharacterReplacement {
    public static int characterReplacement(String s, int k) {
        int[] freq=new int[26];

        int len=0, i=0, j=0, count=0, maxFreq=0;

        while(j<s.length()){
            freq[s.charAt(j)-'A']++;
            maxFreq=Math.max(maxFreq,freq[s.charAt(j)-'A']);
            int currLen=j-i+1;

            while(i<=j && currLen-maxFreq>k){
                freq[s.charAt(i)-'A']--;
                maxFreq=Math.max(freq[s.charAt(i)-'A'],maxFreq);// can be skipped but makes sense to add
                i++;
                currLen=j-i+1;
            }
            len=Math.max(len,j-i+1);
            j++;
        }

        return len;
    }

    public static void main(String[] args) {
        String s="ABABBBCCCCCC";
        int k=2;
        System.out.println(characterReplacement(s,k));
    }
}

/*
Intuition:
----------
The key observation:

In any valid substring, the minimum number of replacements needed to make all characters the same is:
(current window length) − (frequency of the most frequent character in that window)

Why?
Because if the most frequent character appears maxFreq times, the rest of the characters in that window can be turned into it using replacements.

We want: window length − maxFreq <= k
If this is true, we can make the window uniform with ≤ k replacements.

Approach:
---------
=> We use a sliding window with two pointers (i for start, j for end):
=> Expand the window by moving j right.
=> Track character frequencies using an int[26] array.
=> Keep track of maxFreq = highest frequency of any char in the current window.
=> If the condition (window length − maxFreq) > k fails, shrink the window from the left (i++).
=> Update the answer with the largest window length that meets the condition.
 */
