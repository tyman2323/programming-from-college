import java.util.Scanner;
class PersonalizedHelloWorld {
  public static void main(String[] args) {
  Scanner input = new Scanner(System.in);
  String response ="";
  while(response.length() == 0){
  System.out.println("What is your first and last name");
  response = input.nextLine();
  }
  System.out.println("Hello," + response);
  }
}