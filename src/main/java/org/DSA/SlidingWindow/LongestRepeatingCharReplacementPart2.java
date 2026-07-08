class Solution {
    public int characterReplacement(String s, int k) {
        //The idea is to replace the minimum possible characters in a substring window, 
      //so we need to figure out the (total length of substring - the maxFreq)
        int i=0, j=0, len=0, n=s.length();
        int[] freq=new int[26];
        while(j<n){
            freq[s.charAt(j)-'A']++;
            int maxFreq=0, subLen=j-i+1;
            for(int f:freq){
                maxFreq=Math.max(f,maxFreq);
            }
            while(i<j && subLen-maxFreq>k){
                freq[s.charAt(i)-'A']--;
                for(int f:freq){
                    maxFreq=Math.max(maxFreq,f);
                }
                i++;
                subLen=j-i+1;
            }
            len=Math.max(len,j-i+1);
            j++;
        }
        return len;
    }
}
