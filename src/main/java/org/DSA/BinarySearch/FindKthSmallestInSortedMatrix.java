package org.DSA.BinarySearch;

public class FindKthSmallestInSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length;
        int low=matrix[0][0], high=matrix[n-1][n-1];
        int res=-1;

        while(low<=high){
            int mid=low+(high-low)/2;
            if(countLessOrEqual(matrix,mid,n)>=k){
                res=mid;
                high=mid-1;
            }
            else low=mid+1;
        }

        return res;
    }

    private int countLessOrEqual(int[][] matrix, int mid, int n){
        int row=0, col=n-1, count=0;

        while(row<n && col>=0){
            if(matrix[row][col]<=mid){
                count+=(col+1);
                row++;
            }
            else col--;
        }

        return count;
    }
}

/*
Binary Search:
--------------
Idea:
We binary search to find the smallest ans in range [minOfMatrix..maxOfMatrix] such that countLessOrEqual(ans) >= k, where countLessOrEqual(x) is the number of elements less than or equal to x.

Why ans must be as smallest as possible?
=> for matrix  [[1,3,7],
                [5,10,12],
                [6,10,15]]

lets say, k=5, answer should be 7;
Initially mid=(1+15)/2=8;
countLessThanOrequals(mid) returns 5 which is same as k.
If we return 8 as the answer, it would be incorrect. Therefore, we need to return the smallest value which satisfies countLessThanOrequals(mid) >= k condition


Why countLessOrEqual(ans) >= k but not countLessOrEqual(ans) == k?
=> For same matrix as above, lets say k=6, answer should be 10.
if we do countLessthanOrequals(mid)==k



Algorithm:
----------
=> Start with left = minOfMatrix = matrix[0][0] and right = maxOfMatrix = matrix[n-1][n-1].
=> Find the mid of the left and the right. This middle number is NOT necessarily an element in the matrix.
=> If countLessOrEqual(mid) >= k, we keep current ans = mid and try to find smaller value by searching in the left side. Otherwise, we search in the right side.
=> Since ans is the smallest value which countLessOrEqual(ans) >= k, so it's the k th smallest element in the matrix.



How to count number of elements less or equal to x efficiently?

=> Since our matrix is sorted in ascending order by rows and columns.
=> We use two pointers, one points to the rightmost column c = n-1, and one points to the lowest row r = 0.
=> If matrix[r][c] <= x then the number of elements in row r less or equal to x is (c+1) (Because row[r] is sorted in ascending order, so if matrix[r][c] <= x then matrix[r][c-1] is also <= x). Then we go to next row to continue counting.
=> Else if matrix[r][c] > x, we decrease column c until matrix[r][c] <= x (Because column is sorted in ascending order, so if matrix[r][c] > x then matrix[r+1][c] is also > x).



Time complexity for counting: O(M+N).

 */