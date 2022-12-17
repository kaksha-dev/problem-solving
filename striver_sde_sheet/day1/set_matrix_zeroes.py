""" Problem : Set Matrix Zeroes
Problem Id: Day 1, Problem 1
Onine Problem Link : https://leetcode.com/problems/set-matrix-zeroes/
"""

def set_zeroes(matrix):
    """ Given an m x n integer matrix matrix, if an element is 0,
    set its entire row and column to 0's.

    Arguments:
    matrix -- input two dimensional matrix
    """
    rows = len(matrix)
    cols = len(matrix[0])
    row, col = 0, 0

    for i in range(rows):
        for j in range(cols):
            if not matrix[i][j]:
                row = (1 << i) | row
                col = (1 << j) | col

    for i in range(rows):
        if (1 << i) & row:
            for j in range(cols):
                matrix[i][j] = 0

    for j in range(cols):
        if (1 << j) & col:
            for i in range(rows):
                matrix[i][j] = 0

    return matrix
