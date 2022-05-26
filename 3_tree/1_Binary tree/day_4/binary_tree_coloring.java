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

//https://leetcode.com/problems/binary-tree-coloring-game/
class Solution {
    
    int leftsubtreeSize=0;
    int rightsubtreeSize=0;
    
    
    
    
    ;
    
    private int sizeOfTree(TreeNode root, int x){
        
        if(root==null){
            return 0;
        }
        
        int lh=sizeOfTree(root.left,x);
        int rh=sizeOfTree(root.right,x);
        if(root.val==x){
            leftsubtreeSize=lh;
            rightsubtreeSize=rh;
        }
        
        
        return lh+rh+1;
        
    }
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        sizeOfTree(root,x);
        
        
        int otherSide=n-(leftsubtreeSize+rightsubtreeSize+1);
        
        int maxOfthree=Math.max(otherSide,Math.max(leftsubtreeSize,rightsubtreeSize));
        
        
        int rest=n-maxOfthree;
        if(maxOfthree>rest){
            return true;
        }
        
        
        
        
        
        return false;
        
        
        
        
    }
}