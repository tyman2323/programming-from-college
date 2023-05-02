#include <stdio.h>
#include <ctype.h>
#include <stdbool.h>
#include <stdlib.h>
int problem5words(FILE *fpointer){
   int c;
   int wordcount = 0;
   bool whitespace = true;
   while(!feof(fpointer)){
      c = fgetc(fpointer);
      if(whitespace && !isspace(c)){//Goes through and finds when a white space is there and to know a word has ended, and a new character afterwards to know a new word is starting. This will update the word counter
         wordcount++;
         whitespace = false;
      }
      else if(!whitespace && isspace(c)){
         whitespace = true;
      }
   }
   return wordcount;
   
}