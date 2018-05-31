#include <bits/stdc++.h>
using namespace std;

int main() {
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);
	int tests = 0;
	cin>>tests;
	for(int i=0;i<tests;i++)
	{
		unsigned int val = 0x01;
		unsigned int clappers = 0;
		unsigned int claps = 0;
		unsigned int temp = 0;
		cin>>clappers>>claps;
		for(int i = 0; i<clappers;i++)
		{
			temp |= val;
			val<<1;
		}
		cout<<"Experiment-"<<i+1<<": ";
		if (claps & temp == temp)
			cout<<"ON"<<endl;
		else
			cout<<"OFF"<<endl;
	}

	return 0;
}
