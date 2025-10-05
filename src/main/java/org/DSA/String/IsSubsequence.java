package org.DSA.String;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if(s.length()>t.length())return false;
        int idx=0;
        for(int i=0;i<t.length();i++){
            if(idx>=s.length())break;
            if(s.charAt(idx)==t.charAt(i)){
                idx++;
            }
        }
        return idx==s.length();
    }
}
