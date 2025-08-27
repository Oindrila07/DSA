package org.DSA.TwoPointers;

import java.util.Arrays;
import java.util.List;

public class GameOfTwoStacksUsingPrefixSum {
    public static int twoStacks(int maxSum, List<Integer> a, List<Integer> b) {
        int[] prefixA = new int[a.size() + 1];
        int[] prefixB = new int[b.size() + 1];

        // Build prefix sums
        for (int i = 0; i < a.size(); i++) {
            prefixA[i + 1] = prefixA[i] + a.get(i);
        }
        for (int i = 0; i < b.size(); i++) {
            prefixB[i + 1] = prefixB[i] + b.get(i);
        }

        // Start by taking as many from B as possible
        int j = 0;
        while (j <= b.size() && prefixB[j] <= maxSum) {
            j++;
        }
        j--; // step back to last valid

        int maxCount = j;

        // Now try adding elements from A and adjust B accordingly
        for (int i = 1; i <= a.size(); i++) {
            if (prefixA[i] > maxSum) break;

            while (j >= 0 && prefixA[i] + prefixB[j] > maxSum) {
                j--;
            }

            if (j >= 0) {
                maxCount = Math.max(maxCount, i + j);
            }
        }

        return maxCount;
    }

    public static void main(String[] args) {
        List<Integer> a=Arrays.asList(4,2,4,6,1);
        List<Integer> b= Arrays.asList(2,1,8,5);
        System.out.println(twoStacks(10,a,b));
    }
}

/*
Intuition:
----------
1. Why Prefix Sums?

The problem is about repeatedly asking:

👉 “If I take the first i from stack A and the first j from stack B, what’s the total sum?”

Without prefix sums, every time you’d have to loop and add those i+j numbers — too slow.
With prefix sums, it’s just: prefixA[i] + prefixB[j]
O(1) check. That’s why prefix sums pop up naturally:
they’re the fastest way to ask “what’s the sum of the first k elements?”


2. Why Two Pointers?

Now suppose you fixed i (elements from A).
You want the maximum j (elements from B) such that: prefixA[i] + prefixB[j] <= maxSum

Notice: if prefixA[i] + prefixB[j] is too big, then any bigger j will also be too big (because prefixB grows).
So once you know j is too big, you just move it left (decrease j).

👉 That’s the classic “two-pointer” idea:

One pointer moves forward on A (i increases).

The other pointer only moves backward on B (j decreases).
Together, they cover the whole search space in linear time.



3. The Intuition (Big Picture)

Start by being greedy with B: “take as many from B as possible.”

Then, while slowly adding items from A, adjust B downward to keep under the limit.

At every step, check the total count = i + j.

That’s why the algorithm looks like:

Push j as far as possible initially.

Walk i forward, shrink j when needed.

Track maximum i+j.


4. Example (maxSum = 10)

A = [4, 2, 4, 6, 1]
B = [2, 1, 8, 5]

PrefixA = [0, 4, 6, 10, 16, 17]

PrefixB = [0, 2, 3, 11, 16]

Start with j = 2 (because prefixB[2] = 3 fits, prefixB[3] = 11 doesn’t).
Now:

i=0 → total = 0+3=3 (count=2)

i=1 → prefixA[1]+prefixB[2] = 4+3=7 (count=3)

i=2 → prefixA[2]+prefixB[2] = 6+3=9 (count=4) ✅

i=3 → prefixA[3]+prefixB[2] = 10+3=13 ❌ too much → move j=1 → 10+2=12 ❌ → j=0 → 10+0=10 ✅ (count=3)

Max count seen = 4.
 */
