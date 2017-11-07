
treedata = '425a68393141592653599f22b34c00003edd80001040047ff00002bf209a00500507800001a00004aa7a69a9ea35334c937aa69e81aa7a6a327b48d4680029a3401a0000a68d00680000aaa9e099302152834f5371f4758d491b5e50959d6b4854861548a73b519ee445ad39276874864a9fda586cf19f1f3810ece4b1b98071c83f0e6a744c62e4164d77f8a986547dfd8b6d32d2cee6ff1474ffdfdfeb4fef10fdd2785143d61441a51551fc6974167f1059879fc434eda55a9b492e82c78617614d9a748b4b2ae96a21a8a041232cbd727b830a2ee3b49076824d41749b2cb9b3a69749a74a26db0f7dc36fe4aef10befdb49c47f7ce956d259145c48b26ea88a304544d541c5932b755641e27e24a13fd74d35cb3bca69f649277ebefd0612c2cd32db2f5174d3083b209a1dba6d95dd2cd9461b77044f7dda6f5969551679ce8e20da8bb4b9245e31c841ef5f791fd241daafd2e3083e79e55936abecd527af59f9f32f9a789bf6de395bcde34dbef3d876f2eabe7105d94d58206a7d2f7ab8c71555db8e977a8a7dee774289be4d874f914dc73925db6d045b59051f63d7a8b8e30aace927ab49545debcd26da2979a6544f884eaf5046a8a2bf906de38baa9308acbb8820822d34da5743f45ef957155117af11c4fdda6e3a4e4f5ae3d5d359359e3cf34e32869ea2d36e3d4c9b3e42f7938da282abba78edeacf58e9da2ca0e918b28f6e915905137e8ab671061c74c2cbbef6bc5dd6d6692414ed0bba4df5f2abe5515de3b2d6f967ce964585d07104d069c55b7adb0f1674a26cbb5bb7bc951c71eb6ce90baaca6d2654fa687ee24e206587aa20d341038c811790299d432519d685614b63687a83a4e2e1d64c263538e2cfbed36f5c34bb28bb55b4517aa22c63e49cd21a6d75174507a933ada28b8cbb4ddb8f0da892486d0fd84def9c49769bcbe674e9441e27341475a43b3b4dc5986dc74aa2e9e14554744966177de7157b2f165139d0e26f9ebed3a749b6f1abf4f1e28f565d741eb2aa4f57599cc2184b2e9c4166596dc76f5545274e3082b845d28ba6d6a10a32c30f17419edd36e9e3a79543a3493c2cf136512acb5996abdacc2584d1b30bcfc511509f6d27743f57a434eff4d976945869445674b3b753cdb3a6996db49f32eda554536db29a8a51069759541d2abfcb22c2acbefbcaa0a3b61369c7ac22f1a48bb49be7af976925d793e74ba4aa8c20b28e8dbb69343efd069f7df3b2af1841359961751345478e26edeac824ed651671661759876a25daacbe7a932dacd30b36cbb7c9a4e32b2aedf7efdffc5dc914e142427c8acd30'

import binascii
import os
import bz2
from os import listdir
import shutil

class Node:
  text = ""# For holding the file name as key
  nodes = []# For the children
  value = "" # the leaf's value. Only when nodes is empty

  def printNode(self):
    #print "text: ", self.text
    #print "value: ", self.value
    if (len(self.value) > 0):
      print self.value, 
    #print "nodes: ",
    counter = 0
    for i in self.nodes:
      #print "child #", counter, ": ", i
      counter = counter + 1 
    #print
      
def printTreeNode(node):
  # print node itself
  node.printNode()
  
  # print children from left to right
  for childKey in node.nodes:
    #print "Found child: ", childKey
    #printTreeNode(child)
    # Now I have child's text, Now find it in the dict
    childNode = filedict[childKey]
    printTreeNode(childNode);

'''  
# Test a simple tree
node1 = Node()
node1.text = "node1"


node2 = Node()
node2.text = "node2"

node1.nodes.append(node2);

print node1.text
print node1.nodes
print node2.text
'''




shutil.rmtree("tree")
#os.rmdir("tree")
os.mkdir('tree')
for f in bz2.decompress(binascii.unhexlify(treedata)).split(','):
    arr = f.split(':')
    fid = open('tree/'+arr[0], 'w')
    fid.write(arr[1])
    fid.close()

# Interviewee starts below here. You can look at the above if you like but it won't help.
# The above code created a directory called 'tree' with  ~ 30 files in it.
# Each file defines a node in the tree and contains either:
# - A single character. This is a leaf node of the tree; or
# - A list of space separated file names. These nodes are the children of the node associated with the file name.
#     The children are listed as nodes left-to-right.
# Your job is to:
#   A) Find the root node.
#   B) Traverse the tree using a left first traversal and print the characters in each leaf node. This should produce
#       English text.
#

#print("Here's a list of files in the 'tree' directory: %s" % '\n'.join(sorted(os.listdir('tree'))))


# Construct the tree 
# Read from files and put them into Node class, and then the nodes into an array
filelist = []

# Read the file names from directory "tree" and put into the Node class
for f in listdir('tree'):
  node = Node()
  node.text = f
  filelist.append(node)
  # Now open the file and read the content 
  fid = open('tree/' + f, 'r')
  #print node.text, "has: ", fid.read()
  # either a single character (leaf), or a space delimetered string of file names
  content = fid.read()
  
  # Now parse the content
  if (len(content) == 1): # leaf
    node.value = content
  else:
    # Now just need to convert to array and put in nodes
    node.nodes = str.strip(content).split(" ")
    
  #node.printNode()
  
  
#for i in filelist:
#  print i.printNode()
  
# Now scan the filelist, and construct the tree
# Find root first, then from root, just scan the rest and link to all childrens, recursively
# Use dict instead of list of better in searching... Now try to convert list to dict
'''
filedict = {}

#print filedict["af30f30738b20428a2dd39df98e93e97"];
'''

# Find root now...
# Root is the node whose text never appears in its any other nodes' children list
filedict = {}
for i in filelist:
  filedict[i.text] = i

filedict = dict(filedict)
  
root = Node()
for i in filelist:
  nodeText = i.text # This is the node's text for the test
  # Now scan all nodes in the dict (for simplicity, including itself, which doesn't matter)
  isRoot = True
  for key in filedict:
    # Check if nodes contains the text
    nodes = filedict[key].nodes
    for temp in nodes:
      if nodeText in temp:
        # this node is not root
        isRoot = False
    else:
      # Should continue the test until exhausted
      continue
   
  # Now we know if it's a root or not
  if(isRoot):
    # Now we know i is the root, stop
    #print "Found root:"
    root = i;
    break
  else:
    continue
    
# Now print the root
#root.printNode()
printTreeNode(root)
'''
# print children from left to right
for childKey in root.nodes:
  print "Found child: ", childKey
  #printTreeNode(child)
  # Now I have child's text, Now find it in the dict
  childNode = filedict[child]
  childNode.printNode()
'''

  
# Now we build up the tree by truely linking to each other (previously the link is by text, now update the nodes with actual nodes...)
# Oh, actually, no need to if the job is to print out the stuff. 

 
'''
fid = open('tree/'+arr[0], 'w')
fid.write(arr[1])
fid.close()
'''



