'''
https://leetcode.com/problems/median-of-two-sorted-arrays 

'''

def find_kth_smallest_element(nums1, nums2, 
                           left_nums1, right_nums1,
                           left_nums2, right_nums2,
                           k):
    # Base Case
    if left_nums1 > right_nums1:
        return nums2[k-left_nums1]
    
    if left_nums2 > right_nums2:
        return nums1[k-left_nums2]

    mid_nums1 = (left_nums1 + right_nums1) // 2
    mid_nums2 = (left_nums2 + right_nums2) // 2

    if k <= mid_nums1+mid_nums2:
        if nums1[mid_nums1] < nums2[mid_nums2]:
            return find_kth_smallest_element(nums1, nums2,
                                             left_nums1, right_nums1,
                                             left_nums2, mid_nums2-1,
                                             k)
        else:
            return find_kth_smallest_element(nums1, nums2,
                                             left_nums1, mid_nums1-1,
                                             left_nums2, right_nums2,
                                             k)
    else:
        if nums1[mid_nums1] < nums2[mid_nums2]:
            return find_kth_smallest_element(nums1, nums2,
                                             mid_nums1+1, right_nums1,
                                             left_nums2, right_nums2,
                                             k)
        else:
            return find_kth_smallest_element(nums1, nums2,
                                             left_nums1, right_nums1,
                                             mid_nums2+1, right_nums2,
                                             k)

def get_middle_indexes(m, n):
    # If combined length of arrays is odd, index of middle element : (m+n)//2
    # If combined length of arrays is even, indexes of middle elements are :
    # (m+n)//2, (m+n)//2-1
    if (m+n)%2:
        return [(m+n)//2]
    else:
        return [(m+n)//2-1, (m+n)//2]

def findMedianSortedArrays(nums1, nums2):
    m = len(nums1)
    n = len(nums2)

    indexes = get_middle_indexes(m, n)
    return sum([
        find_kth_smallest_element(nums1, nums2,
                               0, m-1,
                               0, n-1,
                               index) for index in indexes]) / len(indexes)

def testCases():
    assert get_middle_indexes(2, 1) == [1]
    assert get_middle_indexes(2, 2) == [1, 2]
    assert get_middle_indexes(1, 0) == [0]
    assert get_middle_indexes(6, 6) == [5, 6]
    assert get_middle_indexes(5, 6) == [5]
    
    assert findMedianSortedArrays([1, 3], [2]) == 2.0
    assert findMedianSortedArrays([1, 2], [3, 4]) == 2.5

testCases()