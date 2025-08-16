package org.DSA.Recursion;

import java.util.ArrayList;
import java.util.List;

public class generateParenthesis {
    public static List<String> generateParenthesis(int n) {
        List<String> list=new ArrayList<>();

        generate(list, n, 0, 0, "");

        return list;
    }

    private static void generate(List<String> list, int n, int open, int close, String res){
        if(open==n && close==n){//when both open and close brackets are same and till the max number allowed
            list.add(res);
            return;
        }

        if(open<n){//keep adding open brackets till its reached the max limit (n)
            generate(list,n,open+1,close,res+"(");
        }

        if(close<open){// keep adding the closing brackets until they are same as the open brackets
            generate(list,n,open,close+1,res+")");
        }
    }

    public static void main(String[] args) {
        List<String> list=new ArrayList<>();

        list=generateParenthesis(3);
        System.out.println(list.toString());
    }
}
