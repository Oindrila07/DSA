package org.DSA.BinaryTrees;

public class ConvertSortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root=findNode(nums, 0, nums.length-1);
        return root;
    }

    private TreeNode findNode(int[] nums, int low, int high){
        if(low>high)return null;
        int mid=low+(high-low)/2;

        TreeNode node=new TreeNode(nums[mid]);
        node.left=findNode(nums,low,mid-1);
        node.right=findNode(nums,mid+1,high);
        return node;
    }
}
