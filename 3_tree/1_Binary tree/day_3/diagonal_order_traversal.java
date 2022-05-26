/* Node is defined as
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}*/
// https://practice.geeksforgeeks.org/problems/diagonal-traversal-of-binary-tree/1/
class Tree
{
     public ArrayList<Integer> diagonal(Node root)
      {
         
         Queue<Node> q=new LinkedList<>();
         q.add(root);
         ArrayList<Integer> ans=new ArrayList<>();
         
         while(q.size()>0){
             
             int len=q.size();
             
             
             while(len-->0){
                 
                 Node temp=q.remove();
                 
                 while(temp!=null){
                     ans.add(temp.data);
                     
                     if(temp.left!=null){
                         q.add(temp.left);
                     }
                     
                     temp=temp.right;
                     
                 }
                 
                 
                 
                 
             }
             
             
             
             
             
         }
         
         
         return ans;
         
         
         
         
         
      }
}
