#include <stdio.h>
#include <ctype.h>
#include <stdbool.h>
#include <stdlib.h>

void appender(int a, int b, int c){
      FILE *pencil;//Updates the text file with lines, chars, and words
      pencil = fopen("result.txt","a");
   fprintf(pencil,"%d-----%d------%d\n",a,b,c);
   fclose(pencil);
}
int issame(FILE *fpointer,FILE *same){
  char sing[150];
  int z = getc(fpointer);//Compares the checker and test to see if they are the same
  int y = getc(same);
  while(z!=EOF&&y!=EOF){
    z = getc(fpointer);
    y = getc(same);
  }
  fclose(same);
  if(z==y){
      printf("File Has Not Changed\n");
      exit(0);
    }
} 
int main(){
   FILE *fpointer;//Creates a file pointer
   fpointer = fopen("test.txt","r");
  int a = problem5lines(fpointer);
  fclose(fpointer);
  fpointer = fopen("test.txt","r");
  int b = problem5words(fpointer);
  fclose(fpointer);
  fpointer = fopen("test.txt","r");
  int c = problem5char(fpointer);
  fclose(fpointer);
  fpointer = fopen("test.txt","r");
  FILE *same = fopen("checker.txt","r");//this text document will be used as a history, so if the previous is the same as the current then no output and no update to the result
  issame(fpointer,same);
  fclose(fpointer);
  fclose(same);
  FILE *file, *copy;
  file = fopen("test.txt","r");
  copy = fopen("checker.txt","w");
  char cc;
  while(cc = fgetc(file)!=EOF){
   fputc(c,copy);//Copies into the checker if they are different as a history
  }
  fclose(file);
  fclose(copy);
  appender(a,b,c);
  printf("%d and %d and also %d",a,b,c);
  return  0;
  
}