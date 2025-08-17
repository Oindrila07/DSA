package org.DSA.Recursion;

public class CountGoodNumbers {
    final long mod=1000000007;
    public int countGoodNumbers(long n) {
        if(n==1)return 5;

        long even=(n+1)/2, odd=n/2;

        return (int)((calculatePower(5,even)*calculatePower(4,odd))%mod);
    }

    private long calculatePower(long num, long ex){
        if(ex==0)return 1;
        if(ex%2==0)return calculatePower((num*num)%mod,ex/2)%mod;
        return (num*calculatePower((num*num)%mod,(ex-1)/2))%mod;
    }
}

class CountGoodNumbersMain{
    public static void main(String[] args) {
        System.out.println(new CountGoodNumbers().countGoodNumbers(5000));
    }
}

/*
🔎 Problem Intuition:
---------------------
We want to count the number of "good" digit strings of length n, where:

Digits at even indices (0,2,4,…) can be one of {0,2,4,6,8} → 5 choices.
Digits at odd indices (1,3,5,…) can be one of {2,3,5,7} → 4 choices.

So ans = ((5^even)*(4^odd))%mod
 */
