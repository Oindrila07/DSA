package org.DSA.BinarySearch;

public class HIndex {
    public int hIndex(int[] citations) {
        int low = 0, high = citations.length, res = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (ifPossible(citations, mid)) {
                low = mid + 1;
                res = mid;
            } else
                high = mid - 1;
        }

        return res;
    }

    private boolean ifPossible(int[] citations, int mid) {
        int count = 0;

        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= mid)
                count++;
        }

        return count >= mid;
    }
}

class HIndexMain{
    public static void main(String[] args) {
        int[] citations = {3,0,6,1,5};

        System.out.println(new HIndex().hIndex(citations));
    }
}

/*
Approach:
--------
*Note: We are supposed to return count of papers, therefore in an array there can be from 0 to n papers present.
now, we need to determine, how many of them satisfy the H-Index property

=> The minimum number of candidates for h index are = 0
=> The maximum number of candidates for h index are = n
 */
