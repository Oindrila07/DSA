package org.DSA.Arrays;

public class RearrangeArray {
    public void arrange(long[] arr) {
        int n=arr.length;

        for(int i=0;i<n;i++){
            arr[i]=arr[i]+(arr[(int)arr[i]]%n)*n;//same concept ad RearrangeArrayAlternately
            //current position = remainder + (quotient % divisor) * divisor
            //'%' is being used because we want to get the old value for next computation
        }

        for(int i=0;i<n;i++){
            arr[i]/=n;
        }
    }

    public static void main(String[] args) {

    }
}
