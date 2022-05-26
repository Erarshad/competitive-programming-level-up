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
class widthOfBinaryTree {
    public int widthOfBinary_tree(TreeNode root) {
        
        
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(root,0));
        int max=0;
        
        while(q.size()>0){
            
            int len=q.size();
            int left_most=q.peek().idx;
            int right_most=q.peek().idx;
            
            while(len-->0){
                
                pair temp=q.remove();
                right_most=temp.idx;
                
                
                if(temp.node.left!=null){
                    q.add(new pair(temp.node.left,temp.idx*2+1));
                }
                
                if(temp.node.right!=null){
                    q.add(new pair(temp.node.right,temp.idx*2+2));
                }
                
                
            }
            
            max=Math.max(max,right_most-left_most+1);
            
        
            
            
            
            
            
        }
        
        
        
        return max;
        
        
        
        
        
        
        
        
    }
}



class pair{
    TreeNode node;
    int idx;
    pair( TreeNode node,int idx){
        this.idx=idx;
        this.node=node;
    }
}