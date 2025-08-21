package org.DSA.Recursion;

public class GenerateAllValidBracketCombos {

    public static void main(String[] args) {
        int m=1;
        int n=2;

        generate(0,0,0,0,m,n,"","");
    }

    private static void generate(int open1, int open2, int close1, int close2, int m, int n, String res, String track){
        if(open1==m && close1==m && open2==n && close2==n){
            System.out.println(res);
            return;
        }

        if(open1<m){
            generate(open1+1, open2, close1, close2, m,n,res+"(",track+"(");
        }
        if(close1<open1 && !track.isEmpty() && track.charAt(track.length()-1)=='('){
            generate(open1, open2, close1+1, close2, m,n,res+")", track.substring(0,track.length()-1));
        }
        if(open2<n){
            generate(open1, open2+1, close1, close2, m,n,res+"{",track+"{");
        }
        if(close2<open2 && !track.isEmpty() && track.charAt(track.length()-1)=='{'){
            generate(open1, open2, close1, close2+1, m,n,res+"}",track.substring(0,track.length()-1));
        }
    }
}

/*
Approach in Detail:
-------------------
The goal is to generate all well-formed combinations of parentheses ( ) and curly braces { } with exactly m pairs of parentheses and n pairs of curly braces. A well-formed sequence must:

=> Have all brackets properly closed in the correct order.
=> Never close a bracket before its corresponding open bracket.
=> Ensure that closing brackets match the most recently opened bracket of the same type.

Key Insight:
The problem is not just about counting open and close brackets. The order in which brackets are opened and closed matters. For example:

Valid: "(){}{}", "{()}", "({})"

Invalid: "(})" (closing } before )), "{)(}" (closing ) before }), etc.

To ensure correctness, we must track the sequence of open brackets that have not yet been closed. This is typically done using a stack:

1) When an open bracket is added, add it to the track.
2) When a close bracket is added, it must match the top of the track. Then pop the track.

How the Code Works:
Parameters:
1) open1, close1: Count of open and close parentheses used.
2) open2, close2: Count of open and close curly braces used.
3) m, n: Total pairs required.
4) list: Stores valid sequences.
5) res: The current string being built.
6) track: A string that simulates a stack to track unmatched open brackets.

Base Case:
When all brackets are used (open1 == m && close1 == m && open2 == n && close2 == n), add res to list.

Recursive Cases:
Add Open Parenthesis (:
If we haven’t used all m open parentheses (open1 < m), add ( to res and push ( to stack.

Add Close Parenthesis ):
If we haven’t closed all open parentheses (close1 < open1) and the top of the stack is ( (meaning the last open bracket is a parenthesis), then add ) to res and pop the stack.

Add Open Curly Brace {:
If we haven’t used all n open curly braces (open2 < n), add { to res and push { to stack.

Add Close Curly Brace }:
If we haven’t closed all open curly braces (close2 < open2) and the top of the stack is { (meaning the last open bracket is a curly brace), then add } to res and pop the stack.

Significance of Tracking the Stack (stack Parameter)
The stack parameter is crucial because it:
Enforces Proper Nesting: It ensures that a closing bracket always matches the most recently opened bracket. For example:
If the stack is "({" (meaning we opened ( then {), we can only close with } (to match the {) first. Closing with ) would be invalid because the last open bracket is {, not (.
This prevents sequences like "(})" which are invalid.
Maintains the Order of Operations: The stack remembers the exact order in which brackets were opened. This allows us to validate closing brackets in the reverse order.
Avoids Invalid States: Without the stack, we might generate sequences that have the correct counts but wrong order (e.g., ")(" or "}{"). The stack acts as a guardian to ensure every closing bracket is allowed.
Efficiency: Although we are using a string for the stack, the maximum depth of the stack is m + n (which is small for typical inputs). This is efficient compared to generating all sequences and then validating them.


Example Walkthrough for m=1, n=2:
Let’s see how the code generates "({})":

Start: res = "", stack = ""

Add (: res = "(", stack = "("

Add {: res = "({", stack = "({"

Add }: Check stack top is { → allowed. res = "({}", stack = "("

Add ): Check stack top is ( → allowed. res = "({})", stack = ""

Base case reached: add to list.

Without the stack, we might have allowed adding ) after ({ (which would be invalid), but the stack prevents it.

 */