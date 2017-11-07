#include <iostream>
#include <cstring>


using namespace std;


void reverse(char * testString) {

	cout<<strlen(testString)<<'\n';
	cout<<sizeof(testString)<<'\n';
	cout << testString<<'\n';

	size_t length = strlen(testString);
	
	for (size_t i = 0; i <= length/2 - 1; i++) {
		char temp = testString[i];
		testString[i] = testString[length - i - 1];
		testString[length - i - 1] = temp;
	}
	
	cout << testString<<'\n';
}

int main () {
	char testString[100] = "This is a test";
	reverse(testString);
	return 0;
}
