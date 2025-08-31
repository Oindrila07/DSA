package org.DSA.Matrix;

public class CelebrityProblem {
    public int celebrity(int mat[][]) {
        // code here
        int n=mat.length;
        int top=0, bottom=n-1;

        while(top<bottom){
            if(mat[top][bottom]==0 && mat[bottom][top]==0){
                top++;
                bottom--;
            }
            if(top<bottom && mat[top][bottom]==1)top++;
            if(top<bottom && mat[bottom][top]==1)bottom--;
        }

        if(top>bottom)return -1;

        for(int i=0;i<n;i++){
            if((mat[top][i]==1 || mat[i][top]==0) && top!=i)return -1;
        }

        return top;
    }
}

/*
Intuition:
----------
Since there can be only one celebrity, instead of finding the celebrity, the people that are not celebrity can be determined. If all such people are found, any person left (if it exists) will be the celebrity.
THe two conditions to identify the celebrity is:

The celebrity should be known by every person.
There should be no person that celebrity knows.



Approach:
---------
Set up two pointers, one at the top of the matrix and one at the bottom.
Use the pointers to compare individuals:
If the person at the top pointer knows the person at the bottom pointer, move the top pointer down (as it cannot be the celebrity).
If the person at the bottom pointer knows the person at the top pointer, move the bottom pointer up (as it cannot be the celebrity).
If neither knows the other, increment both pointers (as they both cannot be the celebrity).
After the traversal, check if the remaining candidate pointed by the top pointer is a valid celebrity by ensuring that everyone knows this person and this person knows no one.

 */
