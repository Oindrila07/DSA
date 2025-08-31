package org.DSA.Matrix;

public class CelebrityProblemBruteForce {
    public int celebrity(int mat[][]) {
        // code here
        int n=mat.length;
        if(n==1)return 0;

        int[] knowMe=new int[n];
        int[] Iknow=new int[n];

        for(int row=0;row<n;row++){
            for(int col=0;col<n;col++){
                if(mat[row][col]==1 && row!=col){
                    Iknow[row]++;
                    knowMe[col]++;
                }
            }
        }

        for(int i=0;i<n;i++){
            if(Iknow[i]==0 && knowMe[i]==n-1)return i;
        }

        return -1;
    }
}

class Main {
    public static void main(String[] args) {
        int[][] mat =   {{1, 0, 1,1},
                        {0, 1, 1, 1},
                        {1, 1, 1, 1},
                        {0, 0, 0, 1}};

        System.out.println(new CelebrityProblemBruteForce().celebrity(mat));
        System.out.println(new CelebrityProblem().celebrity(mat));
    }
}

/*
Intuition:
----------
A naive approach to solve this problem is to count all the persons that are known for each person and to count all the person that each person knows. This way the celebrity can be identified by finding the person who is known by all other people and who does not know any person.

Approach:
---------
Create two lists to count how many people each person knows and how many people know each person.
Iterate through the matrix to update the counters based on whether a person knows another person.
After populating the counters, iterate through them to find a person who is known by everyone else but does not know anyone. If such a person is found, return their index.
If no such person is found, return -1 indicating there is no celebrity.
 */