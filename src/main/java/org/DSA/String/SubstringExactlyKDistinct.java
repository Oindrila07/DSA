package org.DSA.String;

import java.util.HashMap;

public class SubstringExactlyKDistinct {
    static int countSubstr(String s, int k) {
        // your code here
        return countAtMostK(s,k)-countAtMostK(s,k-1);
    }

    private static int countAtMostK(String s, int k){
        int i=0, j=0, count=0;

        HashMap<Character,Integer> hash=new HashMap<>();

        while(j<s.length()){
            hash.put(s.charAt(j),hash.getOrDefault(s.charAt(j),0)+1);

            while(hash.size()>k){
                Character left=s.charAt(i);
                hash.put(left,hash.get(left)-1);
                if(hash.get(left)==0)hash.remove(left);
                i++;
            }

            count+=(j-i+1);

            j++;
        }

        return count;
    }

    public static void main(String[] args) {
        String s="abcabc";
        int k=2;
        System.out.println(countSubstr(s,k));
    }
}

/*Intuition:
------------
Instead of checking exactly k distinct characters directly, we leverage this key idea:

Any string with exactly k distinct characters is the difference between substrings with at most k distinct characters and those with at most k-1 distinct characters.

💡 Why?
Substrings with at most k characters include those with 1, 2, ..., k

Substrings with at most k-1 characters include those with 1, 2, ..., k-1

So the difference gives us substrings with exactly k distinct characters

✨ Formula:
java
Copy
Edit
exactlyK = atMostK(k) - atMostK(k - 1)

Approach:
Use two pointers: i (left), j (right)

Maintain a HashMap to store frequency of characters in the current window [i, j]

Expand j to include more characters

If the window becomes invalid (more than k distinct chars), move i to shrink it

For every position of j, the number of valid substrings ending at j is (j - i + 1)

🔍 Why (j - i + 1)?
Let’s say:

Window = [i, j]

Then substrings are: s[i..j], s[i+1..j], ..., s[j..j]

Total = j - i + 1 substrings

Time Complexity: O(n)
Space Complexity: O(k) - > at most k characters to be stored in hashmap
 */