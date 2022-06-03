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
// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/submissions/
import java.util.*;
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
         Hashtable<Integer, Integer> map = new Hashtable<>();
        
        for (int i=0; i<inorder.length; i++) {
            
            map.put(inorder[i], i);
        }
        
        
        return construct(inorder,preorder,0,inorder.length-1,0,preorder.length-1,map);
      
        
    }
    
    
    private TreeNode construct(int[] inorder,int [] preorder, int instart, int inend, int prestart, int preend, Hashtable<Integer,Integer> map){
        
        
        if(instart>inend || prestart>preend){
            return null;
        }
        
        
        
        
        int inRootIdx=map.get(preorder[prestart]);
        int leftSideSize=inRootIdx-instart;
        
        
        TreeNode root=new TreeNode(preorder[prestart]);
        
        root.left=construct(inorder,preorder,instart,inRootIdx-1,prestart+1,prestart+leftSideSize,map);
        root.right=construct(inorder,preorder,inRootIdx+1,inend,prestart+1+leftSideSize,preend,map);
        
        
        return root;
        
        
        
        
        
    }
    
    
    
    
    
    
}