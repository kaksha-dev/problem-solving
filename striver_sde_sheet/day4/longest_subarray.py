""" Problem : Length of the longest subarray with zero Sum.

Problem Id: Day 4, Problem 4
Onine Problem Link : https://practice.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1.

"""

from collections import defaultdict

def length_longest_subarray(nums):
    """ Given an array having both positive and negative integers, returns the length
    of the largest subarray with sum 0.

    Arguments:
    nums -- input array
    """
    prefix_sum = defaultdict(int)
    lls = 0
    current_sum = 0

    for i, num in enumerate(nums):
        current_sum += num
        if not current_sum:
            lls = i+1
            continue
        if current_sum in prefix_sum:
            lls = max(lls, i-prefix_sum[current_sum])
        else:
            prefix_sum[current_sum] = i

    return lls
