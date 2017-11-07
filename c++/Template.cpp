#include <iostream>

using namespace std;

template <typename T> T my_max(T a, T b) {
	return a>b?a:b;
}

template <class T> class my_class {
	public:
		T my_max(T a, T b) {
			return a>b?a:b;
		}
	
};


int main() {
	int a = 1;
	int b = 2;
	cout << my_max(a, b);
	//my_class<int> myClass;
	my_class <int> *myClass = new my_class<int>;
	//cout << myClass.my_max(1, 2);
	cout << myClass->my_max(1, 2);
	
	delete myClass;
}
