#include <stdio.h>
#include <ctype.h>
#include <stdbool.h>
#include <stdlib.h>
int problem6char(FILE *fpointer){
   char c;
   int charcount = 0;
   while((c = fgetc(fpointer)) !=EOF){
         charcount++;
         if(c == 10){
            charcount = charcount-1;//No new lines counted
         }
   }
   return charcount;
   
}