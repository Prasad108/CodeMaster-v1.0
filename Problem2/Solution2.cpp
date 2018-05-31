#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int main()
{
   freopen("input_2.txt", "r", stdin);
   freopen("output_2.txt", "w", stdout);
   int tests = 0;

   cin>>tests;
   unsigned int nClappers = 0;
   unsigned int nClaps = 0;
   map<unsigned int,unsigned int> clappperNdClapps;
   string status = "OFF";
   int count = 1;

   for(int i=0 ;i<tests;i++)
   {
	  status = "OFF";
	  cin >> nClappers;
	  cin >> nClaps;
	  unsigned int clapsToON = pow(2,nClappers)-1;

	  	 while(nClaps >=clapsToON)
	     {
	  		if(nClappers == 1 && nClaps%2 !=0)
	  		{
	  			status = "ON";
	  		    break;
	  		}
	  		if(nClappers == 1 && nClaps%2 ==0)
			{
				break;
			}
	  		if(clapsToON == nClaps)
	  		{
	  			status = "ON";
	  			break;
	  		}
	  		  clapsToON += clapsToON+1;
	  	 }

	  cout << "Experiment-"<<count<<":" << status<< endl;;
	  count++;
   }
return 0 ;
}
