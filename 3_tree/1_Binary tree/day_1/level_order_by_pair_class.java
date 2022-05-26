
import java.io.*;
import java.time.temporal.Temporal;
import java.util.*;

public class level_order_by_pair_class {
  public static class Node {
    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  public static class Pair {
    Node node;
    int state;

    Pair(Node node, int state) {
      this.node = node;
      this.state = state;
    }
  }

  public static Node construct(Integer[] arr) {
    Node root = new Node(arr[0], null, null);
    Pair rtp = new Pair(root, 1);

    Stack<Pair> st = new Stack<>();
    st.push(rtp);

    int idx = 0;
    while (st.size() > 0) {
      Pair top = st.peek();
      if (top.state == 1) {
        idx++;
        if (arr[idx] != null) {
          top.node.left = new Node(arr[idx], null, null);
          Pair lp = new Pair(top.node.left, 1);
          st.push(lp);
        } else {
          top.node.left = null;
        }

        top.state++;
      } else if (top.state == 2) {
        idx++;
        if (arr[idx] != null) {
          top.node.right = new Node(arr[idx], null, null);
          Pair rp = new Pair(top.node.right, 1);
          st.push(rp);
        } else {
          top.node.right = null;
        }

        top.state++;
      } else {
        st.pop();
      }
    }

    return root;
  }

  public static void display(Node node) {
    if (node == null) {
      return;
    }

    String str = "";
    str += node.left == null ? "." : node.left.data + "";
    str += " <- " + node.data + " -> ";
    str += node.right == null ? "." : node.right.data + "";
    System.out.println(str);

    display(node.left);
    display(node.right);
  }
  //---------------------------------------
   // level order by line wise

   static class lvNode{
       Node node;
       int level;
       lvNode(Node node, int level){
           this.node=node;
           this.level=level;
       }
   }

   public static void levelOrderPair(Node root){
       Queue<lvNode> q=new LinkedList<>();
       q.add(new lvNode(root,1));
       int curr_level=1;
       while(q.size()>0){
           lvNode temp=q.remove();
           if(temp.level>curr_level){
               System.out.println();
               curr_level=temp.level;

           }

           System.out.println(temp.node.data+" ");

           if(temp.node.left!=null){
               q.add(new lvNode(temp.node.left, temp.level+1));

           }

           if(temp.node.right!=null){
               q.add(new lvNode(temp.node.right,temp.level+1));
           }

       }


   }












  //----------------------------



  public static void levelOrderLineWise(Node node) {
    System.out.println("level order line wise");
    Queue<Node> q=new LinkedList<>();
    q.add(node);

    while(q.size()>0 ){

      int len=q.size();
      for(int i=0;i<len;i++){

      Node temp=q.remove();

      

      System.out.print(temp.data+" ");

      if(temp.left!=null){
        q.add(temp.left);
      }


      if(temp.right!=null){
        q.add(temp.right);
      }

       }

        System.out.println();
  
    }




    }

    public static void levelOrder(Node node) {
      System.out.println("level order");
      Queue<Node> q=new LinkedList<>();
      q.add(node);
  
      while(q.size()>0 ){
  
     
  
        Node temp=q.remove();
  
        
  
        System.out.print(temp.data+" ");
  
        if(temp.left!=null){
          q.add(temp.left);
        }
  
  
        if(temp.right!=null){
          q.add(temp.right);
        }
  
      
  

  
  
  
  
      }
  


    



  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Integer[] arr = new Integer[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      if (values[i].equals("n") == false) {
        arr[i] = Integer.parseInt(values[i]);
      } else {
        arr[i] = null;
      }
    }

    Node root = construct(arr);
    levelOrder(root);
    levelOrderLineWise(root);
  }

}