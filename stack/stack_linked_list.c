/** 
 * Stack implementation with a linked list.
*/

#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include <assert.h>
#include "stack.h"

// Represents a node of the linked list
struct Node
{
  int item;
  struct Node* next;
};

struct Node* head = NULL;
int N = 0;

/**
 * Is this stack empty?
 * @return true if this stack is empty; false otherwise
*/
bool isEmpty()
{
  return head == NULL;
}

/**
 * Returns the number of items in the stack.
 * @return the number of items in the stack
*/
int size()
{
  return N;
}

/**
 * Pushes a new item to the stack.
 * 
 * @param item - item to be pushed into stack
 */
void push(int item)
{
  struct Node* oldHead = head;

  head = (struct Node*) malloc(sizeof(struct Node));
  head->item = item;
  head->next = oldHead;
  N++;
}

/**
 * Removes and returns the item most recently added to this stack.
 * @return the item most recently added
 */
int pop()
{
  if(head == NULL) return INT_MIN;

  struct Node* temp = head;
  int item = head->item;
  head = head->next;
  N--;
  free(temp);

  return item;
}

// Tests Stack data structure.
void testStack()
{
  push(3);
  push(5);
  push(7);

  assert(size() == 3);
  assert(isEmpty() == false);
  
  assert(pop() == 7);
  assert(size() == 2);
  assert(isEmpty() == false);

  assert(pop() == 5);
  assert(size() == 1);
  assert(isEmpty() == false);

  assert(pop() == 3);
  assert(size() == 0);
  assert(isEmpty() == true);
}

int main()
{
  testStack();
  return 0;
}
