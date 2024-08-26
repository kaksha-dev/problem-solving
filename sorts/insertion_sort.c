#include <stdio.h>
#include <assert.h>
#include <stdlib.h>
#include <time.h>
#include <sys/time.h>

void exch(int arr[], int i, int j)
{
  int temp = arr[i];
  arr[i] = arr[j];
  arr[j] = temp;
}

void insertion_sort(int arr[], int n)
{
  for(int i = 1; i < n; i++)
  {
    for(int j = i; j > 0; j--)
    {
        if(arr[j] >= arr[j-1]) break;
        exch(arr, j, j-1);
    }
  }
}

long long time_elapsed_random(int n)
{
  int *arr = (int *) malloc(n * sizeof(int));

  srand(time(NULL));
  for(int i = 0; i < n; i++) arr[i] = rand();

  struct timeval before;
  gettimeofday(&before, NULL);
  long long before_millis = before.tv_sec*1000LL + before.tv_usec/1000;

  insertion_sort(arr, n);

  struct timeval after;
  gettimeofday(&after, NULL);
  long long after_millis = after.tv_sec*1000LL + after.tv_usec/1000;

  return after_millis-before_millis;
}

long long time_elapsed_best_case(int n)
{
    int *arr = (int *) malloc(n * sizeof(int));
    
    for(int i = 0; i < n; i++) arr[i] = i;

    struct timeval before;
    gettimeofday(&before, NULL);
    long long before_millis = before.tv_sec*1000LL + before.tv_usec/1000;

    insertion_sort(arr, n);

    struct timeval after;
    gettimeofday(&after, NULL);
    long long after_millis = after.tv_sec*1000LL + after.tv_usec/1000;
    free(arr);

    return after_millis-before_millis;
}

void test_simple_input()
{
  int input[] = {5, 3, 1, 9, 7};
  int expected_output[] = {1, 3, 5, 7, 9};

  insertion_sort(input, 5);

  for(int i = 0; i < 5; i++) assert(input[i] == expected_output[i]);
}

int main()
{
  test_simple_input();

  long long t1 = time_elapsed_random(32000);
  long long t2 = time_elapsed_random(64000);
  printf("Random Input: T(64k)/T(32k): %lf\n", t2*1.0/t1);

  long long t3 = time_elapsed_best_case(32000);
  long long t4 = time_elapsed_best_case(64000);
  printf("Already Sorted: T(64k)/T(32k): %lf\n", t4*1.0/t3);
  return 0;
}



