class Solution{
    public Tree cloneTree(Tree tree){
        
        if(tree==null){
            return null;
        }
       // add code here.
      Tree root=new Tree(tree.data);
      root.left=cloneTree(tree.left);
      root.right=cloneTree(tree.right);
      
      return root;
     }
}