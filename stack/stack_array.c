#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include <assert.h>
#include "stack.h"

#define INITIAL_CAPACITY 1

int* array;
int N = 0;
int max_size = 1;

void resize_array(int new_capacity)
{
  int * new_array = (int *) malloc(sizeof(int)*new_capacity);

  for(int i = 0; i < N; i++)
    new_array[i] = array[i];

  free(array);
  array = new_array;
}


void push(int item)
{
  if(N < max_size) {
    if(N == 0) max_size = 1;
    else max_size = 2*N;
    resize_array(max_size);
  }
  max_size = 2*N;
  array[N++] = item;
}

int pop()
{
  int item = array[--N];
  if (N <= max_size/4) resize_array(N/2);
  max_size = N/2;

  return item;
}

bool isEmpty()
{
  return N == 0;
}

int size()
{
  return N;
}

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
