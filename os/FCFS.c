#include<stdio.h>
#include<stdlib.h>
#define MAX 10
typedef struct PROCESS
{
	char name[20];
	int tat,wt,at,bt,ct;
}PROCESS;
PROCESS p[MAX];
int n,i,j,k;
float totaltat,totalwt,avgtat,avgwt;
void sort()
{
	PROCESS p1;
	for(i=0;i<n;i++)
	{
		for(j=i+1;j<n;j++)
		{
			if(p[j].at < p[i].at)
			{
				p1=p[j];
				p[j]=p[i];
				p[i]=p1;
			} 
		}
	}	

}



void getdata()
{
	printf("\nEnter the number of process : ");
	scanf("%d",&n);
	for(i=0;i<n;i++)
	{
		printf("\nEnter the process name : ");
		scanf("%s",p[i].name);
		printf("\nEnter the CPU arrival time : ");
		scanf("%d",&p[i].at);
		printf("\nEnter the Burst time : ");
		scanf("%d",&p[i].bt);
	}
	sort();
}


void calculate()
{

	int time=0,i=0;
	printf("\n\n GanntChart :\n");
	printf("---------------------------------------\n");
	printf("|%d ",time);
	while(i<n)     
{
		p[i].wt=time-p[i].at;
		time=time+p[i].bt;
		p[i].ct=time;
		p[i].tat=p[i].bt+p[i].wt;
		
		printf("%s ",p[i].name);
		printf("%d|%d ",time,time);
		
		totaltat+=p[i].tat;
		totalwt+=p[i].wt;
		i++;
	}
	printf("\n--------------------------------------\n\n");
	avgtat=totaltat/n;
	avgwt=totalwt/n;
}


void display()
{
	printf("\n--------------------------------------------------------\n");
	printf("Process ArrivalTime BurstTime TurnAroundTime WaitTime\n");
	printf("---------------------------------------------------------\n");
	for(i=0;i<n;i++)
		printf("%s\t %d\t\t %d\t %d\t\t %d\n",p[i].name,p[i].at,p[i].bt,p[i].tat,p[i].wt);
	printf("---------------------------------------------------------");	
	printf("\n\nTotal turn around time :%f",totaltat);
	printf("\n\nTotal wait time :%f",totalwt);
	printf("\n\nAverage turn around time :%f",avgtat);
	printf("\n\nAverage waiting time :%f",avgwt);
		
}
void main()
{
	getdata();
	calculate();
	display();
}
