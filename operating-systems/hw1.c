#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>

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
	
	pid = fork();
	if(pid<0){
	  fprintf(stderr,"Fork Failed");
	  return 1;
	}
	else if (pid == 0){
	  pid1 = getpid();
	  printf("child: pid = %d\n", pid);
	  printf("child: pid1 = %d\n", pid1);
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
	  pid1 = getpid();
	  printf("parent: pid = %d\n",pid);
	  printf("parent: pid1 = %d\n",pid1);
	  wait(NULL);
	}
	return 0;
}
