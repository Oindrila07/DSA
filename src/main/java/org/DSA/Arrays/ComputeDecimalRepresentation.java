package org.DSA.Arrays;

public class ComputeDecimalRepresentation {
    public int[] decimalRepresentation(int n) {
        int total=0, temp=n;
        while(temp>0){
            if(temp%10!=0)total++;
            temp/=10;
        }
        int[] nums=new int[total];
        int i=total-1, counter=1;
        temp=n;
        while(temp>0 && i>=0){
            if(temp%10!=0){
                nums[i]=(temp%10)*counter;
                i--;
            }
            temp/=10;
            counter*=10;
        }
        return nums;
    }
}
