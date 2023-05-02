#include <stdio.h>
#include <ctype.h>
#include <stdbool.h>
int problem6lines(FILE *fpointer){
   int curr = 1;
   char c;
   do{
      c = fgetc(fpointer);
      if(c == 10){
         curr++;
      }
   } 
   while(c!=EOF);
   return curr;
}