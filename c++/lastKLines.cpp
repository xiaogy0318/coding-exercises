#include <iostream>
#include <fstream>
using namespace std;

int main () {
	/*
  ofstream myfile;
  myfile.open ("example.txt");
  myfile << "Writing this to a file.\n";
  myfile.close();
  return 0;
  */
  
  string line;
  ifstream myfile ("example.txt");
  int counter = 0;

  if (myfile.is_open())
  {
    while ( getline (myfile,line) )
    {
      cout << line << '\n';
	  counter++;
	  
    }
	
	
    myfile.close();
  }

  	int k = 11;
	int total = counter;
	cout<< total << '\n';
	
	//Should start from total - k until the end;
	if (total <= k) {
		k = total;
	}
	cout<< total - k << '\n';

	ifstream myfile2 ("example.txt");
  
  if (myfile2.is_open())
  {
	counter = 0;
    while ( getline (myfile2,line) )
    {
		if (counter >= total - k) {		
		  cout << line << '\n';
		}
	  counter++;
	  
    }
	
	
    myfile2.close();
  }
  
  else cout << "Unable to open file"; 

  return 0;
}