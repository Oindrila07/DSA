package org.DSA.Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[1]-b[1]);
        List<int[]> list=new ArrayList<>();
        list.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            int[] interval1=list.get(list.size()-1), interval2=intervals[i];
            if(interval1[1]<=interval2[0]){
                list.add(intervals[i]);
            }
        }
        return intervals.length-list.size();
    }
}


/*
Intuition:
----------
We want to remove the minimum number of intervals so that no two intervals overlap.
A greedy observation is that if we choose an interval that finishes earliest, then we leave the maximum room for future intervals → helping avoid overlaps.

Approach:
---------
Sort intervals by their ending time (ascending).

Initialize:
-----------
cnt = 1 (we always keep the first interval)

le = intervals[0][1] (end time of the last kept interval)

Iterate through the intervals:
If the current interval’s start is greater than or equal to le,
→ no overlap → keep it
→ update cnt and le

Else:
→ intervals overlap → we skip/remove it

Final answer = total intervals - kept intervals
 */