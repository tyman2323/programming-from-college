#include <stdio.h>
#include <ctype.h>
void main(){
   printf("Beep boop bap\n");
   int a;
   int b;
   printf("Put in an input");
   scanf("%d %d",&a,&b);
   int c = a + b;
   printf("%d + %d = %d\n",a,b,c);
   //int d;
   //printf("Put in an input");
   //scanf("%d %d %d",&a,&b,&c);
   if(c==0){
      printf("\n%i is not an integer",c);
   }
   printf("\n Length of the array?");
   int v;
   scanf("%i",&v);
   printf("\n Start of the array?");
   int z;
   scanf("%i",&z);
   for(int x = 0; x<v; x++){
      printf("\n %i",z);
      z++;
   }
}