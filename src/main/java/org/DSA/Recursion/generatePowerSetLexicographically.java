package org.DSA.Recursion;

public class generatePowerSetLexicographically {
    public static void main(String[] args) {
        String s="abc";
        generatePowerSet(s,"",0,s.length());
    }

    static void generatePowerSet(String s, String res, int index, int n){
        if(!res.isEmpty()){
            System.out.print(res+" ");
        }

        for(int i=index;i<s.length();i++){
            generatePowerSet(s,res+s.charAt(i),i+1,n);
        }
    }
}

/*
generatePowerSet("abc", "", 0, 3)
index=0, res="" → no print

i=0 → recurse with res="a", index=1

print "a"

loop:

i=1 → recurse with "ab", index=2

print "ab"

loop:

i=2 → recurse with "abc", index=3 → print "abc" → loop ends

i=2 → recurse with "ac", index=3 → print "ac"

i=1 → recurse with "b", index=2

print "b"

loop:

i=2 → recurse with "bc", index=3 → print "bc"

i=2 → recurse with "c", index=3 → print "c"


Tree Representation
arduino
Copy
Edit
""
├── "a"
│   ├── "ab"
│   │   └── "abc"
│   └── "ac"
├── "b"
│   └── "bc"
└── "c"
 */