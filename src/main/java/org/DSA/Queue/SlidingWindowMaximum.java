package org.DSA.Queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue=new ArrayDeque<>();//Declare a deque for storing indexes of the max values for each window of size k
        int[] res=new int[nums.length-k+1];
        int count=0;

        //Build the first window:
        // we remove smaller elements from the last as we are trying to maintain a decreasing order in the queue
        for(int i=0;i<k;i++){
            while(!queue.isEmpty() && nums[queue.peekLast()]<nums[i]){
                queue.pollLast();
            }
            queue.offerLast(i);
        }

        for(int i=k;i<nums.length;i++){
            res[i-k]=nums[queue.peekFirst()];//store the current max from the queue in res

            //if the first queue index is not a part of the current window (expired index), then remove it from the first
            if(!queue.isEmpty() && queue.peekFirst()<=i-k){
                queue.pollFirst();
            }

            //if current element is greater than the elements present at the back of the queue,
            // we should remove them from the end because, it will disrupt the property of maintaining a decreasing order of max values
            while(!queue.isEmpty() && nums[i]>nums[queue.peekLast()]){
                queue.pollLast();
            }

            //store the current index in queue from end as this is a future potential max value
            queue.offerLast(i);
        }

        res[res.length-1]=nums[queue.peekFirst()];//store the last maximum value in res

        return res;
    }
}

class SlidingWindowMaxMain {
    public static void main(String[] args) {
        int[] nums= {1,3,1,2,0,5};
        int k=3;

        int[] res = new SlidingWindowMaximum().maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(res));
    }
}

/*
🔑 Key Idea:
-------------
Instead of recalculating the maximum for each window (which would take O(k) per window, overall O(nk)), we use a monotonic deque that stores indices of elements in decreasing order of their values.

Front of deque → always holds the index of the current maximum.
Back of deque → holds candidates for future maximums.

This way, each element enters and leaves the deque at most once → O(n) time.


✅ Example Walkthrough

nums = [1,3,-1,-3,5,3,6,7], k = 3

First window [1,3,-1] → max = 3
deque = [3] (index of 3)

Slide to [3,-1,-3] → max = 3
deque = [3,-1,-3] (indices in decreasing values order)

Slide to [-1,-3,5] → max = 5
deque = [5]

Slide to [-3,5,3] → max = 5
deque = [5,3]

Slide to [5,3,6] → max = 6
deque = [6]

Slide to [3,6,7] → max = 7
deque = [7]

Result = [3,3,5,5,6,7].


⚡ Complexity

Time: O(n) → each element pushed/popped at most once.
Space: O(k) → deque stores at most k elements.
 */