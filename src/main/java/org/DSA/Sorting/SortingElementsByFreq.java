package org.DSA.Sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class SortingElementsByFreq {
    public static void main (String[] args)
    {
        //code
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();

        while(t-->0){
            int n=sc.nextInt();
            Integer[] arr=new Integer[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            sort(arr,n);
            print(arr);
        }
    }

    public static void sort(Integer[] arr, int n){
        HashMap<Integer,Integer> hash=new HashMap<>();
        for(int num:arr){
            hash.put(num,hash.getOrDefault(num,0)+1);
        }
        Arrays.sort(arr,(a, b)->{
            int freq1=hash.get(a);
            int freq2=hash.get(b);

            if(freq1!=freq2)return freq2-freq1;
            return a-b;
        });
    }

    public static void print(Integer[] arr){
        for(int num:arr){
            System.out.print(num+" ");
        }
        System.out.println();
    }
}
