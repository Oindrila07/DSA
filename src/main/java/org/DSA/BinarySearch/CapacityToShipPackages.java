package org.DSA.BinarySearch;

public class CapacityToShipPackages {
    public int shipWithinDays(int[] weights, int days) {
        int low = weights[0], high = 0, res = -1;

        for (int i = 0; i < weights.length; i++) {
            low = Math.max(low, weights[i]);
            high += weights[i];
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (check(weights, mid, days)) {
                high = mid - 1;
                res = mid;
            } else
                low = mid + 1;
        }

        return res;
    }

    private boolean check(int[] weights, int weight, int days) {
        int total = 0, count = 1;

        for (int i = 0; i < weights.length; i++) {
            total += weights[i];

            if (total > weight) {
                count++;
                total = weights[i];
            }
        }

        return count <= days;
    }
}

class CapacityMain{
    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;

        System.out.println(new CapacityToShipPackages().shipWithinDays(weights, days));
    }
}

/*
Approach:
---------
=> Minimum weight which I can assign in a day = the max (weights)
=> Maximum weight that I can assign is = sum (weights)
Now, perform BS!
 */
