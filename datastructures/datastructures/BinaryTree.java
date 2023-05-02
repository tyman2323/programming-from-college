import java.util.ArrayDeque;
class Node {
    int data;//Creating of the nodes for the tree
    Node left, right;
    public Node(int item)
    {
        data = item;
        left = right = null;
    }
}
public class BinaryTree {
ArrayDeque<Integer> sam = new ArrayDeque<Integer>();//This will create our queue
    Node root;
    public BinaryTree(){
      root=null;
    }
        public static void main(String args[]){
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);//This will add our numbers for our nodes using lefts and rights
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
       tree.first();
    }
    public void first(){
        int d = depth(root);
        int x;
        for (x = 1; x <= d; x++)//This will go through all items in the depth
            second(root, x);
    }
    public int depth(Node root){
        if (root == null){
        //Test case for empty tree
            return 0;
            }
        else {
            int lleft = depth(root.left);
            int rright = depth(root.right);
            if (lleft > rright){
                return (lleft + 1);
            }
            else{
                return (rright + 1);
           }
        }
    }
    public void second(Node root, int x){
        if (root == null){
            return;
        }
        if (x== 1){
            sam.add(root.data);
       }
        else if (x > 1) {
            second(root.left,x-1);
            second(root.right,x - 1);//This will navigate through all nodes within its depth
        }
    }
}