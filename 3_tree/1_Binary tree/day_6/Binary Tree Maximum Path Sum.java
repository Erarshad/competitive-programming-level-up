// https://leetcode.com/problems/binary-tree-maximum-path-sum/


 //do dry run in-order to understand



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
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
       
        maxPathsum(root);
        return max;
        
    }
    
    private int maxPathsum(TreeNode root){
            
        if(root==null){
            return 0;
        }
        
        
      int left=   maxPathsum(root.left);
      int right=  maxPathsum(root.right);
        
        // if left/right will be greater than zero then we will take, if negative we will do //not take consider it zero
        
        left=Math.max(0,left);
        right=Math.max(0,right);
        
        
        int val=left+right+root.val;
        
        if(val>max){
            max=val;
        }
       
        return Math.max(left,right)+root.val;
        
        
    }
    
    
  
}