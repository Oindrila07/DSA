package org.DSA.String;

public class Atoi {
    public static int myAtoi(String s) {
        s=s.trim();

        if(s.length()==0)return 0;

        int sign=1;

        if(s.charAt(0)=='-' || s.charAt(0)=='+'){
            if(s.charAt(0)=='-')sign=-1;
            s=s.substring(1);
        }

        s=trimLeadingZeroes(s);

        int i=0, num=0;

        while(i<s.length()){
            if(!Character.isDigit(s.charAt(i)))break;

            if((num>=214748364 && (s.charAt(i)-'0')>7) || num>214748364){
                if(sign==-1)return Integer.MIN_VALUE;
                else return Integer.MAX_VALUE;
            }

            num=num*10+(s.charAt(i)-'0');

            i++;
        }

        if(sign==-1)num=-num;

        return num;
    }

    private static String trimLeadingZeroes(String s){
        int i;

        for(i=0;i<s.length();i++){
            if(s.charAt(i)!='0')break;
        }

        return s.substring(i);
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("-91283472332"));
    }
}
