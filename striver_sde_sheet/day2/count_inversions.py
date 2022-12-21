""" Problem : Inversion of Array
Problem Id: Day 2, Problem 6
Onine Problem Link : https://www.codingninjas.com/codestudio/problems/615.

"""

def count_inversions(arr):
    """ Given an array, count the inversions.

    Arguments:
    arr -- input arr
    """
    aux = [0] * len(arr)
    return merge_sort(arr, aux, 0, len(arr)-1)

def merge_sort(arr, aux, low,  high):
    ''' Sorts an array while counting the inversions.

    '''
    inv_count = 0
    if low < high:
        mid = (low+high)//2
        inv_count += merge_sort(arr, aux, low, mid)
        inv_count += merge_sort(arr, aux, mid+1, high)

        inv_count += merge(arr, aux, low, mid, high)
    return inv_count

def merge(arr, aux, low, mid, high):
    ''' Sorts sub arrays while counting the inversions.

    '''
    i, j = low, mid+1
    inv_count = 0

    for k in range(low, high+1):
        if i > mid:
            aux[k] = arr[j]
            j += 1
        elif j > high:
            aux[k] = arr[i]
            i += 1
        elif arr[i] > arr[j]:
            aux[k] = arr[j]
            j += 1
            inv_count += mid-i+1
        else:
            aux[k] = arr[i]
            i += 1

    for k in range(low, high+1):
        arr[k] = aux[k]

    return inv_count
