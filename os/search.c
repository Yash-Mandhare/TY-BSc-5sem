/* Write a C program that behaves like a shell which displays the command prompt 'myshellS'. It accepts the command, tokenize the command line and execute it by creating the child process. Also implement the additional command 'search' as

myshells search f filename pattern: It will search the first occurrence of pattern in the given file
myshells search a filename pattern: It will search all the occurrence of pattern in the given file
myshells search c filename pattern: It will count the number of occurrence of pattern in the given file */

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <sys/wait.h>
#include <fcntl.h>

void separate_tokens(char *cmd, char *tok[]) {
    int i = 0;
    char *p;

    p = strtok(cmd, " ");
    while (p != NULL) {
        tok[i++] = p;
        p = strtok(NULL, " ");
    }
    tok[i] = NULL;
}

void search(char param, char *filename, char *pattern) {
    int fd = open(filename, O_RDONLY);
    if (fd == -1) {
        printf("File %s not found\n", filename);
        return;
    }

    char c;
    char buffer[1024];
    int bytesRead, count = 0;
    int patternLength = strlen(pattern);
    int patternFound = 0;

    while ((bytesRead = read(fd, buffer, sizeof(buffer))) > 0) {
        int i;
        for (i = 0; i < bytesRead; i++) {
            c = buffer[i];
            if (c == pattern[patternFound]) {
                patternFound++;
                if (patternFound == patternLength) {
                    if (param == 'f') {
                        printf("Pattern found in %s\n", filename);
                        close(fd);
                        return;
                    } else if (param == 'a') {
                        printf("Pattern found at position %d\n", i - patternLength + 1);
                        patternFound = 0;
                    } else if (param == 'c') {
                        count++;
                        patternFound = 0;
                    }
                }
            } else {
                patternFound = 0;
            }
        }
    }

    if (param == 'c') {
        printf("Pattern count in %s: %d\n", filename, count);
    }

    close(fd);
}

int main() 
{ 	
	char cmd[80],*args[10]; 	
	int pid; 	 	
	system("clear");	 	
	do 	
	{ 		
		printf("\nMyShell$ "); 		
		fgets(cmd,80,stdin); 		
		cmd[strlen(cmd)-1]='\0'; 		
		separate_tokens(cmd,args); 		
		if(strcmp(args[0],"search")==0) 			
			search(args[1][0], args[2], args[3]);	
		else 		
		{ 			
			pid = fork(); 			
			if(pid > 0) 				
			wait(0); 			
			else if(execvp(args[0],args)==-1) 				
				printf("\n Command %s not found\n",args[0]); 		
		} 	
	}while(1); 	
	return 0; 
}
