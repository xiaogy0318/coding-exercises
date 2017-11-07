def add_without_plus(n1, n2):
  # Add can be split into 2 steps
  # 1. use xor so that two numbers are added without considering carrying
  # 2. Then handle the carrying by and and then << by 1 digit
  
  if (n2 == 0):
    return n1
  sum = n1 ^ n2
  #print n1, " xor ", n2, " is: ", n3
  
  carry = (n1 & n2) << 1
  #print n1, " and ", n2, " and then shift left by 1 is: ", n4
  
  # Repeat the process. Each time the carry would move up, until it's 0
  return add_without_plus(sum, carry)
  
  
#add_without_plus(2, 3) 
print add_without_plus(9, 3) 
print add_without_plus(2432, 213) 
print add_without_plus(68762, 342) 
print add_without_plus(3, 5758565) 
