""" Problem : Longest Consecutive Seqience
Problem Id: Day 4, Problem 3
Onine Problem Link : https://leetcode.com/problems/longest-consecutive-sequence/.

Solution Discussion:
  https://takeuforward.org/data-structure/longest-consecutive-sequence-in-an-array/

"""

def longest_consecutive(nums):
    """ Given an unsorted array of integers nums, return the length
    of the longest consecutive elements sequence.

    Arguments:
    nums -- input array
    """
    len_largest_lcs = 0
    unique_elements = set(nums)

    for num in nums:
        if num-1 in unique_elements:
            continue

        lcs = 1
        k = num
        while k+1 in unique_elements:
            lcs += 1
            k += 1
        len_largest_lcs = max(len_largest_lcs, lcs)

    return len_largest_lcs
