import java.util.ArrayDeque;
      class Node{
      int data;
      Node left,right;
      public Node(int item){
         data = item;
         left = null;
         right = null;
      }
   }
public class tree{
      Node root;
   tree(int l){
      root = new Node(l);
   }
   public tree(){
      root = null;
   }
   public static void main(String[] args){
      
      tree call = new tree();
      tree t = new tree();
      t.root = new Node(4);
      t.root.left = new Node(2);
      t.root.right = new Node(6);
      t.root.left.left = new Node(1);
      t.root.left.right = new Node(3);
      t.root.right.left = new Node(5);
      t.root.right.right = new Node(7);
      
      t.firststep();
   }
   public void firststep(){
      int d = depth(root);
      for (int x = 1; x<= d; x++){
         secondstep(root,x);
         
      }
   }
   public int depth(Node root){
      if(root == null){//This will be our test case to check if the tree is empty
         System.out.println("Empty tree");
         System.exit(0);
      }
         int leftd = depth(root.left);
         int rightd = depth(root.right);
         if(leftd > rightd){
            return (leftd+1);
         }
         else{
            return (rightd+1);
         }
      
      
   }
   public void secondstep(Node root, int x){
      
      if(x == 1){
            sam.add(root.data);
         }
         else if(x>1){
         
         
            secondstep(root.left, x-1);
            secondstep(root.right,x-1);
         }
   }
   
}