""" Problem : Subarray with given XOR
Problem Id: Day 4, Problem 5
Onine Problem Link : https://www.interviewbit.com/problems/subarray-with-given-xor/.

"""

from collections import defaultdict

def subarrays_given_xor(nums, target):
    """ Given an array and target, returns total number of subarrays
    having bitwise XOR of all elements equals to target

    Arguments:
    nums -- input array
    target -- sum of two numbers to be found out
    """
    prefix_xors = defaultdict(int)
    count = 0
    current_xor = 0

    for num in nums:
        current_xor ^= num
        if current_xor == target:
            count += 1

        if current_xor^target in prefix_xors:
            count += prefix_xors[current_xor^target]

        prefix_xors[current_xor] += 1

    return count
