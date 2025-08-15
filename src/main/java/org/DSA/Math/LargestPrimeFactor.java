package org.DSA.Math;

public class LargestPrimeFactor {
    static int largestPrimeFactor(int n) {
        // code here
        if(n<=3 || n==5)return n;

        int fact=0, temp=n;

        while(n%2==0){
            fact=2;
            n/=2;
        }

        while(n%3==0){
            fact=3;
            n/=3;
        }

        for(int i=5;i<=temp;i+=6){
            while(n%i==0){
                n/=i;
                fact=i;
            }

            while(n%(i+2)==0){
                n/=(i+2);
                fact=i+2;
            }
        }

        return fact;
    }

    public static void main(String[] args) {
        System.out.println(largestPrimeFactor(13195));
    }
}

/*
Intuition:
----------
If we want the largest prime factor:
=> Start dividing n by the smallest primes first (2, 3, 5, 7, 11, …).
=> Each time we find a divisor, we keep dividing until it’s no longer divisible.
=> The last divisor we successfully use will be the largest prime factor.

Instead of checking every number, we can skip unnecessary checks using:
The fact that every prime > 3 can be written as 6k ± 1.


Approach:
---------
=> Handle small numbers and base cases
If n ≤ 3 or n == 5, then n itself is prime, so return n.

=> Remove all factors of 2
While n is even, divide it by 2 and store fact = 2.

=> Remove all factors of 3
While divisible by 3, divide and store fact = 3.

=> Check numbers of the form 6k ± 1
Start from i = 5, increment by 6 each loop.

Check:
i (which is 6k - 1)
i + 2 (which is 6k + 1)
If divisible, divide until it’s not divisible and update fact.

=> Return largest factor

Once all smaller prime factors are removed, fact will hold the largest prime factor.
 */
