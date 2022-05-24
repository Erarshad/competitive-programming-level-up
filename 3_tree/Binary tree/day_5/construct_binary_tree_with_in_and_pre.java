//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
class Solution {
    int preorderIndex;
   
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        // build a hashmap to store value -> its index relations
     
        return arrayToTree(preorder, inorder, 0, preorder.length - 1);
    }

    public TreeNode arrayToTree(int[] preorder, int[] inorder, int left, int right) {
        // if there are no elements to construct the tree
        if (left > right) return null;

        // select the preorder_index element as the root and increment it
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        // build left and right subtree
      
        int inorderdx=getch_inorderidx(root.val,inorder,left,right);
        root.left = arrayToTree(preorder, inorder, left,inorderdx-1);
        root.right = arrayToTree(preorder, inorder, inorderdx + 1, right);
        return root;
    }
    public int getch_inorderidx(int val,int[] inorder,int start,int end){
        for(int i=start;i<=end;i++){
            if(inorder[i]==val){
                return i;
            }
        }
        
        return -1;
    }
}