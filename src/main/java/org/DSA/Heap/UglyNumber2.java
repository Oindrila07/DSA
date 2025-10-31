package org.DSA.Heap;

import java.util.*;

public class UglyNumber2 {
    //Brute Force: TC = O(n^2), SC = O(n)
    public int nthUglyNumberBruteForce(int n) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        int num=1, idx=0;
        while(idx<n){
            if(check(num)){
                pq.offer(num);
                idx++;
            }
            num++;
        }
        return pq.peek();
    }

    private boolean check(int num){
        while(num%2==0){
            num/=2;
        }
        while(num%3==0){
            num/=3;
        }
        while(num%5==0){
            num/=5;
        }
        return num==1;
    }


    //Optimal:
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq=new PriorityQueue<>();
        HashSet<Long> hash=new HashSet<>();
        pq.offer(1L);
        hash.add(1L);
        int[] factors={2,3,5};
        long num=1, idx=0;
        while(idx<n){
            num=pq.poll();
            for(int factor:factors){
                if(!hash.contains(num*factor)){
                    pq.offer(num*factor);
                    hash.add(num*factor);
                }
            }
            idx++;
        }
        return (int)num;
    }
}


/*
Approach and Intuition:
----------------------
The problem is to find the (n)th ugly number.
An ugly number is defined as a number whose only prime factors are 2, 3, or 5.
The sequence of ugly numbers starts with 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, and so on.

Steps:
=> Initialization:
------------------
Use a PriorityQueue (min-heap) to efficiently retrieve the smallest ugly number.
Use a HashSet to avoid inserting duplicate numbers into the priority queue.

=> Generating Ugly Numbers:
---------------------------
Start with the smallest ugly number, which is 1, and insert it into the priority queue.
Repeatedly extract the smallest element from the priority queue and generate new ugly numbers by multiplying it with the factors 2, 3, and 5.
If the product is not already in the set, insert it into both the set and the priority queue.
Continue this process until the (n)th ugly number is extracted from the priority queue.
Returning the Result:

The loop will run exactly (n) times, and after the (n)th iteration, the smallest element in the priority queue is the (n)th ugly number.


Time Complexity:
----------------
Inserting and removing elements from the priority queue (min-heap) takes (O(log k)) time, where (k) is the number of elements in the heap. In this case, the heap size grows as more ugly numbers are generated.
Each iteration involves generating three new numbers (by multiplying with 2, 3, and 5), checking if they exist in the set, and then inserting them if not already present.
Thus, the overall time complexity is approximately (O(n*log k)), where (k) is bounded by the size of the heap. In practice, (k) is proportional to (n).

Space Complexity:
-----------------
The space complexity is (O(n)) for storing the (n) ugly numbers in the priority queue and the set. Each ugly number is processed only once, and there are at most (3n) operations involving insertion into the set and priority queue.
 */