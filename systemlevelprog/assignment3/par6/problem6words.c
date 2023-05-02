#include <stdio.h>
#include <ctype.h>
#include <stdbool.h>
#include <stdlib.h>
int problem6words(FILE *fpointer){
   int c;
   int wordcount = 0;
   bool whitespace = true;
   while(!feof(fpointer)){
      c = fgetc(fpointer);
      if(whitespace && !isspace(c)){
         wordcount++;
         whitespace = false;
      }
      else if(!whitespace && isspace(c)){
         whitespace = true;
      }
   }
   return wordcount;
   
}