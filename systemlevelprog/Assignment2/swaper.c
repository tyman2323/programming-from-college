#include <stdio.h>
#include <stdlib.h>
int main(){
   char c[] = "test";
   char d[] = "exam";
   int len = sizeof(c);
   printf("Before: %s   %s\n",c,d);
   for(int x =0; x<len-1;x++){
       int a = c[x];
       int b = d[x];
       a = a + b;
       b = a - b;
       a = a - b;
       c[x] = a;
       d[x] = b;
   }
   printf("After:%s   %s\n",c,d);
   
   int aa = 1;
   int bb = 2;
   printf("Before: %d  %d\n", aa,bb);
   aa = aa + bb; 
   bb = aa - bb; 
   aa = aa - bb;
   printf("After: %d  %d", aa,bb);
   return 0;
}