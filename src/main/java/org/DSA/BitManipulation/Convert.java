package org.DSA.BitManipulation;

public class Convert {
    public String convertToBinary(long num){
        StringBuilder res=new StringBuilder();
        while(num>0){
            res.append(num%2);
            num/=2;
        }
        return res.reverse().toString();
    }
    
    /*
    TC: O(logn)
     */

    public int convertToDecimal (String num){
        int res=0, n=num.length();
        for(int i=num.length()-1;i>=0;i--){
            int bit=num.charAt(i)-'0';
            res+=bit*((int) Math.pow(2, (n - i - 1)));
        }
        return res;
    }
}

class CovertMain {
    public static void main(String[] args) {
        int num1 = 29;
        long num2=(long)Math.pow(2,31);
        Convert c = new Convert();
        System.out.println(c.convertToBinary(num1));
        System.out.println(c.convertToBinary(num2));
        System.out.println(c.convertToDecimal("1111111111111111111111111111111"));
        System.out.println(13^7);
        System.out.println((long)num1<<1);
        System.out.println(~0);
        System.out.println(~(-1));
    }
}
