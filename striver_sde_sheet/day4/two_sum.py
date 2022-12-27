""" Problem : Two Sum
Problem Id: Day 4, Problem 1
Onine Problem Link : https://leetcode.com/problems/two-sum/.

"""

def two_sum(nums, target):
    """ Given an array and target, returns indices of the two numbers
    such that they add up to target

    Arguments:
    nums -- input array
    target -- sum of two numbers to be found out
    """
    arr = sorted(nums)

    i , j = 0, len(nums)-1
    nums_1, nums_2 = nums[0], nums[0]

    while i < j:
        if arr[i] + arr[j] == target:
            nums_1 = arr[i]
            nums_2 = arr[j]
            break
        elif arr[i] + arr[j] < target:
            i += 1
        else:
            j -= 1

    index1, index2 = 0, 0
    for i, num in enumerate(nums):
        if num == nums_1:
            index1 = i
            break

    for i, num in enumerate(nums):
        if num == nums_2 and i != index1:
            index2 = i
            break

    return [index1, index2]
