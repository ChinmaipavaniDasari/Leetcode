/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helperfunction(nums,0,nums.length);
    }
    TreeNode helperfunction(int[] nums,int left,int right){
        if(left>=right){
            return null;
        }
        int mid = left+(right - left)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helperfunction(nums,left,mid);  
        root.right = helperfunction(nums,mid+1,right);
        return root;
    }
}