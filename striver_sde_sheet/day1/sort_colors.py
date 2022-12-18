""" Problem : Sort an array of 0's 1's 2's
Problem Id: Day 1, Problem 5
Onine Problem Link : https://leetcode.com/problems/sort-colors/

"""

def sort_colors(nums):
    """ Given an array consisting of only 0s, 1s and 2s, sort the array
    in-place with single pass and constant space

    Arguments:
    nums -- Input integer array
    """
    low, mid, high  = -1, -1, -1

    if not nums[0]:
        low = 0
    elif nums[0] == 1:
        mid = 0
    else:
        high = 0
    
    for i in range(1, len(nums)):
        if not nums[i]:
            if low > mid and low > high:
                low = i
            elif low < mid:
                nums[low+1], nums[i] = 0, 1
                low += 1
                if mid < high:
                    nums[mid+1], nums[i] = 1, 2
                    mid += 1
                    high = i
                else:
                    mid = i
            elif low < high:
                nums[low+1], nums[i] = 0, 2
                low += 1
                high = i
        elif nums[i] == 1:
            if mid >= high:
                mid = i
            elif high > mid and mid == -1:
                nums[low+1], nums[i] = 1, 2
                mid = low+1
                high = i
            else:
                nums[mid+1], nums[i] = 1, 2
                mid += 1
                high = i
        else:
            high = i
    return nums

def sort_colors_easy(nums):
    '''Easier to understand implementation. '''
    low = 0
    high = len(nums) - 1
    mid = 0

    while mid <= high:
        if not nums[mid]:
            nums[low], nums[mid] = nums[mid], nums[low]
            low += 1
            mid += 1
        elif nums[mid] == 1:
            mid += 1
        else:
            nums[mid], nums[high] = nums[high], nums[mid]
            mid += 1
            high -= 1
    return nums
