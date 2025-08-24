package org.DSA.BinarySearch;

public class MBouquets {
    public int minDays(int[] bloomDay, int m, int k) {
        if (m * k > bloomDay.length)
            return -1;

        int low = bloomDay[0], high = bloomDay[0], res = -1;

        for (int i = 1; i < bloomDay.length; i++) {
            low = Math.min(bloomDay[i], low);
            high = Math.max(bloomDay[i], high);
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (check(bloomDay, mid, m, k)) {
                res = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }

        return res;
    }

    private boolean check(int[] bloomDay, int day, int m, int k) {
        int count = 0, flowers = 0;

        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] > day) {
                flowers = 0;
            } else
                flowers++;

            if (flowers == k) {
                count++;
                flowers = 0;
            }

            if (count == m)
                return true;
        }

        return count == m;
    }
}

class MBouquetsMain{
    public static void main(String[] args) {
        int[] bloomDay = {7,7,7,7,12,7,7};
        int m = 2, k = 3;

        System.out.println(new MBouquets().minDays(bloomDay, m, k));
    }
}

/*
Approach:
---------
=> Minimum days to pluck a flower for bouquet is = min (bouquet)
=> Maximum days to pluck a flower for a bouquet is = max (bouquet)
Now perform BS!
 */
