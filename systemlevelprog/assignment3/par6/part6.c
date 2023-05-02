#include <stdio.h>
#include <ctype.h>
#include <stdbool.h>
#include <stdlib.h>
#include "problem6lines.h"
#include "problem6words.h"
#include "problem6char.h"
/////////////////////ALL COMMENTS ARE SAME AS PART 5 THE ONLY DIFFERENCE IS THAT IT NOW USES THOSE FUNCTIONS AS HEADERS////////////////////////
void appender(int a, int b, int c){
      FILE *pencil;
      pencil = fopen("result.txt","a");
   fprintf(pencil,"%d-----%d------%d\n",a,b,c);
   fclose(pencil);
}
int issame(FILE *fpointer,FILE *same){
  char sing[150];
  int z = getc(fpointer);
  int y = getc(same);
  while(z!=EOF&&y!=EOF){
    z = getc(fpointer);
    y = getc(same);
  }
  fclose(same);
  if(z==y){
      printf("FILES ARE THE SAME\n");
      exit(0);
    }
}
// if not same then copy test into checker>update the result list
//if same end everything 
int main(){
   FILE *fpointer;
   fpointer = fopen("test.txt","r");
  int a = problem6lines(fpointer);
  fclose(fpointer);
  fpointer = fopen("test.txt","r");
  int b = problem6words(fpointer);
  fclose(fpointer);
  fpointer = fopen("test.txt","r");
  int c = problem6char(fpointer);
  fclose(fpointer);
  fpointer = fopen("test.txt","r");
  FILE *same = fopen("checker.txt","r");
  issame(fpointer,same);
  fclose(fpointer);
  fclose(same);
  FILE *file, *copy;
  file = fopen("test.txt","r");
  copy = fopen("checker.txt","w");
  char cc;
  while(cc = fgetc(file)!=EOF){
   fputc(c,copy);
  }
  fclose(file);
  fclose(copy);
  appender(a,b,c);
  printf("%d and %d and also %d",a,b,c);
  return  0;
  
}