package org.DSA.Recursion;

public class countLetters {
    public static int fun(String s, int k, int n, char c) {
        // Your code here
        int res=0;

        return countOccurrence(s,n,c,0,0,k,1);
    }
    private static int countOccurrence(String s, int n, int c, int index, int res, int k, int counter){
        if(counter>n || k==0)return res;

        if(s.charAt(index)==c)res++;
        index=index+1;
        if(index==s.length())k--;
        return countOccurrence(s,n,c,(index)%s.length(),res,k,counter+1);
    }

    public static void main(String[] args) {
        String s="WLRBBMQBHCDARZOWKKYHIDDQSCDXRJMOWFRXSJYBLDBEFSARCBYNECDYGGXXPKLORELLNMPAPQFWKHOPKMCOQHNWNKUEWHSQMGBBUQCLJJIVSWMDKQTBXIXMVTRRBLJPTNSNFWZQFJMAFADRRWSOFSBCNUVQHFFBSAQXWPQCACEHCHZVFRKMLNOZJKPQPXRJXKITZYXACBHHKICQCOENDTOMFGDWDWFCGPXIQVKUYTDLCGDEWHTACIOHORDTQKVWCSGSPQOQMSBOAGUWNNYQXNZLGDGWPBTRWBLNSADEUGUUMOQCDRUBETOKYXHOACHWDVMXXRDRYXLMNDQTUKWAGMLEJUUKWCIBXUBUMENMEYATDRMYDIAJXLOGHIQFMZH";
        int k=67, n=191;
        char c='V';

        System.out.println(fun(s,k,n,c));
    }
}
