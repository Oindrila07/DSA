package org.DSA.Recursion;

import java.util.ArrayList;
import java.util.List;

public class generateBinaryStrings {
    public List<String> generateBinaryStrings(int n) {
        // Your code goes here
        List<String> list=new ArrayList<>();

        generate(list, n, 0, "");

        return list;
    }

    private void generate(List<String> list, int n, int index, String res){
        if(index==n){
            list.add(res);
            return;
        }

        generate(list, n, index+1, res+"0");

        if(res.isEmpty() || res.charAt(res.length() - 1) != '1'){
            generate(list, n, index+1, res+"1");
        }
    }
}

class generateBinaryStringsHelper{
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list=new generateBinaryStrings().generateBinaryStrings(5);

        System.out.println(list.toString());
    }
}
