#include <iostream>
#include <set>
#include <tuple>
#include <list>
using namespace std;

int main() {
	/* std::set basic usage*/
	set <int> myset;	
	myset.insert(1);
	myset.insert(2);
  if(myset.find(1) != myset.end()) { // contains
		printf("You found 1!\n");
	}
	
	/* std::list basic usage*/
  std::list<std::string> mylist;
  std::list<std::string>::iterator it;
  mylist.push_back ("one");
  mylist.push_back ("two");
  mylist.push_back ("Three");
  mylist.sort();
  std::cout << "mylist contains:";
  for (it=mylist.begin(); it!=mylist.end(); ++it)
    std::cout << ' ' << *it;	
  std::cout << '\n';	
	
	/* std:tuple basic usage*/
	std::tuple<int, int, int> mytuple(10, 20, 30);
	int i0 = get <0> (mytuple);
	int i1 = get <1> (mytuple);
	int i2 = get <2> (mytuple);
	printf("%d\n", i0);
	printf("%d\n", i1);
	printf("%d\n", i2);
}
