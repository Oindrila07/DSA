class Solution {
    public int numberOfSubstringsMethod1(String s) {
        //The idea is to first detect the first substring with all 3 characters starting from i till j
        //because all the consecutive characters will fall into the result:
        //n-1=last character
        HashMap<Character, Integer> hash=new HashMap<>();
        int i=0, j=0, count=0, n=s.length();
        while(j<s.length()){
            hash.put(s.charAt(j),hash.getOrDefault(s.charAt(j),0)+1);
            while(i<j && hash.size()==3){
                count+=(1+((n-1)-j));
                hash.put(s.charAt(i),hash.get(s.charAt(i))-1);
                if(hash.get(s.charAt(i))==0){
                    hash.remove(s.charAt(i));
                }
                i++;
            }
            j++;
        }
        return count;
    }
	
	public int numberOfSubstringsMethod2(String s) {
        return numSubstringsUptoK(s,3)-numSubstringsUptoK(s,2);
    }
    private int numSubstringsUptoK(String s, int k){
        int i=0, j=0, count=0;
        HashMap<Character,Integer> hash=new HashMap<>();
        while(j<s.length()){
            hash.put(s.charAt(j),hash.getOrDefault(s.charAt(j),0)+1);
            while(i<j && hash.size()>k){
                hash.put(s.charAt(i),hash.get(s.charAt(i))-1);
                if(hash.get(s.charAt(i))==0){
                    hash.remove(s.charAt(i));
                }
                i++;
            }
            count+=(j-i+1);
            j++;
        }
        return count;
    }
}
public class NumberOfSubstrings {
    public static void main(String[] args) {
        String s="abcabc";
        System.out.println(new Solution().numberOfSubstringsMethod1(s));
		System.out.println(new Solution().numberOfSubstringsMethod2(s));
    }
}