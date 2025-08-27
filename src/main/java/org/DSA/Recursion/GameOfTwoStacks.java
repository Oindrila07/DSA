package org.DSA.Recursion;

import java.util.Arrays;
import java.util.List;

public class GameOfTwoStacks {
    public static int twoStacks(int maxSum, List<Integer> a, List<Integer> b) {
        // Write your code here
        if(a.size()>b.size())return twoStacks(maxSum, b,a);
        int sum=0, count=0;

        return countSelection(a,b,count,sum,maxSum,0,0)-1;
    }

    private static int countSelection(List<Integer> a, List<Integer> b, int count, int sum, int maxSum, int index1, int index2){
        if(sum>Integer.MAX_VALUE/10 || sum>maxSum || sum<0)return count;


        int count1=0, count2=0;
        if(index1<a.size())
            count1=countSelection(a,b,count+1,sum+a.get(index1),maxSum, index1+1, index2);

        if(index2<b.size())
            count2=countSelection(a, b, count+1, sum+b.get(index2), maxSum, index1, index2+1);

        return Math.max(count1, count2);
    }

    public static void main(String[] args) {
        List<Integer> a=Arrays.asList(4,2,4,6,1);
        List<Integer> b= Arrays.asList(2,1,8,5);
        System.out.println(twoStacks(10,a,b));
    }
}

/*
The intuition is to solve the problem by exploring all possible options - in this case we have two options to choose:
1) either choose all from a or b
2) or choose mixed values from a and b

TC = O(2^(n+m))
 */
