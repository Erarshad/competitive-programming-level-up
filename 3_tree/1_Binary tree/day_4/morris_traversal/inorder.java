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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
       // inorderTraverse(root,list);
        morrisInordertraversal(root,list);
        return list;
        
    }
    
  
    // here we can use either method but recursion takes 0(n) space but morris does not 
    // recursion  complexity vs morris

     /*
     
     recursion have 0(n) t.c
                     0(n) sc
                     
    while morris have the 0(n) t.c
                           0(1) s.c
      
     
     */
    private void morrisInordertraversal(TreeNode root, List<Integer> list){
        
        TreeNode curr=root;
        
        while(curr!=null){
            
            if(curr.left==null){
                list.add(curr.val);
                curr=curr.right;
            }else{
                
                TreeNode prev=curr.left;
                while(prev!=null && prev.right!=null && prev.right!=curr){
                    prev=prev.right;
                }
                
                if(prev.right==null){
                    prev.right=curr;  //making thread
                    curr=curr.left;
                }else{
                    prev.right=null; // removing thread
                    list.add(curr.val);
                    curr=curr.right;
                }
                
                
                
            }
            
            
            
            
        }
        
        
        
    }

    private void inorderTraverse(TreeNode root,List<Integer>list){
        if(root==null){
            return;
        }
        
        inorderTraverse(root.left,list);
        list.add(root.val);
        inorderTraverse(root.right,list);
        
    }
}