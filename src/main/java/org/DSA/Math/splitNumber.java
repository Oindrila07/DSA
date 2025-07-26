package org.DSA.Math;

import java.util.Arrays;

public class splitNumber {
    public int splitWithMinimumSum(int num) {
        // write your code here
        char[] ch=Integer.toString(num).toCharArray();
        Arrays.sort(ch);

        String s1="", s2="";

        for(int i=0;i<ch.length;i++){
            if(i%2==0)s1+=ch[i];
            else s2+=ch[i];
        }

        int num1=Integer.parseInt(s1);
        int num2=Integer.parseInt(s2);

        return num1+num2;
    }

    public static void main(String[] args) {

    }
}

/*Intuition:
✅ Approach (Greedy + Sorting digits):
You can think of this problem as:

"How can we distribute the digits of the number into two numbers, such that their sum is minimized?"

To achieve this:

Extract and sort the digits of the number.

Greedily distribute digits between the two numbers to keep both as small as possible:

Alternate putting digits into two numbers (like num1 and num2).

First smallest digit to num1, second to num2, third to num1, fourth to num2, and so on...

This ensures both numbers grow from smaller digits (like adding 1s and 10s before 1000s).

🔢 Example:
Input: 4325
Digits sorted: [2, 3, 4, 5]
Distribute:

num1 gets 2, then 4 → 24

num2 gets 3, then 5 → 35

Sum = 24 + 35 = 59
 */