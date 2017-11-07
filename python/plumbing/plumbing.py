import copy
'''
#shallow copy vs deep copy
'''
row1 = [0, 0, 1, 1, 1]
row2 = [0, 0, 0, 1, 1]
row3 = [0, 1, 0, 0, 1]
row4 = [1, 1, 1, 1, 0]
row5 = [0, 1, 1, 1, 0]
matrix = [row1, row2, row3, row4, row5]

row1_new = list(row1) # now row1_new has a copy of row1 values
row1_new[0] = 100
print ("row1: ", row1)
print ("row1_new: ", row1_new)

# Now copy matrix
matrix_new = list(matrix) # This only copied matrix's direct children (i.e. row1 -> matrix_new[0], row2, etc) but row1 and matrix_new[0] actually point to the same array (shared)
matrix_new[0][0] = 100
print ("matrix: ", matrix)
print ("matrix_new: ", matrix_new)

# To solve it, use deep copy
matrix_new = copy.deepcopy(matrix) # This only copied matrix's direct children (i.e. row1 -> matrix_new[0], row2, etc) but row1 and matrix_new[0] actually point to the same array (shared)
matrix_new[0][0] = 10000
print ("matrix: ", matrix)
print ("matrix_new: ", matrix_new)

'''
#trim a string's white spaces
'''
print str.strip("   This string has been trimmed/stripped     ") #python2

'''
dict
'''
dict = {"a": "Apple", "b": "Berry", "c":"Cherry"}
dict["d"]="Dog"
for item in dict:
  print dict[item]
del dict["c"] 
for item in dict:
  print dict[item]
  