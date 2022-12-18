""" Problem : Rotate Matrix
Problem Id: Day 2, Problem 1
Onine Problem Link : https://leetcode.com/problems/rotate-image/.

Solution Approach:
    1. Transpose the matrix.
    2. Reverse each row.

Interesting alternative solution at:
    https://leetcode.com/problems/rotate-image/solutions/1037232/rotate-image/.
"""

def rotate_matrix(matrix):
    """ Rotate a matrix in-plaae by 90 degrees clockwise

    Arguments:
    matrix -- input matrix to rotate
    """
    matrix_size = len(matrix)

    for i in range(matrix_size):
        for j in range(i):
            matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]

    for i in range(matrix_size):
        matrix[i].reverse()

    return matrix
