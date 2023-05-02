#include <stdio.h>
#include <ctype.h>
#include <stdbool.h>
int problem5lines(FILE *fpointer){
   int curr = 1;
   char c;
   do{
      c = fgetc(fpointer);//goes untill a new line character is found and then updates the counter
      if(c == 10){
         curr++;
      }
   } 
   while(c!=EOF);
   return curr;
}