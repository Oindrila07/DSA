package org.DSA.Recursion;

public class AtoiRecursive {
    public static int myAtoi(String s) {
        s=s.trim();

        if(s.isEmpty())return 0;

        int sign=1;

        if(s.charAt(0)=='+' || s.charAt(0)=='-'){
            if(s.charAt(0)=='-')sign=-1;
            s=s.substring(1);
        }

        s=trimLeadingZeroes(s);

        if(s.equals("0"))return 0;

        return compute(s,sign,0,0);
    }

    private static int compute(String s, int sign, int res, int index){
        if(index==s.length() || !Character.isDigit(s.charAt(index)))return sign*res;

        if(res>Integer.MAX_VALUE/10 || (res==Integer.MAX_VALUE/10 && (s.charAt(index)-'0')>7) || index>9){
            if(sign==-1)return Integer.MIN_VALUE;
            return Integer.MAX_VALUE;
        }

        res=(res*10)+(s.charAt(index)-'0');
        return compute(s,sign,res,index+1);
    }

    private static String trimLeadingZeroes(String s){
        int i;

        for(i=0;i<s.length();i++){
            if(s.charAt(i)-'0'!=0)break;
        }

        if(i==s.length() || !Character.isDigit(s.charAt(i)))return "0";
        return s.substring(i);
    }

    public static void main(String[] args) {
        String s1="-379274892748932904739";
        System.out.println(myAtoi(s1));
        String s2="             002739-48";
        System.out.println(myAtoi(s2));
        String s3="00000-42";
        System.out.println(myAtoi(s3));
    }
}

/*
=> I’m using recursion for parsing digits one by one.
=> I handle sign, leading spaces, leading zeroes.
=> I prevent integer overflow with boundary checks.
=> Complexity is still O(n) time, O(n) space (due to recursion stack).
 */