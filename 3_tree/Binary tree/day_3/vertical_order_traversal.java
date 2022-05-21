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

// https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
import java.util.*;
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(root,0,0)); // added
        int minimum_vertical_index=0;
        int maximum_vertical_index=0;
        
        Hashtable<Integer,List<pair>> map=new Hashtable<>();
        List<List<Integer>> ans=new ArrayList<>();
        while(q.size()>0){
            int size=q.size();
            while(size-->0){
                pair p=q.remove();
               
                if(!map.containsKey(p.vi)){
                    map.put(p.vi,new ArrayList<>());
                    
                }
                
                if(map.containsKey(p.vi)){
                    
            
                    map.get(p.vi).add(p);
                }
                
                
                if(p.node.left!=null){
                    q.add(new pair(p.node.left,p.vi-1,p.ht+1));
                    
                }
                
                
                
                if(p.node.right!=null){
                    q.add(new pair(p.node.right,p.vi+1,p.ht+1));
                }
                
                minimum_vertical_index=Math.min(minimum_vertical_index,p.vi);
                maximum_vertical_index=Math.max(maximum_vertical_index,p.vi);
                
                
                      
                
            }
        }
        
        
        
        
        for(int i=minimum_vertical_index;i<= maximum_vertical_index;i++){
            Collections.sort(map.get(i),(a,b)->{
                if(a.ht-b.ht==0)return a.node.val-b.node.val;
                return a.ht-b.ht;
            });
            List<Integer>temp = new ArrayList<>();
           for(pair p:map.get(i))
           {
               temp.add(p.node.val);
               
               
           }
            ans.add(temp);
            }
        
        
        
        return ans;
        
        
    }
}


class pair{
    TreeNode node;
    int vi;// vertical index;
    int ht;
    pair(TreeNode node, int vi,int ht){
        this.node=node;
        this.vi=vi;
        this.ht = ht;
        
    }
    

    

}