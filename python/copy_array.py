#"Write a function with the following specification: Input: a list. Output: a copy of the list with duplicates removed."
#from array import array
array1 = []
array2 = []
count_string = raw_input("Number of strings please (default is 3): ")
count = 3
try:
	count = int(count_string)
except ValueError:
	count = 3
for i in range(count):
	user_input = raw_input("Some input please: ") # or`input("Some...`
	array1.append(user_input)
	array2.append(user_input)
	
for i in range(count):
	array2.append(array1[i])
	
print(array2)
	
