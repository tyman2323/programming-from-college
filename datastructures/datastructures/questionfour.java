import java.util.ArrayList;
class Node{
   int data;
   Node left;
   Node right;
   public Node(int item){
      data =  item;
      left = null;
      right = null;
   }
}
public class questionfour{
   Node root;
   public questionfour(){
      root = null;
   }
   public static void main(String[] args){
      ArrayList<Integer> quack = new ArrayList<Integer>();
      questionfour tree = new questionfour();
      tree.root =new Node(4);
      tree.root.left = new Node(2);
      tree.root.right = new Node(6);
      tree.root.left.left = new Node(1);
      tree.root.left.right = new Node(3);
      tree.root.right.left = new Node(5);
      tree.root.right.right = new Node(7);
      tree.chalk(tree.root,quack);
      System.out.println("It was a great time in Data Structures, thank you Professor for all you've taught me. Have a great summer and goodluck for the future! You TAs deserve it!");
   }
   public ArrayList<Integer> chalk(Node root, ArrayList<Integer> quack){
      if(root == null){
         return quack;
      }
      
      chalk(root.left,quack);
      quack.add(root.data);
      if(quack.size()==3){
         crayon(root,quack);
      }
      
      chalk(root.right,quack);
      return quack;
   }
   public Node crayon(Node root,ArrayList<Integer> quack){
      System.out.println(root.data);
      return root;
   }
}
