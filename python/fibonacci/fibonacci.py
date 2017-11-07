cache = []
def calculateFibonacci(input):
    global cache
    if (input == 0):
        cache[0] = 0;
        return 0
    if (input == 1):
        cache[1] = 1
        return 1
        
    
    if (cache[input] == 0):
        cache[input] = (calculateFibonacci(input - 1) + calculateFibonacci(input - 2)) % 1000000007
    
    return cache[input]

inputTestCaseNo = raw_input("Please enter your number of test cases: ");

testCaseNo = int(inputTestCaseNo);

for i in range(testCaseNo):
    input = int(raw_input("Please enter your input: "))
    cache = [0 for x in range(input + 1)]
    
    print calculateFibonacci(input);

