/**
 * A skeleton for counting & checking wildfire fuel data
 */

#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>

#define NUMBER_OF_FUELCOUNTING_THREADS 	10
#define NUMBER_OF_DATAVALIDATION_THREADS 	10
#define NUMBER_OF_FUELTYPE 13
#define GRID_SIZE 		200  // it is a 200x200 grid

int fueldata[GRID_SIZE][GRID_SIZE] = {0};

int fuelCountResult[NUMBER_OF_FUELCOUNTING_THREADS][NUMBER_OF_FUELTYPE] = {0};
int datavalidationresult[NUMBER_OF_DATAVALIDATION_THREADS] = {0};

/* data structure for passing data to threads */
typedef struct
{
    int threadnumber;
    int startRow_or_Column;
    int endRow_or_Column;
} parameters;

void *fueltypes(void *params)
{
    parameters *p = (parameters *) params;
    int start = p->startRow_or_Column;
    int end = p->endRow_or_Column;
    int threadnum = p->threadnumber;

    for (int i = start; i < end; i++)
    {
        for (int j = 0; j < GRID_SIZE; j++)
        {
            int fueltype = fueldata[i][j];
            fuelCountResult[threadnum][fueltype]++;
        }
    }

    pthread_exit(NULL);
}

void *validata(void *params)
{
    parameters *p = (parameters *) params;
    int start = p->startRow_or_Column;
    int end = p->endRow_or_Column;
    int threadnum = p->threadnumber;

    for (int i = start; i < end; i++)
    {
        for (int j = 0; j < GRID_SIZE; j++)
        {
            if (fueldata[i][j] > NUMBER_OF_FUELTYPE)
            {
                datavalidationresult[threadnum] = 1;
                pthread_exit(NULL);
            }
        }
    }

    pthread_exit(NULL);
}

int main(int argc, char *argv[])
{
    // get fuel data from a txt file, which needs to be input from command line
    char filename[100];
    printf("Please enter your filename:\n");
    scanf("%s", filename);

    FILE *myFile;
    myFile = fopen(filename, "r");

    // read file into array
    if (myFile == NULL)
    {
        printf("Error Reading File\n");
        exit(0);
    }

    for (int i = 0; i < GRID_SIZE; i++)
    {
        for (int j = 0; j < GRID_SIZE; j++)
        {
            fscanf(myFile, "%d ", &fueldata[i][j]);
        }
    }

    fclose(myFile);

    pthread_t workers[NUMBER_OF_FUELCOUNTING_THREADS + NUMBER_OF_DATAVALIDATION_THREADS];
    parameters threadparam[NUMBER_OF_FUELCOUNTING_THREADS + NUMBER_OF_DATAVALIDATION_THREADS];

    // create 10 threads for counting the occurrence of fuel types
    int rows_per_thread = GRID_SIZE / NUMBER_OF_FUELCOUNTING_THREADS;
    for (int i = 0; i < NUMBER_OF_FUELCOUNTING_THREADS; i++)
    {
        threadparam[i].threadnumber = i;
        threadparam[i].startRow_or_Column = i * rows_per_thread;
        threadparam[i].endRow_or_Column = (i + 1) * rows_per_thread;
        pthread_create(&workers[i], NULL, fueltypes, (void *) &threadparam[i]);
    }

    // create 10 threads for checking if there exist invalid data
    int columnthread = GRID_SIZE / NUMBER_OF_DATAVALIDATION_THREADS;
    for (int i = 0; i < NUMBER_OF_DATAVALIDATION_THREADS; i++)
    {
        threadparam[NUMBER_OF_FUELCOUNTING_THREADS + i].threadnumber = i;
        threadparam[NUMBER_OF_FUELCOUNTING_THREADS + i].startRow_or_Column = i * columnthread;
        threadparam[NUMBER_OF_FUELCOUNTING_THREADS + i].endRow_or_Column = (i + 1) * columnthread;
        pthread_create(&workers[NUMBER_OF_FUELCOUNTING_THREADS + i], NULL, validata , (void *) &threadparam[NUMBER_OF_FUELCOUNTING_THREADS + i]);
    }

    // wait for the threads to exit and combine the result and print
    for (int i = 0; i < NUMBER_OF_FUELCOUNTING_THREADS + NUMBER_OF_DATAVALIDATION_THREADS; i++)
    {
        pthread_join(workers[i], NULL);
    }

    // print the final results
    printf("Fuel count result:\n");
    for (int i = 0; i < NUMBER_OF_FUELCOUNTING_THREADS; i++)
    {
        printf("Thread %d: ", i);
        for (int j = 0; j < NUMBER_OF_FUELTYPE; j++)
        {
            printf("%d ", fuelCountResult[i][j]);
        }
        printf("\n");
    }

    printf("Data validation result:\n");
    for (int i = 0; i < NUMBER_OF_DATAVALIDATION_THREADS; i++)
    {
        if (datavalidationresult[i] == 1)
        {
            printf("Thread second set: %d ,,Invalid data exists.\n",i);
            //break;
        }
    }
    return 0;
}
