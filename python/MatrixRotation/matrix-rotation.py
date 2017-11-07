# Read test case no
testCaseNo = int(raw_input(""));
for i in range(testCaseNo):
    # Read matrix dimension N
    N = int(raw_input(""))
    
    # Read the matrix data
    # Use temp for now
    matrixData = [[1, 2],
                [3, 4]]
    
    matrixString = raw_input("").split()
    outerArray = []
    counter = 0
    innerArray = []
    for input in matrixString:
        # Convert to two-dimension array
        innerArray.append(int(input))
        counter = counter + 1
        if(counter == N):
            outerArray.append(innerArray)
            innerArray = []
            counter = 0
    
    #print(outerArray)
    matrixData = outerArray
    string1 = list(reversed(zip(*matrixData)))
    listNew = []
    for i in string1:
        #print list(i)
        listNew.append(list(i))
    #print listNew
    
    for a in listNew:
        for b in a:
            print b,
    print
