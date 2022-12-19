""" Problem : Merge two sorted Arrays without extra space
Problem Id: Day 2, Problem 3
Onine Problem Link : https://leetcode.com/problems/merge-sorted-array/.

Solution Approach:
    1. Start filling nums1 from end
    2. PseudoCode:
        a) If nums1 has been processsed copy elements from num2 to num1 and exit
        b) if nums2 has been processed, nums1 is already sorted. Exit
        c) Shift largest element at index m-1 of nums1 and n-1 index nums2 to the end 
           of the nums1 array and adjust indexes
"""

def merge_arrays(nums1, m, nums2, n):
    """ Merge arrays nums1 and nums2 into a single array sorted in non-decreasing order.

    Arguments:
    nums1 -- First sorted array with m+n elements with nums[m....m+n-1] = 0
    m -- Number of sorted elements in first array
    num2 -- Sorted Second array with size n
    n -- Number of elements in second array
    """
    i, j, k = m-1, n-1, m+n-1

    while k >= 0:
        if i < 0:
            nums1[k] = nums2[j]
            j -= 1
        elif j < 0:
            break
        elif nums2[j] > nums1[i]:
            nums1[k] = nums2[j]
            j -= 1
        else:
            nums1[k] = nums1[i]
            i -= 1
        k -= 1
    return nums1
