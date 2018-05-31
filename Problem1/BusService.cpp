
#include <bits/stdc++.h>
using namespace std;


unsigned int mins()
{
	int hrs=0;
	char ch;
	int min = 0;
	cin>>hrs;
	cin>>ch;
	cin>>min;
	return hrs*60+min;
}

int main() {
	freopen("input.txt", "r", stdin);
//	freopen("output.txt", "w", stdout);
	int tests = 0;
	cin>>tests;
	for(int i=0;i<tests;i++)
	{
		map<int,unsigned int> mpDep;
		map<int,unsigned int> mpArr;
		unsigned int tp = 0;
		cin>>tp;
		cout<<tp<<endl;
		unsigned int AToB = 0;
		cin>>AToB;
		cout<<AToB<<endl;

		unsigned int BToA = 0;
		cin>>BToA;
		cout<<BToA<<endl;

		int trip_no= 0;
		for(int j=0;j<AToB;j++)
		{
			mpDep.insert(pair<int,unsigned int>(trip_no,mins()));
			mpDep.insert(pair<int,unsigned int>(trip_no, mins()));
			++trip_no;
		}
		for(int j=0;j<BToA;j++)
		{
			mpDep.insert(pair<int,unsigned int>(trip_no, mins()));
			mpDep.insert(pair<int,unsigned int>(trip_no, mins()));
			++trip_no;
		}
	}
	return 0;
}
