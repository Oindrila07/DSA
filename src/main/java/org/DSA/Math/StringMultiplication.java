package org.DSA.Math;

public class StringMultiplication {
    public static String multiplyStrings(String s1, String s2) {
        // code here
        if(s1.equals("0") || s2.equals("0"))return "0";

        if(s1.length()<s2.length())return multiplyStrings(s2,s1);

        int sign1=1, sign2=1;

        if(s1.charAt(0)=='+' || s1.charAt(0)=='-'){
            if(s1.charAt(0)=='-')sign1=-1;
            s1=s1.substring(1);
        }

        if(s2.charAt(0)=='+' || s2.charAt(0)=='-'){
            if(s2.charAt(0)=='-')sign2=-1;
            s2=s2.substring(1);
        }

        int sign=sign1*sign2;

        int m=s1.length(), n=s2.length();

        StringBuilder sb=new StringBuilder();

        int[] sum=new int[m+n];

        int counter=0;

        for(int i=n-1;i>=0;i--){
            int[] res=new int[m+n];

            int num2=s2.charAt(i)-'0';
            int index=(res.length-1)-counter;

            int carry=0;

            for(int j=m-1;j>=0;j--){
                int num1=s1.charAt(j)-'0';

                int prod=(num1*num2)+carry;

                if(prod>9){
                    carry=prod/10;
                    prod=prod%10;
                }
                else carry=0;

                res[index--]=prod;
            }

            if(carry>0){
                res[index]=carry;
                carry=0;
            }

            for(int k=m+n-1;k>=0;k--){
                int x=sum[k]+res[k]+carry;

                if(x>9){
                    carry=x/10;
                    x%=10;
                }
                else carry=0;

                sum[k]=x;
            }

            if(carry>0){
                sum[0]=carry;
            }

            counter++;
        }

        int index;

        for(index=0;index<sum.length;index++){
            if(sum[index]>0)break;
        }

        for(int i=index;i<sum.length;i++){
            sb.append(sum[i]);
        }

        if(sign<0 && !sb.isEmpty())return "-"+sb.toString();

        return sb.isEmpty()?"0":sb.toString();
    }

    public static void main(String[] args) {
        String s1="-483902";
        String s2="000000000468382";

        System.out.println(multiplyStrings(s1,s2));
    }
}
