package org.DSA.Recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsOfPhone {
    final HashMap<Character,String> phone=new HashMap<>();

    {
        phone.put('2',"abc");
        phone.put('3',"def");
        phone.put('4',"ghi");
        phone.put('5',"jkl");
        phone.put('6',"mno");
        phone.put('7',"pqrs");
        phone.put('8',"tuv");
        phone.put('9',"wxyz");
    }

    public List<String> letterCombinations(String digits) {
        List<String> list=new ArrayList<>();

        if(digits.isEmpty())return list;

        String[] numbers=new String[digits.length()];

        for(int i=0;i<digits.length();i++){
            numbers[i]=phone.get(digits.charAt(i));
        }

        generate(numbers,"",0,list);

        return list;
    }

    private void generate(String[] numbers, String res, int index, List<String> list){
        if(res.length()==numbers.length){
            list.add(res);
            return;
        }

        for(int i=index;i<numbers.length;i++){
            for(char c:numbers[i].toCharArray()){
                generate(numbers,res+c,i+1,list);
            }
        }
    }
}

class LetterCombinationMain{
    public static void main(String[] args) {
        String digits="892";
        System.out.println(new LetterCombinationsOfPhone().letterCombinations(digits));
    }
}
