#include <stdio.h>
void swap(double* one, double* two){
	double temp = *one;
	*one = *two;
	*two = temp;
}
void flip(double arr[], int start, int end)
{
	double temp;
	while (start < end)
	{
      swap(&arr[start],&arr[end]);//flips the array when the input is d
		start++;
		end--;
	}
}
void sort_numeric(double arr[], int rep){//Time complexity of On^ but it does not have a major factor becuase of the size of the array
	for (int x = 0; x < rep - 1; x++){
		for (int xx = 0; xx < rep - x - 1; xx++){
			if (arr[xx] > arr[xx + 1]){
				swap(&arr[xx], &arr[xx + 1]);
         }
      }
   }
}
int main(){
	double arr[] = {10,0.25,-2342,12123,3.145435,6,6,5.999,-2,-5,-109.56};
	int rep = sizeof(arr) / sizeof(arr[0]);//gets the size of the array 
   char input;
   printf("a to ascend d to descend ");
   scanf("%c", &input);
   if(input ==97||input == 65){;//uses the ascii table to know if a or b case sensitive
      int rep = sizeof(arr) / sizeof(arr[0]);
      sort_numeric(arr,rep);
   }
   else if(input==100||input == 68){;//uses the ascii table to know if a or b case sensitive
   sort_numeric(arr,rep);
   flip(arr,0,rep-1);
   }
   
   else{
      printf("Invalid input");//If the input is something else it will say its invalid
      return 0;
   }
	for (int x = 0; x < rep; x++){
		printf("%lf ", arr[x]);//prints out the sorted array
      }
	
}


