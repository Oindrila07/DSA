package org.DSA.Recursion;

public class Handshakes {
    static int count(int N) {
        // code here
        return countShakes(N);
    }

    private static int countShakes(int n){
        if(n%2!=0)return 0;
        if(n==2 || n==0)return 1;

        int sum=0;

        // Fix person 1, try pairing them with every valid partner (even index)
        // Because pairing with an odd index would leave an odd group (impossible)
        for(int k=2;k<=n;k+=2){
            int shakeHandsLeft=countShakes(k-2);// Left side: people between 1 and k (excluding both ends)
            int shakeHandsRight=countShakes(n-k);// Right side: people outside (remaining after k)

            sum+=(shakeHandsLeft*shakeHandsRight);// Total ways contributed by this pairing = left × right
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(count(8));
    }
}


/*
🔹 Approach:
------------
=> There are n people (even number) sitting around a circular table.
=> Each person must shake hands with exactly one other person. No two handshakes are allowed to cross.

Recursive thought process:
--------------------------
=> Pick one fixed person (say person 1).
=> Person 1 must shake hands with some other person k (where k is even so that the remaining people are balanced on both sides).
=> Once person 1 shakes with k, the circle is split into two independent smaller groups:
1) People sitting between 1 and k (excluding 1 and k).
2) The rest of the people outside (from k+1 to n).
These two groups must independently form valid handshake arrangements.

Recursive combination:
---------------------
For each valid k, the total number of ways =
(ways to arrange handshakes in left group) × (ways to arrange handshakes in right group).

Add up this product for all possible choices of k.

Base cases:
If there are 0 people → 1 way (empty arrangement).
If there are 2 people → 1 way (they must shake hands).

Final Answer: Apply the above recursion for n.


Example:
for n=8:

Step 1: Fix person 1
Possible partners: 2, 4, 6, 8 (must be even to balance both sides).

Step 2: Apply recurrence
If 1–2 shake: left group = 0, right group = 6 → f(0) × f(6) = 5
If 1–4 shake: left group = 2, right group = 4 → f(2) × f(4) = 2
If 1–6 shake: left group = 4, right group = 2 → f(4) × f(2) = 2
If 1–8 shake: left group = 6, right group = 0 → f(6) × f(0) = 5

so, f(8)=f(0)f(6)+f(2)f(4)+f(4)f(2)+f(6)f(0) = 14


Reference: https://www.youtube.com/watch?v=J3Mtaa0jv6s
 */