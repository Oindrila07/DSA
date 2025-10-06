package org.DSA.HashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> list=new ArrayList<>();
        HashMap<String,Integer> hash=new HashMap<>();

        // 1) Put reversed words into map for O(1) lookups:
        for(int i=0;i<words.length;i++){
            hash.put(new StringBuilder(words[i]).reverse().toString(),i);
        }

        // 2) For each word, try every split into prefix|suffix
        for(int i=0;i<words.length;i++){
            String word=words[i];
            // j goes from 0..len inclusive to allow empty prefix or suffix
            for(int j=0;j<=word.length();j++){
                String prefix=word.substring(0,j);
                String suffix=word.substring(j);

                // CASE A: if suffix is palindrome, then we need a word equal to reverse(prefix)
                // so that word_i + that_word == prefix + suffix + reverse(prefix) is a palindrome
                if(isPalindrome(suffix)){
                    Integer idx=hash.get(prefix);// map stores reversedWord -> index
                    if(idx!=null && i!=idx){
                        list.add(Arrays.asList(i,idx));// words[i] + words[idx] is palindrome
                    }
                }

                // CASE B: if prefix is palindrome, we need a word equal to reverse(suffix)
                // so that that_word + word_i == reverse(suffix) + prefix + suffix is a palindrome
                // we skip prefix.empty() here to avoid duplicate pairs when j == 0
                if(!prefix.isEmpty() && isPalindrome(prefix)){
                    Integer idx=hash.get(suffix);
                    if(idx!=null && i!=idx){
                        list.add(Arrays.asList(idx,i));
                    }
                }
            }
        }
        return list;
    }

    private boolean isPalindrome(String s){
        int i=0, j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j))return false;
            i++;
            j--;
        }
        return true;
    }
}

class PalindromePairsMain {
    public static void main(String[] args) {
        String[] words={"bat","tab","cat"};
        System.out.println(new PalindromePairs().palindromePairs(words));
    }
}

/*
Example Walkthrough:
--------------------
words = ["abcd","dcba","lls","s","sssll"]

First build the map (reversed → index):

"dcba" -> 0 (reverse of "abcd")

"abcd" -> 1 (reverse of "dcba")

"sll" -> 2 (reverse of "lls")

"s" -> 3 (reverse of "s")

"llsss"-> 4 (reverse of "sssll")

Now check i=0 word = "abcd":

splits eventually check prefix="abcd", suffix="". suffix is palindrome (empty), hash.get(prefix) = hash.get("abcd") = 1 → add (0,1).

i=1 "dcba" → symmetrical → add (1,0).
i=2 "lls": at j=2, prefix="ll" (palindrome), suffix="s". hash.get(suffix) -> hash.get("s") = 3 → add (3,2) meaning words[3] + words[2] = "s" + "lls" = "slls" (palindrome).
i=4 "sssll": at some split you'll find (2,4) similarly.

Final pairs: [[0,1],[1,0],[3,2],[2,4]]


Complexity:
-----------
Let n = number of words, L = max length of a word.
Building the map: O(n * L) (reverse each word).
For each word, we try L+1 cuts. For each cut we:
create prefix and suffix (O(L) each in Java),
isPalindrome is O(L),
map lookup O(L) for keys (string hashing) — but amortized O(1) typical.
So worst-case time ≈ O(n * L^2) in Java (due to substring creation + palindrome checks).
Space: O(n * L) for storing reversed strings in the map, plus output.



Intuition (the core idea):
--------------------------
=> We want all pairs (i, j) such that words[i] + words[j] is a palindrome.
=> Think about what a palindrome looks like when you concatenate two words A + B:
=> The right side of the concatenation must mirror the left side.
=> That means some part of A (prefix or suffix) must be a palindrome by itself, and the other part must match the reverse of some whole word.
So for each word A we:
=> Split it into prefix + suffix at every possible cut.
=> If suffix is a palindrome and some other word equals reverse(prefix), then A + reverse(prefix) is a palindrome → add (i, idx).
=> If prefix is a palindrome and some other word equals reverse(suffix), then reverse(suffix) + A is a palindrome → add (idx, i).
To make the “some other word equals reverse(...)” check fast, we store a HashMap mapping reversedWord -> its index. That turns a potential O(n) search into O(1) lookup.

Algorithm:
----------
=> Build map where map.put(reverse(words[i]), i) for all i.
=> For each word A = words[i]:
=> For every cut position j from 0 to A.length() inclusive:
prefix = A.substring(0, j)
suffix = A.substring(j)

=> If isPalindrome(suffix) and map.containsKey(prefix) and map.get(prefix) != i → add (i, map.get(prefix)).
=> If prefix is non-empty and isPalindrome(prefix) and map.containsKey(suffix) and map.get(suffix) != i → add (map.get(suffix), i).

Return the list of pairs.

(We use j <= length so we also consider empty prefix or empty suffix.)
 */
