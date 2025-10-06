package org.DSA.HashMap;

public class CountTripletsWithEqualXORArrays {
    public int countTriplets(int[] arr) {
        int count=0;
        for(int i=0;i<arr.length;i++){
            int currXor=arr[i];
            for(int k=i+1;k<arr.length;k++){
                currXor^=arr[k];
                if(currXor==0)count+=(k-i);
            }
        }
        return count;
    }
}

/*
Intuition 🤔
`Given`--> One array with

1 <= arr[i] <= 10^8 Value can not 0

1 <= arr.length <= 300
Que description -->

we have to find a subArray length >= 2

How do we know >= 2 ?

Ans -> we have to find i, j, k 3 index

which should be in order

1. 0 <= i < j -> means i can be 0 but not equal to j

2. i < j <= k -> j can be equal to k

3. j <= k < arr.length -> k can be equal to length and j
Final i j k can traverse upto

0 <= i < arr.length - 1

i + 1 <= j < arr.length

j <= k < arr.length

We will count a and b as given in que as -->

A will be XOR upto j - 1  for Ith travese

    a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]

B will be XOR upto k  for Jth traverse

    b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
And if a == b we'll count one triplet

Basically it's not a triplet, it will be a subArray of len >= 2. So we will be ultimately counting subarrays of length >=2.


XOR Properties 😍
Let's Discuss some properties of XOR first

1. If we take xor of same value X ^ X it will be 0 from table

`Ex.` x = 11011
      x = 11011

    X ^ X == 00000


2. If XOR of some values are 0 then thier every part is complement

`Ex.`  if X1 ^ X2 ^ X3 ^ X4 = 0

    Then  X1 = X2 ^ X3 ^ X4

    Then  X1 ^ X2 = X3 ^ X4

    Then  X1 ^ X2 ^ X3 = X4
How do we prove it ?

`Ex.`  if X1 ^ X2 ^ X3 ^ X4 = 0

    take xor both side with X1

          X1 ^ X1 ^ X2 ^ X3 ^ X4 = X1 ^ 0

    (X1 ^ X1 = 0) && (X1 ^ 0 = X1) hence

     -> X2 ^ X3 ^ X4 = X1
Approach O(N^2)

Instead of looking for half a portion A and B

We will make subarray stating with 0 index

and count all it's XOR

  `Ex.` [2, 3, 1, 6, 7]

      [2]             XOR = 2

      [2, 3]          XOR = 1

      [2, 3, 1]       XOR = 0  🚀

      [2, 3, 1, 6]    XOR = 6

      [2, 3, 1, 6, 7] XOR = 1
And then starting from next index

  `Ex.` [2, 3, 1, 6, 7]

      [3]          XOR = 3

      [3, 1]       XOR = 2

      [3, 1, 6]    XOR = 4

      [3, 1, 6, 7] XOR = 3
And then starting from next index and upto end

When ever we got the 🚀 curXOr = 0 We will count Triplets

`Ex.`

    we got a solution at [2, 3, 1]

    Here i will be at 2 (0)

    And k will be at 1 (2)

    For j it can be at 3(1) or 1(2) because j can be <= k

    Hence we'll count every possible solution

    Triplets += k - i


Understand with code 🥰
   There will be 6 steps

Step 1 -> Make variables Triplets

Step 2 -> Apply for loop from 0 to len(s) - 1  FOR I

    We can go upto len - 1 because i < j <= arr.length

Step 3 -> Make curXor and assign with arr[i] current index value

Step 4 -> Apply for loop from  i + 1 to arr.length  FOR K

    We can go upto (length) because i < K <= arr.length

Step 5 -> Take XOR and add to our curXor

Step 6 -> IF curXor get 0 somewhere add K - I To Triplets

Step 7 -> return Triplets
 */


/*
💡 Why count += (k - i) is correct

If the XOR from arr[i] to arr[k] is 0,
that means for every j such that i < j ≤ k,
the subarray arr[i] … arr[j-1] has the same XOR as arr[j] … arr[k].

In other words: arr[i]⊕arr[i+1]⊕...⊕arr[k]=0
implies that for all j between i+1 and k, arr[i]⊕...⊕arr[j−1]=arr[j]⊕...⊕arr[k].
✅ Each of those j values gives a distinct valid triplet (i, j, k).
So, for a given (i, k) where the XOR is 0,
there are (k - i) possible j values:->  j=i+1,i+2,...,k
Hence, you must do: count += (k - i);

❌ Why count++ would be wrong

If you just did count++, you’d only count one triplet for each (i, k) pair where the XOR is 0.

But as shown above, there are actually multiple valid triplets (one for every possible j) between i+1 and k.

So count++ undercounts — it ignores all those other valid middle indices j.

Example: arr = [2, 3, 1, 6, 7]
Let’s say at some point you find that the XOR from i=1 to k=3 is 0. Then: arr[1]^arr[2]^arr[3] = 0
Here, i = 1, k = 3, so (k - i) = 2.

Possible j values:

j = 2

j = 3

So there are 2 valid triplets:
(1, 2, 3) and (1, 3, 3).
→ Thus count += 2 (not just 1).
 */