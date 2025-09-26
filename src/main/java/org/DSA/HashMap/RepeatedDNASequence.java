package org.DSA.HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedDNASequence {
    public List<String> findRepeatedDnaSequences(String s) {
        if(s.length()<10)return new ArrayList<>();

        List<String> list=new ArrayList<>();
        HashMap<String,Integer> hash=new HashMap<>();

        for(int i=0;i<s.length()-9;i++){
            String sub=s.substring(i,i+10);
            hash.put(sub,hash.getOrDefault(sub,0)+1);
        }

        for(Map.Entry e:hash.entrySet()){
            if((int)e.getValue()>1)list.add((String)e.getKey());
        }

        return list;
    }
}
