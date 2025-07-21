/**
 * Stack implementation with a resizing array.
 */

#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include <assert.h>
#include "stack.h"

int* array;
int N = 0;
int max_size = 1;

// resize the underlying array holding the elements
void resize_array(int new_capacity)
{
  int * new_array = (int *) malloc(sizeof(int)*new_capacity);

  for(int i = 0; i < N; i++)
    new_array[i] = array[i];

  free(array);
  array = new_array;
}

/**
 * Pushes a new item to the stack.
 * 
 * @param item - item to be pushed into stack
 */
void push(int item)
{
  array[N++] = item;
  if(N >= max_size) {
    max_size *= 2;
    resize_array(max_size);
  }
}

/**
 * Removes and returns the item most recently added to this stack.
 * @return the item most recently added
 */
int pop()
{
  int item = array[--N];
  if (N <= max_size/4) {
    max_size = max_size/2;
    resize_array(max_size);
  }

  return item;
}

/**
 * Is this stack empty?
 * @return true if this stack is empty; false otherwise
*/
bool isEmpty()
{
  return N == 0;
}

/**
 * Returns the number of items in the stack.
 * @return the number of items in the stack
*/
int size()
{
  return N;
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
  array = (int *) malloc(sizeof(int)*max_size);
  testStack();
  return 0;
}
