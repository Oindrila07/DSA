package org.DSA.Arrays;

import java.util.Arrays;

public class RearrangeArrayAlternately {
    public void rearrange(int arr[]) {
        // code here
        Arrays.sort(arr);

        int n=arr.length;

        int divisor=arr[n-1]+1;

        int minInd=0, maxInd=n-1,i=0;

        while(i<n){
            if(i%2==0){
                arr[i]=arr[i]+(arr[maxInd--]%divisor)*divisor;
            }
            else{
                arr[i]=arr[i]+(arr[minInd++]%divisor)*divisor;
            }

            i++;
        }

        for(i=0;i<n;i++){
            arr[i]=arr[i]/divisor;
        }
    }

    public static void main(String[] args) {

    }
}
/*
Intuition:
----------
=> Observation is: at even index we are storing the max values and at the odd, min values
=> keep 2 vales at the same index position
=> use the division formulae:
dividend = divisor * quotient + remainder
so, quotient = dividend / divisor = new value
and, remainder = dividend % divisor =  old value

the divisor is fixed = max value of the array + 1

why are we doing modulo by divisor arr[i]=arr[i]+(arr[index--]%divisor)*divisor?
=> because the index value would have been already replaced in the previous operation
=> and modulo gives us the old value.

*Note: Array must be sorted
 */