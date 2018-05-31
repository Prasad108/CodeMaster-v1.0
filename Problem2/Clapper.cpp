#include <bits/stdc++.h>
using namespace std;

int main() {
   freopen("input_2.txt", "r", stdin);
   freopen("output_2.txt", "w", stdout);
   int tests = 0;
   cin>>tests;
   for(int i=0;i<tests;i++)
   {
      int claps = 0;
      int temp = 0;
      int clappers = 0;
      unsigned int value = 0x01;

      cin>>clappers>>claps;
      for(int i = 0; i<clappers;i++)
      {
         temp |= value;
         value<<1;
      }
      cout<<"Experiment-"<<i+1<<": ";
      if (claps & temp == temp)
         cout<<"ON"<<endl;
      else
         cout<<"OFF"<<endl;
   }
   return 0;
}
