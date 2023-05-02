#include <stdio.h>
#include <stdlib.h>
#include <string.h>
void evenword(char word[]){
   int lefttotal = 0;
   int righttotal = 0;
   for(int x = 0; x<strlen(word)/2;x++){
      lefttotal+=word[x];  
   }
   printf("\n");
   for(int x = (strlen(word)/2); x<strlen(word);x++){
      righttotal+=word[x];
   }
   if(righttotal == lefttotal){
      printf("This word is a palindrome");
   }
   else{
      printf("This word is not a palindrom");
   }
}
void oddword(char word[]){
   int lefttotal = 0;
   int righttotal = 0;
   for(int x = 0; x<strlen(word)/2;x++){
      lefttotal+=word[x];
      
   }
   printf("\n");
   for(int x = (strlen(word)/2)+1; x<strlen(word);x++){
      righttotal+=word[x];
   }
   if(righttotal == lefttotal){
      printf("This word is a palindrome");
   }
   else{
      printf("This word is not a palindrom");
   }
}
int main(){
   printf("What is the word: ");
   char word[50];
   scanf("%s",word);
   if(strlen(word)%2==0){
      evenword(word);
   }
   else{
      oddword(word);
   }
}