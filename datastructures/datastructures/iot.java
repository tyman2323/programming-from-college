import java.util.ArrayList;
class Node{
   int data;//This will create the Node class for our tree
   Node left, right;
   public Node(int item){
      data = item;
      left = right = null;
   }
}
public class iot{
   Node root;
   public iot(){
      root = null;
   }
   public static void main(String[] args){
      iot tree = new iot();
      ArrayList<Integer> walter = new ArrayList<Integer>();//We will use an arraylist to make it easier for us to compare values
      tree.root = new Node(4);
      tree.root.left = new Node(2);
      tree.root.right = new Node(6);
      tree.root.left.left = new Node(1);
      tree.root.left.right = new Node(3);
      tree.root.right.right = new Node(5);
      tree.root.right.left = new Node(7);
      Node current = tree.root;
      tree.first(tree.root,walter);
      System.out.println(walter);
   }
   public void first(Node root,ArrayList<Integer> walter){
      if(root == null){//base condition for the rescurse
         return;
      }
      first(root.left,walter);
      walter.add(root.data);//This will follow the in order 3 step, go left>process>go right
      makingsureitsgoinginacendingorder(walter);
      first(root.right,walter);
   }
   public void makingsureitsgoinginacendingorder(ArrayList<Integer> walter){//This method is a test case which will make sure the stack is going in ascending order, if not it is not a binary tree
      if(walter.size() == 1){//Method used as a test case for when there is only one int in the list
         System.out.println("BEEEEEEP");
      }
      else{
         int holly = walter.get(walter.size()-1);//This method will compare the newest and second newest value to check if the newer is greater than the older. If the older is greater then it is not in ascending order and cannot be a binary tree
         int flynn = walter.get(walter.size()-2);
         if(holly<flynn){
            System.out.println("This is not a Binary tree");
            System.exit(0);
         }
      }
      
   }
}