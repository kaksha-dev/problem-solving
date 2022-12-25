""" Problem : Majority Element that occurs more than N/2 times.
    Problem Id: Day 3, Problem 3
    Onine Problem Link : https://leetcode.com/problems/majority-element/.

    Possible Solutions: 
        https://leetcode.com/problems/majority-element/solutions/127412/majority-element/

"""
from collections import defaultdict

def majority_element(nums):
    """Given an array nums of size n, return the majority element."""
    d = defaultdict(int)

    for num in nums:
        d[num] += 1

    for key in d:
        if d[key] > len(nums)//2:
            return key

    return None
