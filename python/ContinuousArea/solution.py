import copy

# Assume an input matrix of 0's and 1's. 
# Write code to get the counts of 1's in all contiguous regions of 1's in the matrix. 
# Neighborhood is up,down, left, right. Not diagonal.
# For example in Python, for the following input matrix, the desired answer is [6, 8]


def test_next(x, y, new_x, new_y, visited, matrix):
    #print "test_next: ", x, y, new_x, new_y
    width = len(matrix[0])
    height = len(matrix) 
    
    if (new_x >= width or new_y >= height 
       or new_x < 0 or new_y < 0): # out of boundary
        #print False
        return False
    
    if (visited[new_y][new_x]):
        return False
        
    if (matrix[y][x] == 1 and matrix[new_y][new_x] == 1): # connectivity
        #print True
        return True
    else:
        #print False
        return False
    
    #print True
    return True


def DFS_iterative(x, y, matrix, visited, queue, mode="BFS"):
    mylist = [] # stack for holding the items to be processed
    
    if(visited[y][x]):
        return
    
    width = len(matrix[0])
    height = len(matrix) 
    
    
    # Visit current node
    #visited[y][x] = True
    if (matrix[y][x] == 1):
        mylist.append((x, y))
  
        if(mode == "BFS"):
            print "BFS"
        else:
            print "DFS"
    
    
   
    # Process the stack
    while(len(mylist) > 0):
        if(mode == "BFS"):
            #print "BFS"
            (x, y) = mylist.pop(0); # use queue instead, BFS
        else:
            #print "DFS"
            (x, y) = mylist.pop(); # use queue instead, DFS
        if(not visited[y][x]):
            print (x, y),

        visited[y][x] = True
        #if (matrix[y][x] == 1):
            #stack.append((x, y))
            #print (x, y),

        # Test connectivity with 4 directions
        # Move to the next node for the same process   
        #Test right direction
        new_x = x + 1
        new_y = y
        hasNextRight = False
        if(test_next(x, y, new_x, new_y, visited, matrix)):
            hasNextRight = True
            mylist.append((new_x, new_y));
            #print (new_x, new_y),
    
        # Test left direction
        new_x = x - 1
        new_y = y
        hasNextLeft = False
        if(test_next(x, y, new_x, new_y, visited, matrix)):
            hasNextLeft = True
            mylist.append((new_x, new_y));
            #print (new_x, new_y),

        # Test down direction
        new_x = x
        new_y = y + 1
        hasNextDown = False
        if(test_next(x, y, new_x, new_y, visited, matrix)):
            hasNextDown = True
            mylist.append((new_x, new_y));
            #print (new_x, new_y),


        # Test up direction
        new_x = x
        new_y = y - 1
        hasNextUp = False
        if(test_next(x, y, new_x, new_y, visited, matrix)):
            hasNextUp = True
            mylist.append((new_x, new_y));
            #print (new_x, new_y),
    
    #print stack
    print
    
    
def DFS(x, y, matrix, visited, queue):
    
    if(visited[y][x]):
        return
    
    width = len(matrix[0])
    height = len(matrix) 
    
    # Visit current node
    visited[y][x] = True
    if (matrix[y][x] == 1):
        queue.append((x, y))
    
    #print queue
    #print list(queue)
    
    # Test connectivity with 4 directions
    # Move to the next node for the same process
    
    # Test right direction
    new_x = x + 1
    new_y = y
    hasNextRight = False
    if(test_next(x, y, new_x, new_y, visited, matrix)):
        hasNextRight = True
        DFS(new_x, new_y, matrix, visited, queue)

    # Test left direction
    new_x = x - 1
    new_y = y
    hasNextLeft = False
    if(test_next(x, y, new_x, new_y, visited, matrix)):
        hasNextLeft = True
        DFS(new_x, new_y, matrix, visited, queue)
        
    # Test down direction
    new_x = x
    new_y = y + 1
    hasNextDown = False
    if(test_next(x, y, new_x, new_y, visited, matrix)):
        hasNextDown = True
        DFS(new_x, new_y, matrix, visited, queue)

        
    # Test up direction
    new_x = x
    new_y = y - 1
    hasNextUp = False
    if(test_next(x, y, new_x, new_y, visited, matrix)):
        hasNextUp = True
        DFS(new_x, new_y, matrix, visited, queue)

    
    # We return the size of the queue only when it has been exhausted, meaning reaching the end
    '''
    if (not hasNextRight and not hasNextLeft
        and not hasNextDown and not hasNextUp
        and len(queue) > 0):
        print "Find an area with size: ", len(queue)
    '''

row1 = [0, 0, 1, 1, 1]
row2 = [0, 0, 0, 1, 1]
row3 = [0, 1, 0, 0, 1]
row4 = [1, 1, 1, 1, 0]
row5 = [0, 1, 1, 1, 0]
matrix = [row1, row2, row3, row4, row5]
    
# Analysis
# Maintain a gloal matrix to hold visited status of each node
# For each node in the matrix, run BFS to identify the area
width = len(matrix[0])
height = len(matrix)

# Construct the visited matrix here...
#TODO: define visited[][], default false
#print width, height
# Not sure why below doesn't work, but check later... Now use a workaround instead (hardcoding)

#print matrix
visited = copy.deepcopy(matrix)
for y in range(height):
    for x in range(width):
        visited[y][x] = False
        
#print visited
#print matrix

for y in range(height):
    for x in range(width):
        # Now process the current node
        queue = []; # hold the current set of connected nodes
        #print "Now start processing: " + str(x) + ", " + str(y)
        #DFS(x, y, matrix, visited, queue)
        #DFS_iterative(x, y, matrix, visited, queue)
        DFS_iterative(x, y, matrix, visited, queue, "DFS")
        if (len(queue) > 0):
            print x, y
            print "Find an area with size: ", len(queue)
            print queue
        
