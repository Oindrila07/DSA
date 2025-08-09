package org.DSA.Recursion;

public class generatePowerSetNonLexic {
    public static void main(String[] args) {
        String s="abc";
        generatePowerSet(s,0,3,"");
        System.out.println();
    }
    static void generatePowerSet(String s, int i, int n, String res){
        if(i==n){
            System.out.print(res+" ");
            return;
        }

        generatePowerSet(s,i+1,n,res+s.charAt(i));
        generatePowerSet(s,i+1,n,res);//backtracking
    }
}

/*
Why this works
At each index, the recursion explores both possibilities.

The recursion tree for "abc" looks like:

arduino
Copy
Edit
             ""
         /       \
       a           ""
     /   \        /   \
   ab     a     b     ""
  /  \   / \   / \   / \
abc ac  a  "" bc b  c  ""
This covers all 2^n possible subsets.
 */
