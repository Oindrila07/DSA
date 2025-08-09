package org.DSA.String;

import java.util.ArrayList;
import java.util.List;

public class countOfValidParenthesis {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(4));
    }

    private static int generateParenthesis(int n){
        List<String> list=new ArrayList<>();

        if(n%2!=0)return 0;

        backtrack(list, "", 0, 0, n/2);

        System.out.println(list.toString());

        return list.size();
    }

    private static void backtrack(List<String> list, String result, int open, int close, int max){
        if(open==max && close==max){
            list.add(result);
            return;
        }

        if(open<max){
            backtrack(list,result+"(",open+1,close,max);
        }

        if(close<open) {//it ensures validity
            backtrack(list, result+")", open, close + 1, max);
        }
    }
}

/*Intuition:
------------
Condition	Meaning	Valid?	Explanation
close < open	Only add ) if unmatched ( exist	✅	Ensures correctness of parentheses
close < max	Only checks number of ) used so far	❌	Doesn’t ensure valid pairing with (

💡 Core Idea
We will use backtracking (a fancy word for trying all possibilities and discarding invalid ones) to build the string step by step:

Add ( when we have some left to add.

Add ) only if we already have unmatched ( to pair it with.

Explanation 💡:
---------------
generateParenthesis(int n)
This is the main method.

It starts the process by calling backtrack(...) with:

An empty string (current) — our partially built parentheses.

open = 0 → number of ( added so far.

close = 0 → number of ) added so far.

max = n → maximum number of opening (and closing) parentheses allowed.

backtrack(...)
This is where the magic happens.
if(open==max && close==max){
      list.add(result);
       return;
}
We stop recursion when the string is complete.

Add an opening bracket:
java
Copy
Edit
if (open < max) {
    backtrack(result, current + "(", open + 1, close, max);
}
If we still have ( left to use, add one and continue.

This grows the string.

Add a closing bracket:
java
Copy
Edit
if (close < open) {
    backtrack(result, current + ")", open, close + 1, max);
}
Only add a ) if it doesn’t exceed the number of unmatched (.

This keeps the string valid.

📌 Why this works:

This ensures we never generate invalid strings like "(()))".

🧪 Example Dry Run (n = 2)
Goal: Generate all valid strings of 2 open and 2 close parentheses.

The tree of decisions:

arduino
Copy
Edit
""
├── "(" → open=1
│   ├── "((" → open=2
│   │   ├── "(()" → close=1
│   │   │   └── "(())" → close=2 ✅
│   └── "()" → close=1
│       └── "()(" → open=2
│           └── "()()" → close=2 ✅
So, the answer is:

css
Copy
Edit
["(())", "()()"]
 */

/*Time Complexity: O(2^n) or more precisely O(Cn)
------------------
In the valid parentheses problem, we only generate valid strings, which are counted by the Catalan number (Cₙ), and:

Cₙ is much smaller than 2^(2n)

For example:

n	Total combinations (2^(2n))	Valid combinations (Catalan Cₙ)
1	    4	                            1
2	    16	                            2
3	    64	                            5
4	    256	                            14
5	    1024	                        42

Space Complexity:
-----------------
Call stack (due to recursion):

Max depth of recursion = 2n (since we add one char at a time).

At any point, recursive function holds:

current string

open and close counts

So, recursion uses O(2n) space per path.
 */