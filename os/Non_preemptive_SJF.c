#include<stdio.h>
#include<string.h>
#include<stdlib.h>
typedef struct SJF
{
	char name[20];
	int at,bt,ct,tbt,wt,tat;
}SJF;
SJF* s;
int n,currenttime,cnt;
float totalwt,totaltat,avgwt,avgtat;


void accept()
{
	int i;
	printf("Enter no of processes ");
	scanf("%d",&n);
	s=(SJF*)malloc(sizeof(SJF)*n);
	
	for(i=0;i<n;i++)
	{	
		printf("Enter process name ");
		scanf("%s",&s[i].name);
		printf("Enter arrival time ");
		scanf("%d",&s[i].at);
		printf("Enter burst time ");
		scanf("%d",&s[i].bt);
		s[i].tbt=s[i].bt;
	}
}


void sort()
{
	SJF t;
	int i,j;  
	
	for(i=0;i<n;i++)
	for(j=i+1;j<n;j++)
	if(s[i].at>s[j].at)   
	{
		t=s[i];
		s[i]=s[j];
		s[j]=t;
	}
	
}


int getindex()
{
	int i,loc=-1,min=999;
	for(i=0;i<n;i++)
	if(s[i].tbt!=0 && s[i].at<=currenttime)
	{
		if(s[i].bt<min)
		{
			min=s[i].bt;
			loc=i;
		}
	}
	return loc;
}


void schedule()
{
	int i;
	sort();
	printf("\n********************************Gantt Chart********************************\n");
	while(1)
	{
		i=getindex();
		if(i==-1)
		{
			printf("|%d idel",currenttime);
			currenttime=s[cnt].at;
			printf("%d",currenttime);
		}
		else
		{
			printf("|%d %s ",currenttime,s[i].name);
			s[i].wt=currenttime-s[i].at;
			s[i].tat=s[i].wt+s[i].bt;
			s[i].tbt=0;
			currenttime+=s[i].bt;
			s[i].ct=currenttime;
			printf("%d",currenttime);
			totalwt+=s[i].wt;
			totaltat+=s[i].tat;


			cnt++;
			if(cnt==n)
				break;
		}
	}
	avgwt=totalwt/n;
	avgtat=totaltat/n;
}


void display()
{
	int i;
	printf("\n***************************************************************************\n");
	printf("\nName\tArrival Time\tBurst Time\tWaiting Time\tTurn Around Time\n");
	for(i=0;i<n;i++)
		printf("%s\t%d\t\t%d\t\t%d\t\t%d\n",s[i].name,s[i].at,s[i].bt,s[i].wt,s[i].tat);
	printf("\nTotal waiting time %f",totalwt);
	printf("\nTotal Turn Around time %f",totaltat);
	printf("\nAverage waiting time %f",avgwt);
	printf("\nAverage Turn Around time %f\n",avgtat);	
}   


main()
{
	accept();
	schedule();
	display();
}

