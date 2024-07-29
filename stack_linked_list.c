#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include <assert.h>
#include "stack.h"

struct Node
{
  int item;
  struct Node* next;
};

struct Node* head = NULL;
int N = 0;


bool isEmpty()
{
  return head == NULL;
}

int size()
{
  return N;
}

void push(int item)
{
  struct Node* oldHead = head;

  head = (struct Node*) malloc(sizeof(struct Node));
  head->item = item;
  head->next = oldHead;
  N++;
}

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
