package org.DSA.String;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String prefix=strs[0];
        int len=prefix.length();

        for(int i=1;i<strs.length;i++){
            String str=strs[i];

            if(len>str.length()){
                len=str.length();
                prefix=prefix.substring(0,len);
            }
            while(!prefix.equals(str.substring(0,len))){
                len--;
                prefix=prefix.substring(0,len);
            }
        }

        return prefix;
    }
}

/*
TC: O(m*n)
 */