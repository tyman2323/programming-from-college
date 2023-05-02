#include <stdio.h>
#include <stdlib.h>

double* arr;
void reverser( int start, int end)
{
    double temp;
    while (start < end)
    {
        temp = arr[start];//Uses a temp variable and switches out between start an end for a O logn
        arr[start] = arr[end];
        arr[end] = temp;
        start++;
        end--;
    }
}
int compare(void const *a,void const *b) {//Needed for the qsort method
    return (*(double*)a - *(double*)b);
}
int main() {
    printf("What is the number used to quit?\n");
    double quit;//Assigns a user inputted quit number to know when the array will stop having more numbers
    scanf_s("%lf", &quit);
    printf("%lf when inputed will stop making the array\n", quit);
    int size = 2;
    arr = calloc(size, sizeof(double));// allocated the pointer to become an array 
    double input = 0;
    int end = 0;
    int x = 0;
    while (x < size) {
        scanf_s("%lf", &input);
        if (input == quit) {
            break;//Will keep adding new numbers while the quit number hasnt been inputted
        }
        arr[x] = input;
        x++;
        if (x == size) {
            size++;//Reallocated memory by one to increase for the array size
            arr = realloc(arr, size * sizeof(double));
        }
    }
    size--;
    printf("\n");
    char inputt;
    printf("Press a for ascend and d for descend: ");
    scanf_s(" %c", &inputt);
    qsort(arr, size, sizeof(double), compare);//Uses the qsort algorithm which has a O of nlogn
    if (inputt == 'd' || inputt == 'D') {
        reverser(0, size - 1);//flips it to get into descending order

    }
    
    
    
    
    for (int i = 0; i < size; i++) {
        printf("%lf ", arr[i]);
    }
    free(arr);
}