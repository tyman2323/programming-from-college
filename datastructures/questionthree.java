public class questionthree{
  Node head;   
  public class Node {
        int data;
        Node next;
        Node(int d){
         data = d;
        }
    }
   public static void main(String[] args){
      questionthree list = new questionthree();
      list = list.add(list,2);
      list = list.add(list,3);
      list = list.add(list,1);
      list = list.add(list,7);
      list = list.add(list,5);
      list = list.add(list,18);
      int thingtodelete = list.length(list)-3;
      list.delete(list, thingtodelete);
      list.print(list);
      System.out.println();
      System.out.println("But the beauty in programming is that their is always a solution to the puzzle, you just need to change your way of thinking and keep on trying.");
      System.out.println("In many ways, the lessons we learn in programming can be lessons we learn in life.");
   }
   public questionthree add(questionthree list, int data){
      Node newnode = new Node(data);
      newnode.next = null;
      if(list.head == null){
         list.head = newnode;
      }
      else{
      Node last = list.head;
      while(last.next!=null){
         last = last.next;
      }
      last.next = newnode;
      }
      return list;
   }
   public int length(questionthree list){
      Node current = list.head;
      int counter = 0;
      while(current !=null){
         counter++;
         current = current.next;
      }
      if(counter<3){
         System.out.println("Sorry this wont work because the list is too small. The minimum length has to be 3");
         System.exit(0);
      }
      return counter;
   }
   public questionthree delete(questionthree list, int dathing){
      Node current = list.head;
      Node prev = null;
      int counter = 0;
      while(current!=null){
         if(counter == dathing){
            prev.next = current.next;
            break;
         }
         else{
            prev = current;
            current = current.next;
            counter++;
         }
      }
      return list;
   }
   public void print(questionthree list){
      Node current = list.head;
      while(current!=null){
         System.out.print(" " + current.data);
         current = current.next;
      }
   }
}