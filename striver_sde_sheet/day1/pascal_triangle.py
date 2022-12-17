""" Problem : Pascal's Triangle
Problem Id: Day 1, Problem 2
Onine Problem Link : https://leetcode.com/problems/pascals-triangle/
"""

def pascal_triangle(n):
    """ Return the rows of Pascal's triangle.

    Arguments:
    n -- number of rows to be returned
    """
    triangle = [[1]*i for i in range(1, n+1)]
    for i in range(2, n):
        for j in range(1, i):
            triangle[i][j] = triangle[i-1][j-1]+triangle[i-1][j]
    return triangle
