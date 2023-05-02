#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/mman.h>
#include <fcntl.h>
int main(int argc, char *argv[])
{
pid_t pid, pid1;
int n;

	if (argc == 1) {
		fprintf(stderr,"Usage: ./a.out <starting value>\n");

		return -1;
	}

	n = atoi(argv[1]);

	/* add your code below, following the code structure of Figure 3.34 (page 152) */
	const int SIZE = 4096;
	const char *name = "OS";
	void *ptr;
	int shm_fd;
	shm_fd = shm_open(name,O_CREAT|O_RDWR,0666);
	ftruncate(shm_fd,SIZE);
	void* sm = mmap(0,SIZE,PROT_WRITE,MAP_SHARED,shm_fd,0);
		pid = fork();
	        sm = pid;
	if(pid<0){
	  fprintf(stderr,"Fork Failed");
	  return 1;
	}
	else if (pid == 0){
	  
	  printf("child: pid = %d\n", sm);
	  sm = getpid();
	  printf("child: pid1 = %d\n", sm);
	  printf("%d, ",n);
	  while(n != 1){
	    if(n % 2 == 0){
	      n = n/2;
	    }
	    else{
	      n = n * 3;
	      n = n + 1;
	    }
	    printf("%d, ",n);
	  }
	  
	}
	else{
	  
	  printf("parent: pid = %d\n",sm);
	  sm = getpid();
	  printf("parent: pid1 = %d\n",sm);
	  wait(NULL);
	}
	return 0;
}

