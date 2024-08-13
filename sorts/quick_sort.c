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

void quick_sort_recursive(int arr[], int left, int right) 
{
    if(left >= right) return;

    int pivot = arr[left];
    int i = left+1;

    for(int j=left+1; j <= right; j++)
        if(arr[j] <= pivot)
        exch(arr, i++, j);

    exch(arr, left, --i);
    quick_sort_recursive(arr, left, i-1);
    quick_sort_recursive(arr, i+1, right);
}

void quick_sort(int arr[], int n)
{
    quick_sort_recursive(arr, 0, n-1);
}

long long time_elapsed_random(int n)
{
  int *arr = (int *) malloc(n * sizeof(int));

  srand(time(NULL));
  for(int i = 0; i < n; i++) arr[i] = rand();

  struct timeval before;
  gettimeofday(&before, NULL);
  long long before_millis = before.tv_sec*1000LL + before.tv_usec/1000;

  quick_sort(arr, n);

  struct timeval after;
  gettimeofday(&after, NULL);
  long long after_millis = after.tv_sec*1000LL + after.tv_usec/1000;

  return after_millis-before_millis;
}

long long time_elapsed_worsecase(int n)
{
  int *arr = (int *) malloc(n * sizeof(int));

  for(int i = n-1; i >=0; i--) arr[i] = i;

  struct timeval before;
  gettimeofday(&before, NULL);
  long long before_millis = before.tv_sec*1000LL + before.tv_usec/1000;

  quick_sort(arr, n);

  struct timeval after;
  gettimeofday(&after, NULL);
  long long after_millis = after.tv_sec*1000LL + after.tv_usec/1000;

  return after_millis-before_millis;
}

void test_simple_inputs()
{
    // Test Case 1
    int input[] = {5, 3, 1, 9, 7};
    int expected_output[] = {1, 3, 5, 7, 9};
    quick_sort(input, 5);
    for(int i = 0; i < 5; i++) assert(input[i] == expected_output[i]);

    // Test Case 2
    int input2[] = {5, 3, 3, 9, 7};
    int expected_output2[] = {3, 3, 5, 7, 9};
    quick_sort(input2, 5);
    for(int i = 0; i < 5; i++) assert(input2[i] == expected_output2[i]);

    // Test Case 3
    int input3[] = {9, 7, 5, 3, 1};
    int expected_output3[] = {1, 3, 5, 7, 9};
    quick_sort(input3, 5);
    for(int i = 0; i < 5; i++) assert(input3[i] == expected_output3[i]);

    // Test Case 4
    int input4[] = {1, 3, 5, 7, 9};
    int expected_output4[] = {1, 3, 5, 7, 9};
    quick_sort(input4, 5);
    for(int i = 0; i < 5; i++) assert(input4[i] == expected_output4[i]);

    // Test Case 5
    int input5[] = {1, 1, 1, 1, 1};
    int expected_output5[] = {1, 1, 1, 1, 1};
    quick_sort(input5, 5);
    for(int i = 0; i < 5; i++) assert(input5[i] == expected_output5[i]);

}

int main()
{
    test_simple_inputs();

    long long t1 = time_elapsed_random(32000);
    long long t2 = time_elapsed_random(64000);
    printf("Random: %lf\n", t2*1.0/t1);

    long long t3 = time_elapsed_worsecase(32000);
    long long t4 = time_elapsed_worsecase(64000);
    printf("Worst Case: %lf\n", t4*1.0/t3);
}
