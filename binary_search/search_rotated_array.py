'''
https://leetcode.com/problems/search-in-rotated-sorted-array 
'''


def findMiddleIndex(left, right, partition, larr):
    # Indexes if no partition
    left = (left - partition) % larr
    right = (right - partition) % larr
    mid = (left + right) // 2

    # middle index with partition factored in
    return (mid + partition) % larr


def partition(nums, left, right):
    if left > right:
        return 0

    mid = (left+right) // 2
    if nums[mid] < nums[0] and nums[mid-1] > nums[mid]:
        # Middle element is the partition element
        return mid
    elif nums[mid] < nums[0]:
        return partition(nums, left, mid-1)
    else:
        # Partiion is at the right side of the array
        return partition(nums, mid+1, right)
        

def searchTarget(nums, left, right, p, target):
    if left == right:
        if nums[left] == target: return left
        else: return -1

    n = len(nums)
    mid = findMiddleIndex(left, right, p, n)
    if nums[mid] == target:
        return mid
    elif nums[mid] < target:
        return searchTarget(nums, (mid+1)%n, right, p, target)
    else:
        return searchTarget(nums, left, (mid)%n, p, target)

def search(nums, target):
    n = len(nums)
    p = partition(nums, 0, n-1)

    return searchTarget(nums, p, (n-1+p)%n, p, target)


def testCases():
    assert partition([0, 1, 2, 3, 4, 5], 0, 5) == 0
    assert partition([0, 1, 2, 3, 4], 0, 4) == 0
    assert partition([5, 0, 1, 2, 3, 4], 0, 5) == 1
    assert partition([1, 2, 3, 4, 5, 0], 0, 5) == 5
    assert partition([4, 5, 0, 1, 2, 3], 0, 5) == 2
    assert partition([2, 2, 2, 2, 2, 2, 2, 2, 2, 1], 0, 9) == 9
    assert partition([2, 2, 2, 2, 2, 2, 2, 2, 2, 2], 0, 9) == 0

    assert findMiddleIndex(0, 5, 0, 6) == 2
    assert findMiddleIndex(0, 4, 0, 5) == 2
    assert findMiddleIndex(1, 0, 1, 6) == 3

    assert search([4, 5, 6, 7, 0, 1, 2], 0) == 4
    assert search([4, 5, 6, 7, 0, 1, 2], 7) == 3
    assert search([4, 5, 6, 7, 0, 1, 2], 8) == -1
    assert search([4, 5, 6, 7, 0, 1, 2], 3) == -1
    assert search([1], 0) == -1
    assert search([1], 1) == 0
    assert search([1, 3], 0) == -1


testCases()
