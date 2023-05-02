import java.util.Scanner;
public class tasktwo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int total = 0;
        int count = 0;
        System.out.println("Please input your numbers, use the enter key to seperate numbers. Use -1 to exit.");
/*
        System.out.println("Please input your numbers, use the enter key to seperate numbers. Use -1 to exit.");
        while (input.nextInt() != -1) {
            int view = input.nextInt();
            total = total + view;
            count++;
        }
        double average = total / count;
        System.out.println("Your average is: " + average);

*/
        for(int x = 0; x>-1;x++){
            int number = input.nextInt();
            if(number!= -1){
                total = total +number;
                count++;
            }
            else {
                double average = total/count;
                System.out.println("The average is: " +average);
            }
        }
    }
}