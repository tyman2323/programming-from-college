import java.util.ArrayDeque;
class Node{
   int data;
   Node left, right;
   public Node(int item){
      data = item;
      left = null;
      right = null;
   }
}
public class inorder{
   Node root;
   public inorder(){
      root = null;
   }
   public static void main(String[] args){
      inorder beep = new inorder();
      beep.root = new Node(1);
      beep.root.left = new Node(2);
      beep.root.right = new Node(3);
      beep.root.left.left = new Node(4);
      beep.root.left.right = new Node(5);
      beep.root.right.left = new Node(6);
      beep.root.right.right = new Node(7);
      Node current = beep.root;
      beep.first(current);
   }
   public void first(Node current){
      while(current.left!=null){
         current = current.left;
      }
      System.out.println(current);
      while(current.right!=null){
         current = current.right;
      }
      System.out.println(current);
   }
}
/**
The recurssive way:
public void InOrder(Node root){
   if(root.left!=null){
      InOrder(root.left);
   }
   System.out.print(root.value);
   if(root.right!=null){
      InOrder(root.right);
   }
}


*/