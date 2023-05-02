import java.util.ArrayList;
import java.util.TreeSet;
class Node{
int data;
Node left,right;
public Node(int item){
   data = item;
   left = right = null;
}
}

public class leftree{
   Node root;
   public leftree(){
      root = null;
   }
   public static void main(String[] args){
      leftree tree = new leftree();
      tree.root = new Node(10);
      tree.root.left = new Node(8);
      tree.root.left.left = new Node(7);
      tree.root.left.left.left = new Node(6);
      tree.root.left.left.left.left = new Node(5);
      Node current = tree.root;
      ArrayList<Node> pillow = new ArrayList<Node>();
      pillow.add(current);
      pillow.add(current.left);
      pillow.add(current.left.left);
      /*
      while(current !=null){
         pillow.add(current);
         current = tree.root.left;
      }*/
      tree.searcher(pillow,tree);
      System.out.println();
   }
   public void searcher(ArrayList<Node> pillow,leftree tree){
      int mid = pillow.size()/2;
      Node roo = pillow.get(mid);
      tree.root = roo;
      while(mid == 1){
         
      }
   }
}

/*
Solution:



*/