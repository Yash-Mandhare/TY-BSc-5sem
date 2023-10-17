/* Write a C program that behaves like a shell which displays the command prompt 'myshellS'. It accepts the command, tokenize the command line and execute it by creating the child process. Also implement the additional command 'search' as

myshells search f filename pattern: It will search the first occurrence of pattern in the given file
myshells search a filename pattern: It will search all the occurrence of pattern in the given file
myshells search c filename pattern: It will count the number of occurrence of pattern in the given file */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

#define MAX_INPUT_SIZE 1024
#define MAX_TOKENS 100

void search_pattern(const char *filename, const char *pattern, int find_first, int find_all, int count) {
    FILE *file = fopen(filename, "r");
    if (file == NULL) {
        perror("Error opening file");
        return;
    }

    char line[MAX_INPUT_SIZE];
    int line_number = 0;
    int pattern_count = 0;

    while (fgets(line, MAX_INPUT_SIZE, file) != NULL) {
        line_number++;
        if (strstr(line, pattern) != NULL) {
            pattern_count++;
            if (find_first) {
                printf("%s: Line %d: %s", filename, line_number, line);
                break;
            } else if (find_all) {
                printf("%s: Line %d: %s", filename, line_number, line);
            }
        }
    }

    if (count) {
        printf("Pattern '%s' found %d times in %s.\n", pattern, pattern_count, filename);
    }

    fclose(file);
}

int main() {
    char input[MAX_INPUT_SIZE];
    char *tokens[MAX_TOKENS];
    const char *prompt = "myshell$ ";
    
    while (1) {
        printf("%s", prompt);
        if (fgets(input, MAX_INPUT_SIZE, stdin) == NULL) {
            perror("Error reading input");
            break;
        }

        // Tokenize the input
        int token_count = 0;
        tokens[token_count] = strtok(input, " \t\n");
        while (tokens[token_count] != NULL) {
            token_count++;
            tokens[token_count] = strtok(NULL, " \t\n");
        }

        if (token_count == 0) {
            continue; // Empty input line
        }

        if (strcmp(tokens[0], "search") == 0) {
            if (token_count < 4) {
                printf("Usage: search [f/a/c] <filename> <pattern>\n");
                continue;
            }
            
            int find_first = (tokens[1][0] == 'f');
            int find_all = (tokens[1][0] == 'a');
            int count = (tokens[1][0] == 'c');
            const char *filename = tokens[2];
            const char *pattern = tokens[3];

            search_pattern(filename, pattern, find_first, find_all, count);
        } else if (strcmp(tokens[0], "exit") == 0) {
            break;
        } else {
            printf("Command not recognized: %s\n", tokens[0]);
        }
    }

    return 0;
}
