#include <stdio.h>

#define MAX_PROCESS 10

// Function to find the minimum of two numbers
int min(int a, int b) {
    return (a < b) ? a : b;
}

// Function to implement Round Robin scheduling
void roundRobin(int processes[], int n, int bt[], int quantum) {
    int wt[n], tat[n], remaining_time[n];

    // Copy burst times to remaining_time array
    for (int i = 0; i < n; i++) {
        remaining_time[i] = bt[i];
        wt[i] = 0;
        tat[i] = 0;
    }

    int time = 0; // Current time
    int done = 0; // Number of processes completed

    // Simulation loop
    while (done < n) {
        for (int i = 0; i < n; i++) {
            if (remaining_time[i] > 0) {
                int execute_time = min(remaining_time[i], quantum);
                remaining_time[i] -= execute_time;
                time += execute_time;

                // Update waiting time for processes
                wt[i] += (time - tat[i] - bt[i]);

                // Update turnaround time for processes
                tat[i] = time;

                // Check if process is completed
                if (remaining_time[i] == 0) {
                    done++;
                }
            }
        }
    }

    // Print Gantt Chart
    printf("\nGantt Chart:\n");
    for (int i = 0; i < n; i++) {
        printf("P%d\t", processes[i]);
    }
    printf("\n");

    // Print turnaround time and waiting time for each process
    float total_tat = 0, total_wt = 0;
    for (int i = 0; i < n; i++) {
        printf("P%d\t%d\t%d\n", processes[i], tat[i], wt[i]);
        total_tat += tat[i];
        total_wt += wt[i];
    }

    // Print average turnaround time and average waiting time
    printf("\nAverage Turnaround Time: %.2f\n", total_tat / n);
    printf("Average Waiting Time: %.2f\n", total_wt / n);
}

int main() {
    int n, quantum;

    printf("Enter the number of processes: ");
    scanf("%d", &n);

    int processes[MAX_PROCESS];
    int burst_time[MAX_PROCESS];

    printf("Enter the arrival time and burst time for each process:\n");
    for (int i = 0; i < n; i++) {
        printf("Enter arrival time for process %d: ", i + 1);
        scanf("%d", &processes[i]);
        printf("Enter burst time for process %d: ", i + 1);
        scanf("%d", &burst_time[i]);
    }

    printf("Enter the time quantum: ");
    scanf("%d", &quantum);

    roundRobin(processes, n, burst_time, quantum);

    return 0;
}
