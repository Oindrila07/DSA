package org.DSA.BinaryTrees;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TreeNode head=new TreeNode(1);
        List<Integer> list=Arrays.asList(0,1,2,3,4,5,-1,8,-1,-1,6,7,-1,-1,9);
        populate(head,list,1);
        display(head, "");

        List<Integer> preOrderedList = new PreOrderTraversal().preorderTraversal(head);
        System.out.println(preOrderedList);

        List<Integer> postOrderedList = new PostOrderTraversalIterative().postorderTraversal(head);
        System.out.println(postOrderedList);
    }
    private static void populate(TreeNode node, List<Integer> list, int index){
        if(index>=list.size())return;
        if(index*2<list.size() && list.get(index*2)!=-1){
            node.left=new TreeNode(list.get(index*2));
            populate(node.left,list,index*2);
        }
        if(index*2+1<list.size() && list.get(index*2+1)!=-1){
            node.right=new TreeNode(list.get(index*2+1));
            populate(node.right, list, index*2+1);
        }
    }
    private static void display(TreeNode node, String s){
        if(node==null)return;
        System.out.println(s+"|----->"+node.val);
        display(node.left,s+"   ");
        display(node.right,s+"   ");
    }
}
