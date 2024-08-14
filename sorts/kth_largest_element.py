'''
https://leetcode.com/problems/kth-largest-element-in-an-array/description/

Constraints:
1 <= k <= nums.length <= 10**5
-10**4 <= nums[i] <= 10**4

'''

import random

def quick_select(nums, k):
    pivot = random.choice(nums)
    left, mid, right = [], [], []

    for num in nums:
        if num > pivot:
            left.append(num)
        elif num < pivot:
            right.append(num)
        else:
            # Important to maintain a separate array of elements equal to the
            # pivot. This ensures we are able to exit early if the kth largest
            #  element is equal to the pivot element.
            mid.append(num)
            
    if k <= len(left):
        return quick_select(left, k)
    
    if len(left) + len(mid) < k:
        return quick_select(right, k - len(left) - len(mid))
    
    return pivot

def findKthLargest(nums, k):
    return quick_select(nums, k)

def testCases():
    assert findKthLargest([3, 2, 1, 5, 6, 4], 2) == 5
    assert findKthLargest([3, 2, 3, 1, 2, 4, 5, 5, 6], 4) == 4

testCases()
