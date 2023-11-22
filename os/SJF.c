#include<stdio.h>

// Process structure to store information about each process
struct Process {
    int process_id;
    int arrival_time;
    int burst_time;
    int turnaround_time;
    int waiting_time;
};

// Function to perform SJF scheduling
void sjf_scheduling(struct Process processes[], int n) {
    // Sort processes based on arrival time
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (processes[j].arrival_time > processes[j + 1].arrival_time) {
                // Swap processes
                struct Process temp = processes[j];
                processes[j] = processes[j + 1];
                processes[j + 1] = temp;
            }
        }
    }

    int total_waiting_time = 0;
    int total_turnaround_time = 0;

    // Calculate turnaround time and waiting time
    for (int i = 0; i < n; i++) {
        if (i == 0) {
            processes[i].waiting_time = 0;
        } else {
            processes[i].waiting_time = processes[i - 1].waiting_time + processes[i - 1].burst_time;
        }

        processes[i].turnaround_time = processes[i].waiting_time + processes[i].burst_time;

        total_waiting_time += processes[i].waiting_time;
        total_turnaround_time += processes[i].turnaround_time;
    }

    // Display Gantt Chart
    printf("\nGantt Chart:\n");
    for (int i = 0; i < n; i++) {
        printf("| P%d ", processes[i].process_id);
    }
    printf("|\n");

    // Display process information
    printf("\nProcess\t Arrival Time\t Burst Time\t Waiting Time\t Turnaround Time\n");
    for (int i = 0; i < n; i++) {
        printf("P%d\t %d\t\t %d\t\t %d\t\t %d\n", processes[i].process_id, processes[i].arrival_time,
               processes[i].burst_time, processes[i].waiting_time, processes[i].turnaround_time);
    }

    // Calculate and display average waiting time and turnaround time
    float avg_waiting_time = (float) total_waiting_time / n;
    float avg_turnaround_time = (float) total_turnaround_time / n;

    printf("\nAverage Waiting Time: %.2f", avg_waiting_time);
    printf("\nAverage Turnaround Time: %.2f\n", avg_turnaround_time);
}

int main() {
    int n;

    // Input the number of processes
    printf("Enter the number of processes: ");
    scanf("%d", &n);

    struct Process processes[n];

    // Input arrival time and burst time for each process
    for (int i = 0; i < n; i++) {
        processes[i].process_id = i + 1;
        printf("Enter arrival time for process P%d: ", i + 1);
        scanf("%d", &processes[i].arrival_time);
        printf("Enter burst time for process P%d: ", i + 1);
        scanf("%d", &processes[i].burst_time);
    }

    // Perform SJF Scheduling
    sjf_scheduling(processes, n);

    return 0;
}
