package org.DSA.LinkedList;

public class ConvertSortedLLToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null)return null;
        TreeNode root=convert(head,null);
        return root;
    }

    private TreeNode convert(ListNode head, ListNode tail){
        if(head==tail)return null;
        int count=countNodes(head,tail);
        ListNode mid=findMid(head,count);
        TreeNode node=new TreeNode(mid.val);
        node.left=convert(head,mid);
        node.right=convert(mid.next,tail);
        return node;
    }

    private ListNode findMid(ListNode node, int count){
        int idx=0;
        while(idx<count/2){
            idx++;
            node=node.next;
        }
        return node;
    }

    private int countNodes(ListNode head, ListNode tail){
        int count=0;
        while(head!=tail){
            count++;
            head=head.next;
        }
        return count;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val){
        this.val=val;
    }
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val=val;
        this.left=left;
        this.right=right;
    }
}
