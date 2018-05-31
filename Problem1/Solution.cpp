#include <iostream>
#include <stdio.h>
#include <stdlib.h>
using namespace std;

float TimeIntoFloat(const char *);


int main()
{
	int counter=0,num_of_days,wait_time,num_ab_trips,num_ba_trips,total_trips;
	char ps[10000];
	char a[10],b[10];
	float arrival,departure;
	FILE *fptr;
	fptr = fopen("input_2.txt","r");
    while (!feof(fptr))
    {
    	if (counter == 0)
    	{
    		fscanf(fptr,"%d",&num_of_days);
    		counter ++;

    	}
    	if (counter == 1)
    	{
    	fscanf(fptr,"%d",&wait_time);
    	counter++;

    	}
    	if (counter == 2)
    	{
    		fscanf(fptr,"%d %d",&num_ab_trips,&num_ba_trips);
    		counter++;
    	}
    	total_trips = num_ab_trips + num_ba_trips;

        cout << num_of_days << endl;
   	    cout << wait_time <<endl;
   	    cout << "Total Trips: "<<total_trips <<" AB TRIPS: "<<num_ab_trips <<"     BA TRIPS: "<<num_ba_trips<<endl;

    	for(int i =0;i<total_trips;++i)
    	{
    		fscanf(fptr,"%s %s",a,b);
    		departure = TimeIntoFloat(a);
    		arrival = TimeIntoFloat(b);
    		cout << "Departure Time: "<<a << "  Arrival Time: "<<b<<endl;
    		cout << "Departure Time: "<<departure << "  Arrival Time: "<<arrival <<endl;
    	}

        counter = 1;
    	//fscanf(fptr,"%d %d",&a,&b);
    	//cout << a << "   " << b << endl;
    }
    cout << num_of_days << endl;
    cout << wait_time <<endl;
    cout << "Total Trips: "<<total_trips <<" AB TRIPS: "<<num_ab_trips <<"     BA TRIPS: "<<num_ba_trips<<endl;


    fclose(fptr);
}

float TimeIntoFloat(const char *ps)
{
	char temp[2];
	int hour,min;
	int i=0;
	while(i<5)
	{
		if(i==0)
		{
			temp[0]=ps[i];
			temp[1]='\0';
			hour=atoi(temp);
		}
		if(i==1)
		{
			temp[0]=ps[i];
			temp[1]='\0';
			hour = hour*10+atoi(temp);
		}
		if(i==3)
		{
			temp[0]=ps[i];
			temp[1]='\0';
			min=atoi(temp);
		}
		if(i==4)
		{
			temp[0]=ps[i];
			temp[1]='\0';
			min = min*10+atoi(temp);
		}
		i++;
	}
	return float(min)/60+hour;
}
