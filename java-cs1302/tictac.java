import java.util.Scanner;
public class tictac{
public static void main(String[] args){
Scanner input = new Scanner(System.in);
System.out.println("Welcome to play TicTacToe game! We have the following 3x3 empty board.");
char[][] board = { {'-','-','-','-','-','-','-','-','-','-','-','-','-'}, 
                   {':',' ','-',' ',':',' ','-',' ',':',' ','-',' ',':'},
                   {'-','-','-','-','-','-','-','-','-','-','-','-','-'}, 
                   {':',' ','-',' ',':',' ','-',' ',':',' ','-',' ',':'},
                   {'-','-','-','-','-','-','-','-','-','-','-','-','-'}, 
                   {':',' ','-',' ',':',' ','-',' ',':',' ','-',' ',':'},
                   {'-','-','-','-','-','-','-','-','-','-','-','-','-'} };
boolean play = true;
while ( play = true){
for(int x = 0; x<board.length;x++){
System.out.println(" ");
for (int xx = 0; xx<board[x].length;xx++){
System.out.print(board[x][xx]);
}
}
System.out.println("");
System.out.println("What is the row: ");
int row = input.nextInt();
System.out.println("What is the column: ");
int column = input.nextInt();
if(row == 0){
if(column == 0){
board[1][2] = 'x';
}
else if(column == 1){
board[1][6] = 'x';
}
else if(column == 2){
board[1][10] = 'x';
}
}
else if(row ==1){
if(column == 0){
board[3][2] = 'x';
}
else if(column == 1){
board[3][6] = 'x';
}
else if(column == 2){
board[3][10] = 'x';
}
}
else if (row ==2){
if(column == 0){
board[5][2] = 'x';
}
else if(column == 1){
board[5][6] = 'x';
}
else if(column == 2){
board[5][10] = 'x';
}
}
//checker
for( int x = 0; x<board.length;x++){
System.out.println(" ");
for (int xx = 0; xx<board[x].length;xx++){
System.out.print(board[x][xx]);
}
}
System.out.println(" ");
System.out.println("What is the row: ");
 row = input.nextInt();
 System.out.println("What is the column: ");
 column = input.nextInt();
if(row == 0){
if(column == 0){
board[1][2] = 'o';
}
else if(column == 1){
board[1][6] = 'o';
}
else if(column == 2){
board[1][10] = 'o';
}
}
else if(row ==1){
if(column == 0){
board[3][2] = 'o';
}
else if(column == 1){
board[3][6] = 'o';
}
else if(column == 2){
board[3][10] = 'o';
}
}
else if (row ==2){
if(column == 0){
board[5][2] = 'o';
}
else if(column == 1){
board[5][6] = 'o';
}
else if(column == 2){
board[5][10] = 'o';
}
}
for(int x = 0; x<board.length;x++){
System.out.println(" ");
for (int xx = 0; xx<board[x].length;xx++){
System.out.print(board[x][xx]);
}
}

// checker
}
}
}

