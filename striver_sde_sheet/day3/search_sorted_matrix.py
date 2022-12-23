""" Problem : Rotate Matrix
Problem Id: Day 3, Problem 1
Onine Problem Link : https://leetcode.com/problems/search-a-2d-matrix/.

"""

from bisect import bisect_left

def search_matrix(matrix, target):
    '''Searches for a value target in matrix.'''
    target_row = -1
    ncols = len(matrix[0])

    for i, row in enumerate(matrix):
        if row[ncols-1] == target:
            return True
        elif row[ncols-1] > target:
            target_row = i
            break

    if target_row < 0:
        return False

    insertion_point = bisect_left(matrix[target_row], target, 0, ncols)
    if insertion_point < ncols and matrix[target_row][insertion_point] == target:
        return True
    return False

def search_matrix_optimized(matrix, target):
    '''Searches for a value target in matrix.'''
    if not matrix or target is None:
        return False

    rows, cols = len(matrix), len(matrix[0])
    low, high = 0, rows * cols - 1

    while low <= high:
        mid = (low + high) // 2
        num = matrix[mid // cols][mid % cols]

        if num == target:
            return True
        elif num < target:
            low = mid + 1
        else:
            high = mid - 1

    return False
