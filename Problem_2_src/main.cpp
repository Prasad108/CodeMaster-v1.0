/*
 * Author : Ramashish maurya (A672117), Shivank Gupta (A646866)
 */

#include <iostream>
#include <fstream>
#include <sstream>
using namespace std;

bool getOnOrOff(int a, int b) //Function to check ON or OFF
{
   int temp = a, count = 0;
   if(b != 0)
   {
      while(temp > 0)
      {
         count = count + temp;
         temp--;
      }

      int rem;
      rem = b%count;

      if(rem == 0)
      {
         return true;
      }
      else
      {
         return false;
      }

   }
   return false;
}

int main() {

   ifstream ifs("input_2.txt");
   ofstream ofs("output.txt");
   string line;
   bool flag = false;

   if(!ifs) {
      cout << "Cannot open input file.\n";
      return 1;
   }

   int a, b, n = 0, count = 0;
   istringstream strm;
   while (getline(ifs, line)) { //Reading line by line from file
      istringstream strm(line);
      count++;
      if(!flag)
      {
         strm >> n;
         flag = true;
         count = 0;
      }
      else
      {
         strm >> a >> b;
         ofs << "Experiment-" << count << " : " << (getOnOrOff(a, b)?"ON":"OFF") << endl; //Calling function to check on or off
         n--;
         if(n <= 0)
            break;
      }

   }
   cout << "Program successful......" << endl;
   return 0;
}
