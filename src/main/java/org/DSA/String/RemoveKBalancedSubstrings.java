package org.DSA.String;

public class RemoveKBalancedSubstrings {
    public String removeSubstring(String s, int k) {
        String pattern="(".repeat(k)+")".repeat(k);
        StringBuilder res=new StringBuilder(s);
        int idx=0;
        while(idx<=res.length()-2*k){ // Only scan up to a point where pattern can exist
            if(res.substring(idx,idx+2*k).equals(pattern)){
                res.delete(idx,idx+2*k);
                idx=Math.max(0,idx-2*k); // Go back 2*k chars to recheck for new patterns
            }
            else idx++;
        }

        return res.toString();
    }
}


/*
💡 Intuitive takeaway:
----------------------
When you remove a "()" deep inside nested parentheses,
the removal causes the inner parentheses to become directly adjacent,
forming new "()" pairs nearby.

So:

Going back 2*k ensures you recheck that local region,
because that’s where new patterns can form.

Using max(0, …) prevents going before index 0.

So yes — ✅
your example ((((())))) with k=1 is exactly the scenario that proves the need for idx - 2*k.

Without that line, your loop would have stopped early, leaving ((())) (not empty).
 */


/*
Algorithm:
----------
=> Only need to scan until res.length() - 2*k because a k-balanced substring has length 2*k.
=> We don’t waste time scanning past the end where no match is possible.
=> If the substring at current index matches the k-balanced substring:
    -> Delete it.
    -> Then rewind a little to check for new patterns that may have formed.
=> After deletion, the string shrinks.
=> Deletion can cause previously non-adjacent parentheses to become adjacent, forming a new k-balanced substring.
=> Rewind Index: idx = Math.max(0, idx - 2*k);
🔑 Why rewind?
    -> After deletion, the characters just before the deleted substring might now form a new k-balanced substring.
    -> idx - 2*k ensures we recheck the left area where a new match could appear.
    -> Math.max(0, …) prevents idx from going negative.

Example:
--------
s = "((((()))))"
k = 1
pattern = "()"
Step 1: delete "()" at idx=4 -> res="(((())))", idx=2
Step 2: delete "()" at idx=2 -> res="(())", idx=0
Step 3: delete "()" at idx=0 -> res=""
Without rewinding, you’d skip new patterns that form after deletion.

=> If the current substring doesn’t match, just move forward one index: else idx++
=> This ensures we scan the entire string efficiently.

Key Takeaways:
--------------
=> idx - 2*k is not always used, but essential for nested patterns.
=> Without it, some newly-formed patterns after deletion would be skipped.
=> The algorithm is a greedy, local deletion approach:
    -> Scan left-to-right
    -> Delete pattern
    -> Rewind slightly to catch any new patterns
    -> Repeat
 */