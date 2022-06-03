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
    int camera=0;
    public int minCameraCover(TreeNode root) {
        
        
        if(minimumCameraInstallment(root)==-1){
            camera++;
        }
        
        
        
        return camera;
        
        
        
        
        
        
    }
    
    
    
    /**
    -> 1 means it is covered
    -> -1 means it need camera
    -> 0 means it have camera
    
    **/
    
    
    
    private int minimumCameraInstallment(TreeNode root){
        
        if(root==null){
            return 1;
        }
        
        
        
        
        int lchild=minimumCameraInstallment(root.left);
        int rchild=minimumCameraInstallment(root.right);
        
        if(lchild==-1 || rchild==-1){
            camera++;
            
            return 0;
         }
  
        if(lchild==0 || rchild==0){
            return 1;
        }
        
        
        return -1;
        
        
        
        
        
    }
}