""" Problem : Kadane Algorithm
Problem Id: Day 1, Problem 4
Onine Problem Link : https://leetcode.com/problems/maximum-subarray/

DP Solution - Problem statement and Recurrence Relation:
    1. Let A[i] be the largest sum of subarray where 0 <= i <=n ending at i
    2. A[i+1] = max(nums[i+1], A[i]+nums[i+1])
    3. Return max(A)
"""

def max_sub_array(nums):
    """ Given an integer array nums, returns the subarray
    which has the largest sum and return its sum.

    Arguments:
    nums -- Input integer array
    """
    n = len(nums)
    A = [0] * n
    A[0] = nums[0]

    for i in range(1, n):
        A[i] = max(nums[i] + A[i-1], nums[i])

    return max(A)
