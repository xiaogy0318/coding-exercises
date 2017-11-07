// 1) Write a function that detects a loop in a linked list.
// 2) Write a function that removes a loop in a linked list.
#include <iostream>
#include <set>
using namespace std;
  
// Link list node
struct Node
{
    int data = 0;
    Node* next = 0;
};


Node* constructLinkedList() {
  
  Node* node1 = new Node();
  node1->data = 1;
  
  Node* node2 = new Node();;
  node2->data = 2;
  node1->next = node2;
  
  Node* node3 = new Node();;
  node3->data = 3;
  node2->next = node3;
  
  Node* node4 = new Node();;
  node4->data = 4;
  node3->next = node4;  
  
  Node* node5 = new Node();;
  node5->data = 5;
  node4->next = node5;
  
  //Now make it a loop, 5 -> 2
  node5->next = node2;
  
  return node1;
  
  //return 0;
}

void deleteLinkedList(Node* node) {
  // Delete the nodes
  while(node != NULL) {
    Node* temp = node;
    node = node->next; // here node could be invalid if there is a loop. TODO: fix later
    //printf("Deleting %d...\n", node);
    temp->next = NULL;
    delete temp;
    temp = NULL;
  }
}

void printLinkedList(Node* node) {
  // Since it's a loop, need a counter to stop it...
  int counter = 0;
  while(node != NULL && counter <= 10) {
    printf("%d -> ", node->data);
    node = node->next;
    if (node == NULL) {
      printf("end");
    }

    counter++;
  }
  printf("\n");
}

void detectAndRemoveLoop(Node* mynode) {
  // Now scan the linked list and put each into a set
  Node* node = mynode; // do not change the original node
  
  set <Node*> myset;
  bool hasLoop = false;
  Node* tempParent = NULL;

  while(node != NULL) {
    //printf("%d -> ", node->data);
    // Check if it already exists in the set
    if(myset.find(node) != myset.end()) {
      printf("Found node in set: node %d has two partents!!! \n", node->data);
      printf("Yes, there is a loop!\n");
      printf("Parent node: %d needs to be fixed \n", tempParent->data);
      // Now set parent's next to NULL to remove the loop
      tempParent->next = NULL;
      hasLoop = true;
      break;
    }
    else {
      myset.insert(node);
    }
    
    
    tempParent = node;
    node = node->next;
  }
  
  if(!hasLoop) {
    printf("No loop! \n");
  } 
}

int main() {
  /* Analysis
  * For detection, can use fast/slow pointers, better than brute force
  * Each time,
  * fast pointer move two steps 
  * slow pointer moves one step
  * If fast pointer hits the end, then no loop
  * If fast pointer equals slow pointer (object equal), then there is a loop
  * 
  * For removal part
  * Need to find the node pointed by two parents
  * Can use a hashtable
  * Key is number of parents
  * Value is the pointer to the node
  * When detection of the dead loop has ended, 
  * the node which has two parents must have already been identified.
  * Once we have the node in question, find its parent who is deeper in the hierachy
  * make its next to null
  */
  
  /* Actually, if not need to remove the loop, fast/slow pointer approach would be the best
  * However, if also need to do removal, 
  * then additional data structures are needed to identify the problematic node
  * Here I'll use a Set
  * Use a pointer to move next
  * Put the node into the set
  * If the set already has the node, that means there is a loop
  * Then we can remove the loop here
  */
  
  // Construct a list first
  Node *node = constructLinkedList();
  
  if (node == NULL) {
    printf("end");
    return 0;
  }
  
  // Since it's a loop, need a counter to stop it...
  printLinkedList(node);
  
  // Refactor by moving below to a function...
  detectAndRemoveLoop(node);
  
  printLinkedList(node);
  
  // Clean up: Delete the nod  
  deleteLinkedList(node);

  return 0;
}
