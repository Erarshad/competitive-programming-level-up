// to solve this question first do countsubarraysum_hashmap.java

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
    //bruteforce solution via recursion 
    // tc - 0(n^2)
    // sc- 0(n);
     int val=0;
    
    public int pathSum(TreeNode root, int targetSum) {
        
        
       solveForAll(root,targetSum);
        
        return val;
        
        
    }
    
    
    private void solveForAll(TreeNode root, int targetSum){
        
        if(root==null){
            return ;
        }
        
       
       pathSumcalc(root,0,targetSum);  //exploring sum path from all the nodes
        
        solveForAll(root.left,targetSum);
       solveForAll(root.right,targetSum);
        
        
    
        
        
        
        
        
        
    }
    
    
    
    
    private void pathSumcalc(TreeNode root, int sum,int targetSum){
        
        if(root==null){
            return;
        }
       
        if(sum+root.val==targetSum){
            val++;
        }
       
        
        
        
        
       pathSumcalc(root.left,sum+root.val,targetSum);
        
        pathSumcalc(root.right,sum+root.val,targetSum);
        
        
        
        
    }
    
    
}