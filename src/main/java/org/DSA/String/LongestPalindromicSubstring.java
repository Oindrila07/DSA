package org.DSA.String;

public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        int len=s.length();

        int[] res={0,0};//Initialize res = {0, 0}, which will hold the inclusive bounds of the answer.

        for(int i=0;i<len;i++){
            int oddLength=expand(i,i,s);
            if(oddLength>(res[1]-res[0]+1)){
                int dist=oddLength/2;
                res[0]=i-dist;
                res[1]=i+dist;
            }

            int evenLength=expand(i,i+1,s);
            if(evenLength>(res[1]-res[0]+1)){
                int dist=evenLength/2-1;
                res[0]=i-dist;
                res[1]=i+1+dist;
            }
        }

        return s.substring(res[0],res[1]+1);
    }

    static int expand(int i, int j, String s) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }

        return (j - i - 1);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("racecar"));
    }
}

/*
Intuition:
----------
In the first approach, we implemented a palindrome check using two pointers. We started by checking the first and last characters, then the second and second last characters, and so on.

Instead of starting the pointers at the edges and moving inwards, the same logic can be applied when starting the pointers at the center and moving outwards. A palindrome mirrors around its center. Let's say you had s = "racecar". If we start both pointers at the middle ("e") and move them away from each other, we can see that at every iteration, the characters match: e -> c -> a -> r.

The previous two approaches focused on the bounds of a substring - i, j. There are O(n
2
 ) bounds, but only O(n) centers. For each index i, we can consider odd-length palindromes by starting the pointers at i, i. To consider the even length palindromes, we can start the pointers at i, i + 1. There are n starting points for the odd-length palindromes and n−1 starting points for the even-length palindromes - that's 2n−1=O(n) starting points in total.

This is very promising - we can lower the minimum iterations required if we focus on the centers instead of on the bounds. Let's use a helper method expand(i, j) that starts two pointers left = i and right = j. In this method, we will consider i, j as a center. When i == j, we are considering odd-length palindromes. When i != j, we are considering even-length palindromes. We will expand from the center as far as we can to find the longest palindrome, and then return the length of this palindrome.

Let's say that we have a center i, i. We call expand and find a length of length. What are the bounds of the palindrome? Because we are centered at i, i, it means length must be odd. If we perform floor division of length by 2, we will get the number of characters dist on each side of the palindrome. For example, given s = "racecar", we have length = 7 and dist = 7 / 2 = 3. There are 3 characters on each side - "rac" on the left and "car" on the right. Therefore, we can determine that the bounds of the palindrome are i - dist, i + dist.

What about a center at i, i + 1? length must be even now. If we have a palindrome with length 2, then length / 2 = 1, but there are zero characters on each side of the center. We can see that dist is too large by 1. Therefore, we will calculate dist as (length / 2) - 1 instead. Now, dist correctly represents the number of characters on each side. The bounds of the palindrome are i - dist, i + 1 + dist.

Algorithm

Create a helper method expand(i, j) to find the length of the longest palindrome centered at i, j.
Set left = i and right = j.
While left and right are both in bounds and s[left] == s[right], move the pointers away from each other.
The formula for the length of a substring starting at left and ending at right is right - left + 1.
However, when the while loop ends, it implies s[left] != s[right]. Therefore, we need to subtract 2. Return right - left - 1.
Initialize ans = [0, 0]. This will hold the inclusive bounds of the answer.
Iterate i over all indices of s.
Find the length of the longest odd-length palindrome centered at i: oddLength = expand(i, i).
If oddLength is the greatest length we have seen so far, i.e. oddLength > ans[1] - ans[0] + 1, update ans.
Find the length of the longest even-length palindrome centered at i: evenLength = expand(i, i + 1).
If evenLength is the greatest length we have seen so far, update ans.
Retrieve the answer bounds from ans as i, j. Return the substring of s starting at index i and ending with index j.
 */