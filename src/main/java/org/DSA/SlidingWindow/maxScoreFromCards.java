package org.DSA.SlidingWindow;

public class maxScoreFromCards {
    public static int maxScore(int[] cardPoints, int k) {
        int totalsum=0, minSum=0, n=cardPoints.length, sum=0;

        for(int i:cardPoints){
            totalsum+=i;
        }

        for(int i=0;i<n-k;i++){
            sum+=cardPoints[i];
        }

        minSum=sum;
        for(int i=n-k;i<n;i++){
            sum+=(cardPoints[i]-cardPoints[i-(n-k)]);
            minSum=Math.min(minSum,sum);
        }

        return totalsum-minSum;
    }

    public static void main(String[] args) {
        int[] nums={9,7,7,9,7,7,9};
        int k=7;
        System.out.println(maxScore(nums,k));
    }

    /*Another way to solve*/
    public int maxScorePart2(int[] cardPoints, int k) {
        int maxSum=0, sum1=0, sum2=0, n=cardPoints.length;

        //sum of first k and last k elements:
        for(int i=0;i<k;i++){
            sum1+=cardPoints[i];
            sum2+=cardPoints[n-i-1];
            maxSum=Math.max(sum1,sum2);
        }

        int i=k-1, j=n-1, sum=sum1;

        while(i>=0){
            sum+=(cardPoints[j]-cardPoints[i]);
            i--;
            j--;
            maxSum=Math.max(maxSum,sum);
        }

        return maxSum;
    }
}

/*
Intuition for first:
--------------------
=> Picking k cards means you’re leaving behind n - k cards in the middle.
=> Instead of maximizing the score of picked cards, we can minimize the score of the cards we leave behind.
=> Total points you can get = Total sum of all cards − Minimum sum of n - k consecutive cards.

This turns a “two-ends” problem into a sliding window problem.


Steps:
We fix a window of size n - k (cards left in the middle).
Find the minimum sum of such a window.
Subtract it from the total sum to get the maximum score.



Intuition for second:
---------------------
Find the total sum for the first and last k cards.
Then try out all other options, for eg: first k-1 cards and last 1 card OR first k-2 cards and last 2 cards and so on
Keep track of the max score obtained from all the combinations and return in the end.
 */
