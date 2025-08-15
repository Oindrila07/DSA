package org.DSA.Math;

import java.util.Arrays;

public class CountPrimes {
    public static int countPrimes(int n) {
        if(n<=2) return 0;

        boolean[] isPrime=new boolean[n];
        Arrays.fill(isPrime,true);

        isPrime[0]=isPrime[1]=false;

        int count=0;

        for(long i=2;i<n;i++){
            if(isPrime[(int)i])count++;
            for(long j=i*i;j<n;j+=i){
                isPrime[(int)j]=false;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(180382));
    }
}
