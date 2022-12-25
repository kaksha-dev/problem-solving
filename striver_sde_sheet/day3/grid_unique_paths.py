""" Problem :  Grid Unique Paths
Problem Id: Day 3, Problem 5
Onine Problem Link : https://leetcode.com/problems/unique-paths/.

"""

import operator as op
from functools import reduce


def unique_paths(rows, cols):
    '''Given the two integers, return the number of possible
    unique paths that the robot can take to reach the bottom-right corner

    Arguments:
    rows : number of rows in the grid.
    columns : number of columns in the grid.
    '''
    n, r = rows-1+cols-1, rows-1
    numer = reduce(op.mul, range(n, n-r, -1), 1)
    denom = reduce(op.mul, range(1, r+1), 1)
    return numer // denom
