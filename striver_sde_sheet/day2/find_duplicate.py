""" Problem : Find the Duplicate Number
Problem Id: Day 2, Problem 4
Onine Problem Link : https://leetcode.com/problems/find-the-duplicate-number/.

Solution:
    1. Initialize an integer x to zero
    2. For each number num in the list
       a) check of the num bit in x is set to 1. If yes, we have found the duplicate number
       b) Else: Set the num bit in x to 1

Seven approaches to solve the problem:
https://leetcode.com/problems/find-the-duplicate-number/solutions/127594/find-the-duplicate-number/
"""

def find_duplicate(nums):
    """ Returns the duplicate number in an array of integers containing n+1
    integers where each integer is in the range [1, n].

    Arguments:
    nums -- input array
    """
    x = 0
    for num in nums:
        if (x >> num) & 1 == 1:
            return num
        else:
            x = x | (1 << num)
    return None
