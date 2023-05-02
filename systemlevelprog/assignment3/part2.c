#include<stdio.h>
#include <string.h>

void sort_alphabetic(char *arr[], char input){
	if(input == 'A' || input == 'a'){//if a then ascend 
		for (int i = 0; i < 7 ; i++){
	        for (int j = i + 1; j < 8; j++){
	            if (strcasecmp(arr[i], arr[j]) > 0) {//uses the strcasecmp to see which one is of correct value to be in descending order
	            	char *temp = arr[i];
	            	arr[i] = arr[j];
	            	arr[j] = temp;
				}
	        }
	    }
	}
	else if(input == 'D' || input == 'd'){//if character is D/d sort descending		
      for (int i = 0; i < 7 ; i++){
	        for (int j = i + 1; j < 8; j++){
	            if (strcasecmp(arr[i], arr[j]) < 0) {//uses the strcasecmp to see which one is of correct value to be in descending order
	            	char *temp = arr[i];
	            	arr[i] = arr[j];
	            	arr[j] = temp;
				}
	        }
	    }
	}
	else{
		printf("Invalid");//test case for if the user put the wrong input
	}
	
}
int main(){
	char *arr[8] = {"Systems", "Programming", "Deep", "Learning", "Internet", "Things", "Robotics", "Course"};
	char input;
	//ask for how to sort it
	printf("a to ascend d to descend");
	scanf("%c", &input);
   //calls the function to begin sorting
	sort_alphabetic(arr, input);
	//print array after sort done
	printf("\nArray after sort : \n");
	for(int x=0;x<8;x++){
		printf("%s    ", arr[x]);
	}
}
