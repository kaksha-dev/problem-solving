""" Problem : Next Permutation
Problem Id: Day 1, Problem 3
Onine Problem Link : https://leetcode.com/problems/next-permutation/ 

Solution - Key points:
    1. If there is a next lexicographical order, series can be monotonically decreasing.
    2. At the point, where decreasing order is broken, left  element can be replaced.
    3. Left element can be exchanged with the smallest greater element at the right to form
       next lexicographical ordering.
    4. The array elements at the right of left exchanged element is in decreasing order.
    5. The array elements at the right of left exchanged element needs to be sorted in increasing
       order to form the next lexicographical ordering.
"""

def next_permutation(nums):
    """ Given a list of inetgers, finds the next lexicograhically
    greater permutation.

    Arguments:
    nums -- Input permutation
    """

    # Find the inflection point.
    i = len(nums)-2
    while i >= 0:
        if nums[i+1] > nums[i]:
            break
        i -= 1

    # If element is in montonically decreasing, change the order
    if i < 0:
        nums.reverse()
        return nums

    # Find smallest element bigger than nums[i]
    for j in range(len(nums)-1, i, -1):
        if nums[j] > nums[i]:
            nums[i], nums[j] = nums[j], nums[i]
            break

    # Reverse from i+1 to end of the list
    left, right = i+1, len(nums)-1
    while left < right:
        nums[left], nums[right] = nums[right], nums[left]
        left += 1
        right -= 1

    return nums
