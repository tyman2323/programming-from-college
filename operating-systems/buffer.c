
#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <semaphore.h>

#define TRUE 1
typedef int buffer_item;
#define BUFFER_SIZE 8

buffer_item START_NUMBER;

int insert_item(buffer_item item);

int remove_item(buffer_item *item);


buffer_item buffer[BUFFER_SIZE];

pthread_mutex_t mutex;
sem_t empty;
sem_t full;

int insertPointer = 0, removePointer = 0;

void *producer(void *param);
void *consumer(void *param);

int insert_item(buffer_item item)
{
    /* Implementation of the insert_item() function */
        sem_wait(&empty);
        pthread_mutex_lock(&mutex);
        buffer[insertPointer] = item;
        insertPointer = (insertPointer + 1) % BUFFER_SIZE;
        pthread_mutex_unlock(&mutex);
        sem_post(&full);
	return 0;
}


int remove_item(buffer_item *item)
{
	/* Implementation of the remove_item function */
        sem_wait(&full);
        pthread_mutex_lock(&mutex);
        *item = buffer[removePointer];
        buffer[removePointer] = 0;
        removePointer = (removePointer + 1) % BUFFER_SIZE;
        pthread_mutex_unlock(&mutex);
        sem_post(&empty);
	return 0;
}


int main(int argc, char *argv[])
{
/* 1. Get command line arguments argv[1],argv[2],argv[3],argv[4] */
/* 2. Initialize buffer */
/* 3. Create producer thread(s) */
/* 4. Create consumer thread(s) */
/* 5. Sleep */
/* 6. Exit */

	int sleepTime, producerThreads, consumerThreads;
	int i, j;

	if(argc != 5)
	{
		fprintf(stderr, "Useage: <sleep time> <producer threads> <consumer threads> <start number>\n");
		return -1;
	}

	sleepTime = atoi(argv[1]);
	producerThreads = atoi(argv[2]);
	consumerThreads = atoi(argv[3]);
	START_NUMBER = atoi(argv[4]);

	/* Initialize the synchronization tools */
        pthread_mutex_init(&mutex, NULL);
        sem_init(&empty, 0, BUFFER_SIZE);
        sem_init(&full, 0, 0);
        srand(time(0));
	/* Create the producer and consumer threads */
        pthread_t ptid[producerThreads];
        pthread_t ctid[consumerThreads];
        pthread_attr_t attr;
        for (i = 0; i < producerThreads; i++) {
        int *ptid_arg = malloc(sizeof(*ptid_arg));
        *ptid_arg = i;
        pthread_create(&ptid[i], &attr, producer, ptid_arg);
        }
        for (j = 0; j < consumerThreads; j++) {
        int *ctid_arg = malloc(sizeof(*ctid_arg));
        *ctid_arg = i;
        pthread_create(&ctid[j], &attr, consumer, ctid_arg);
         }
	/* Sleep for user specified time */
	sleep(sleepTime);
	return 0;
}

void *producer(void *param)
{
	/* Implementation of the producer thread -- refer to Figure 5.26 on page 256 */
    buffer_item thing;
    int r;
    int *id = (int*)param;
    int ttid = *id;
    while (TRUE){
        r = rand() % BUFFER_SIZE;
        sleep(r);
        thing = START_NUMBER;
        if (insert_item(START_NUMBER)){
            fprintf(stderr, "Error");
        }
        else{
        printf("Producer %d produced %d \n", ttid, thing);
        START_NUMBER++;
        }
    }
}

void *consumer(void *param)
{
	/* Implementation of the consumer thread -- refer to Figure 5.26 on page 256 */
    buffer_item thing;
    int r;
    int *id = (int*)param;
    int ttid = *id;
    while(TRUE){
      r = rand() % BUFFER_SIZE;
        sleep(r);

        if (remove_item(&thing)){
            fprintf(stderr, "Error Consuming");
        }
        else{ 
            printf("Consumer %d consumed %d \n", ttid, thing);
        }
    }
}

//gcc -pthread -o buffer buffer.c
