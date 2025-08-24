package org.DSA.BinarySearch;

public class HIndex2 {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int low = 0, high = n - 1, index = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (mid < n && citations[mid] >= (n - mid)) {
                high = mid - 1;
                index = mid;
            } else
                low = mid + 1;
        }

        return index == -1 ? 0 : n - index;
    }
}

class HIndexMain2{
    public static void main(String[] args) {
        int[] citations = {0,1,3,5,6};

        System.out.println(new HIndex2().hIndex(citations));
    }
}

/*
Intuition:
----------
citations[mid] >= (n - mid) -> is the heart of the binary search for H-Index II.

🔹 Step 1: What does H-Index mean again?
Definition:
A researcher has an h-index h if at least h papers have at least h citations each.
So the challenge is to find the maximum such h.

🔹 Step 2: What does the array give us?
We’re given a sorted array of citations, say: citations = [0, 1, 3, 5, 6] and n = 5
=> Sorted in ascending order.
=> At each index i, we know:
=> citations[i]: how many citations this paper has.
=> (n - i): how many papers (from i to the end) have at least citations[i] citations.

Example:
At i=2 → citations[2] = 3, and (n - 2) = 3 papers have at least 3 citations (they are [3,5,6]).

Step 3: Rewriting H-index condition:
We want h such that: there are at least h papers with ≥ h citations.

Now look at citations[i].
If citations[i] >= (n - i), then:
The number of papers with citations ≥ citations[i] = (n - i).
And each of them has at least citations[i].
So automatically, there are (n - i) papers with at least (n - i) citations.
Which means h-index could be (n - i).
💡 That’s why the check is: if (citations[mid] >= n - mid)


🔹 Step 4: Example Walkthrough (citations = [0,1,3,5,6]):

n=5

We binary search:

Check mid=2

citations[2] = 3

n-mid = 5-2 = 3

Condition: 3 >= 3 ✅ valid

Candidate h-index = 3

Try smaller index to see if bigger h possible.

Check mid=0

citations[0] = 0

n-mid = 5-0 = 5

Condition: 0 >= 5 ❌ not valid

Too small, move right.

Check mid=1

citations[1] = 1

n-mid = 4

Condition: 1 >= 4 ❌ not valid

Still too small, move right.

Final smallest valid index = 2 → h = n - 2 = 3 ✅.

🔹 Step 5: Edge Cases
Case 1: All zeros
citations = [0,0,0,0], n=4


At any index, citations[i] < (n - i).

So condition never true → return 0.

Case 2: Large citations
citations = [10,15,20], n=3


mid=1 → citations[1]=15, n-mid=2 → 15≥2 ✅ valid

mid=0 → citations[0]=10, n-mid=3 → 10≥3 ✅ valid

Smallest index=0 → h=3.

Meaning: 3 papers with ≥ 3 citations. Correct.

Case 3: Exactly matching
citations = [0,1,4,5,6], n=5


At i=2: citations[2]=4, n-i=3 → 4 ≥ 3 ✅ valid

At i=3: citations[3]=5, n-i=2 → 5 ≥ 2 ✅ valid

At i=4: citations[4]=6, n-i=1 → 6 ≥ 1 ✅ valid

Smallest valid index=2 → h=5-2=3.

That’s the maximum h-index.

🔹 Step 6: Why minimize index?
=> Because the h-index is n - index.
=> The smaller the index, the larger the candidate h-index.

So binary search finds the first position where the condition holds → ensures maximum h-index.
 */