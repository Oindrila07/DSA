package org.DSA.BinarySearch;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = piles[0], res = -1;

        for (int i = 0; i < piles.length; i++) {
            low = Math.min(low, piles[i]);
            high = Math.max(high, piles[i]);
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (check(piles, mid, h)) {
                high = mid - 1;
                res = mid;
            } else
                low = mid + 1;
        }

        return res;
    }

    private boolean check(int[] piles, int num, int hours) {
        long sum = 0;

        for (int i = 0; i < piles.length; i++) {
            long x = (long) (Math.ceil((double) piles[i] / (double) num));
            sum += x;
        }

        return sum <= hours;
    }
}

class KokoMain{
    public static void main(String[] args) {
        int[] piles={30,11,23,4,20};
        int hours=5;

        System.out.println(new KokoEatingBananas().minEatingSpeed(piles,hours));
    }
}

/*
Approach:
---------
=> Koko can eat minimum of 1 banana/hour or max of max(piles) bananas/hour.
=> Perform binary search to find the least bananas that she can eat in given 'h' hours.
=> The 'check' function calculates that how much time it takes for koko to finish ith pile
   -> the sum of all the times required to finish the bananas gives us the total time required to finish all the bananas
   -> if the hours are more, Koko needs to increase the rate of eating bananas -> low = mid + 1
   -> else she can decrease ti find the least number for her to finish all the bananas in the given timeframe. -> high = mid - 1
 */
