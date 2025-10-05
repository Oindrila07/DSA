package org.DSA.HashMap;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnALine {
    public int maxPoints(int[][] points) {
        if(points.length==1)return 1;
        int max=2; // at least 2 points needed to form a line
        for(int i=0;i<points.length;i++){
            HashMap<Double,Integer> hash=new HashMap<>();
            int localMax=0;
            for(int j=0;j<points.length;j++){
                if(i==j)continue;
                int x=points[j][0]-points[i][0];
                int y=points[j][1]-points[i][1];
                double slope=Math.atan2(y,x);
                hash.put(slope,hash.getOrDefault(slope,0)+1);
            }
            for(Map.Entry e:hash.entrySet()){
                localMax=Math.max(localMax,(int)e.getValue());
            }
            max=Math.max(max,localMax+1); //+1 because the base point itself counts.
        }

        return max;
    }
}

/*
Intuition:
----------
=> A line in 2D can be uniquely identified by its slope (unless vertical, in which case slope is ∞).
=> For each point, think of it as an anchor/base point.
=> Count how many other points lie on the same line with the base by grouping points by slope.
=> The maximum size of any slope group + the base point itself is the maximum number of points on a line passing through that base.
=> Repeat this for every base point and take the global maximum.


Approach:
---------
=> If there is only 1 point, max = 1.
=> Otherwise, at least 2 points form a line, so we start max=2.
=> i is the base point.
=> hash stores slope → count of points for the line passing through i.
=> localMax tracks the max number of points on any line passing through base i.
=> Skip i == j (don’t compare the point with itself).
=> Compute difference in coordinates: x = x2 - x1, y = y2 - y1.
=> Compute slope using atan2(y, x):
    -> Handles vertical lines (x=0) automatically.
    -> Handles negative slopes correctly.
=> Increment slope count in the hash.

Intuition:
=> All points that lie on the same line w.r.t base i will have the same slope.
=> hash groups points by the line they belong to (slope is key).
=> localMax = maximum number of points sharing a slope with the base.
=> +1 because the base point itself counts.
=> Update overall maximum line size.


Complexity:
-----------
TC: O(n^2)
SC: O(n)
 */
