import java.util.Scanner;
public class LinkedList {
    Node head; // head of list
 
    
    public class Node {
        int data;//Refrences for the class
        Node next;
        Node(int d){
         data = d;
        }
    }
    
        public static void main(String[] args){
      LinkedList list = new LinkedList();
      list = list.add(list, 50);
      list = list.add(list, 11);
      list = list.add(list, 33);
      list = list.add(list, 21);
      list = list.add(list, 40);
      list = list.add(list, 71);
      Scanner input = new Scanner(System.in);
      System.out.println("Pick the index youd like to delete");
      int n = input.nextInt();
      while(n<0){//This will check and make sure the index for deletion is greater than -1
         System.out.println("Too small try again");
         n = input.nextInt();
      }
      Node current = list.head;
      if(current.next == null||current == null){
         System.out.println("null");//Test case fir if there is only one node or if the head is null
      }
      
      list.delete(list,n);
      list.print(list);
      
}
    public LinkedList add(LinkedList list, int data){
      Node newnode = new Node(data);
      newnode.next = null;//This method will populate the Linked List
      if(list.head == null){
         list.head = newnode;
      }
      else{
      Node last = list.head;//Populates by next adhering to O(n)
      while(last.next!=null){
         last = last.next;
      }
      last.next = newnode;
      }
      return list;
    }
    public static void print(LinkedList list){
      Node current = list.head;
      while(current !=null){//Method will print out the linked list till null is reached
         System.out.print(current.data+ " ");
         current = current.next;
      }
    }
    public LinkedList delete(LinkedList list, int n){
      Node current = list.head, prev = null;
      n = 5-n;
      if(n == 0 && current!=null){
         list.head = current.next;//test case for if we want to delete the first node
         return list;
      } 
      int counter = 0;
      while(current!= null){
         if(counter == n){
            prev.next = current.next;//will move to the position from head to null until the position of deletion is reached
            break;
         }
         else{
            prev = current;
            current = current.next;
            counter++;
         }
      }
      if(current == null){
         System.out.println("You chose a number that was well byond the size of the list");
         System.exit(0);//Test case for if the number for deletion is greater than the length
      }
      return list;
    }
   
      

}