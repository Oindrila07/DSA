package org.DSA.Recursion;

public class ReverseInteger {
    public static int reverse(int x) {
        if(x>=-9 && x<=9) return x;
        if(x==Integer.MIN_VALUE || x==Integer.MAX_VALUE) return 0;

        int sign=1;

        if(x<0){
            sign=-1;
            x=-x;
        }

        int res=reverseNum(x,0);

        return sign==-1?-res:res;
    }

    private static int reverseNum(int num, int res){
        if(num==0) return res;

        if(res>Integer.MAX_VALUE/10)return 0;

        res=(res*10)+(num%10);
        return reverseNum(num/10, res);
    }

    public static void main(String[] args) {
        System.out.println(reverse(479382030));
    }
}
