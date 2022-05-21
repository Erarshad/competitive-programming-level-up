
// https://practice.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1/#
class Solution
{
	ArrayList <Integer> boundary(Node node)
	{
	    ArrayList<Integer> ans=new ArrayList<>();
	    ans.add(node.data);
	    if(node.left!=null){
	         findLeft(ans,node.left);
	    }
	    
	    getLeaves(ans,node.left);
	    getLeaves(ans,node.right);
	    
	    Stack<Integer> st=new Stack<>();
	    if(node.right!=null){
	    findRight(st,node.right);
	    }
	    
	     while(st.size()!=0){
	         ans.add(st.pop());
	     }
	     
	     
	     return ans;
	    
	    
	    
	}
	
	
	
	private void findLeft(ArrayList<Integer> ans, Node node){
	    if(node==null){
	        return;
	    }
	    
	    
	    if(node.left==null && node.right==null){
	        return;
	    }
	    
	    ans.add(node.data);
	    
	    if(node.left!=null){
	        findLeft(ans,node.left);
	    }else if(node.right!=null){
	        findLeft(ans,node.right);
	    }
	  
	  
	}
	
	private void getLeaves(ArrayList<Integer> ans, Node node){
	    
	    if(node==null){
	        return;
	    }
	    
	    if(node.left==null && node.right==null){
	    
	         ans.add(node.data);
	         
	    }
	    
	    getLeaves(ans,node.left);
	    getLeaves(ans,node.right);
	    
	    
	}
	
	private void findRight(Stack<Integer> st, Node node){
	    
	    if(node==null){
	        return;
	    }
	    
	    if(node.left==null && node.right==null){
	        //if it is leave return
	        return;
	    }
	    
	    st.push(node.data);
	    
	   if(node.right!=null){
	       
	       findRight(st,node.right);
	       
	       
	   }else if(node.left!=null){
	       
	       findRight(st,node.left);
	       
	   }
	   
	    
	}
	
	
}
