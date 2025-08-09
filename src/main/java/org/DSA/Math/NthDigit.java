package org.DSA.Math;

public class NthDigit {
    public static void main(String[] args) {
        System.out.println(findNthDigit(123));
    }
    public static int findNthDigit(int n) {
        long temp=n, count=9, start=1, len=1;

        while(temp>len*count){
            temp-=(len*count);
            start*=10;
            len++;
            count*=10;
        }

        //find the actual number where the nth digit lies
        long num=start+(temp-1)/len;//since numbers are 0-based we are doing temp-1

        String s=String.valueOf(num);
        char digit=s.charAt((int)((temp-1)%len));

        return digit-'0';
    }
}

/*
Intuition:
----------
🔍 Problem Statement
Find the n-th digit in the sequence formed by concatenating the positive integers:

123456789101112131415...

Given n, return the digit at the n-th position in the infinite digit sequence.

🧠 Key Insight
The sequence:

Copy
Edit
123456789101112131415...
is made up of groups of numbers with increasing digit lengths:

Digit Length	Number Range	Count of Numbers	Total Digits
1	1 to 9	9	9 * 1 = 9
2	10 to 99	90	90 * 2 = 180
3	100 to 999	900	900 * 3 = 2700
4	1000 to 9999	9000	9000 * 4 = 36000
...	...	...	...

✅ Overall Plan
Step 1: Figure out the digit length group where the n-th digit is located.
Start subtracting the total digits of each group from n until it falls within a group.

Step 2: Find the exact number within that digit-length group.
Step 3: Find the digit in that number corresponding to the position.



🔍 Line-by-line Explanation:
----------------------------

public int findNthDigit(int n) {
This is the function definition. You're given an integer n, and you need to return the digit at the nth position in the infinite sequence:

1234567891011121314...

    int digitLength = 1;
This keeps track of how many digits each number in the current group has.

Starts with 1 (because the first 9 numbers — 1 to 9 — are all 1-digit).

    long count = 9;
This is the count of numbers that have digitLength digits:

For 1-digit numbers: 9 (1–9)

For 2-digit numbers: 90 (10–99)

For 3-digit numbers: 900 (100–999)

and so on…

We use long to avoid integer overflow when n is very large.

    long start = 1;
This is the starting number for the current digit group:

1-digit numbers: start = 1

2-digit numbers: start = 10

3-digit numbers: start = 100

and so on…

    while (n > digitLength * count) {
We’re trying to find the digit group (1-digit, 2-digit, 3-digit...) where the nth digit lies.

The total number of digits in a group is digitLength * count.
If n is greater than that, the nth digit is not in this group, so we subtract and move to the next group.

        n -= digitLength * count;
We subtract the number of digits from the group we're skipping. For example:

If n = 15 and the current group (1-digit numbers) has 9 digits, we do n = 15 - 9 = 6 and move on.

        digitLength++;
Move to the next digit-length group:

From 1-digit → 2-digit

From 2-digit → 3-digit, and so on...

        count *= 10;
Update how many numbers are in the next group:

9 → 90 → 900 → ...

   start *= 10;
Update the starting number of the next group:

1 → 10 → 100 → ...

    }
When we exit the loop, we've found the correct digit-length group where the nth digit lies.

    long number = start + (n - 1) / digitLength;
Now, calculate the exact number that contains the nth digit.

Why (n - 1) / digitLength?

We subtract 1 because arrays and positions are 0-indexed.

Dividing by digitLength gives us how many full numbers into the group we need to go.

Example:
If digitLength = 2, start = 10, and n = 6, then:

number = 10 + (6 - 1)/2 = 10 + 2 = 12
So the 6th digit lies in number 12.

    String s = Long.toString(number);
Convert the number to a string so we can easily extract any digit.

    return s.charAt((n - 1) % digitLength) - '0';
Extract the actual digit from the string.

(n - 1) % digitLength gives the position within the number.

Continuing our example:

number = 12

We want the (6 - 1) % 2 = 1-th digit → s.charAt(1) = '2'

'2' - '0' = 2 → final answer

✅ Final Output
This returns the correct digit at position n.

🧠 Example Recap: n = 15
Let’s run through the code quickly:

Initial: digitLength = 1, count = 9, start = 1

n > 9 → yes, subtract: n = 15 - 9 = 6

digitLength = 2, count = 90, start = 10

Now: (6 - 1) / 2 = 2 → number = 10 + 2 = 12

Index: (6 - 1) % 2 = 1 → second digit of "12" → '2'

Return 2
 */