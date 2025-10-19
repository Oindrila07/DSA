package org.DSA.BitManipulation;

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if(dividend==divisor)return 1;
        if(divisor==1)return dividend;
        if(divisor==-1){
            if(dividend==Integer.MIN_VALUE)return Integer.MAX_VALUE;
            return -dividend;
        }
        int res=0;
        int sign=1;
        if((dividend<0 && divisor>=0) || (dividend>=0 && divisor<0))sign=-1;

        long num=Math.abs((long)dividend);
        long div=Math.abs((long)divisor);
        while(num>=div){ //Loop until the remaining dividend num is smaller than div. Each loop iteration produces at least one subtraction of a large multiple of div, so the loop will finish.
            long x=div, count=1;
            //Start x at div. x will represent the current multiple of div we are considering (i.e. div * 2^k).
            //count is the multiplier corresponding to x (i.e. 1, 2, 4, 8, ...). Both are long for safety.
            while((x<<1)<=num){
                //Double x (shift left by 1) while the doubled value is still ≤ num. This finds the largest doubling x = div * 2^k such that x <= num.
                //Simultaneously double count to keep track that x = div * count.
                //We use (x << 1) <= num rather than x <= num then doing x <<= 1 inside, so we ensure x never becomes greater than num before the condition breaks.
                //Using long prevents overflow when x is shifted.
                x<<=1;
                count<<=1;
            }
            //Add count to the quotient since x = div * count fits into num.
            //Subtract x from num to reduce the remaining dividend.
            //This simulates adding count copies of div to the quotient and removing those copies from num.
            res+=count;
            num-=x;
        }
        return sign*res;
    }
}


/*
TC: O((log n)^2)
 */