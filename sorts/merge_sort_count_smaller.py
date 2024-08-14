'''
https://leetcode.com/problems/count-of-smaller-numbers-after-self/description/ 
'''

def merge(nums, aux, left, mid, right):
    for k in range(left, right+1):
        aux[k] = nums[k]

    inversion_count_per_element = 0 

    i, j = left, mid+1
    for k in range(left, right+1):
        if i > mid:
            nums[k] = aux[j]
            j += 1
        elif j > right:
            nums[k] = aux[i]
            nums[k][2] += inversion_count_per_element
            i += 1
        elif aux[i][0] <= aux[j][0]:
            nums[k] = aux[i]
            nums[k][2] += inversion_count_per_element
            i += 1
        else:
            nums[k] = aux[j]
            # Element at the right side of the array is smaller than current
            # element at the current index at the left side. Every subsequent
            # element nums[i ... mid] would be larger than nums[j]
            inversion_count_per_element += 1
            j += 1

def merge_sort(nums, aux, left, right):
    if left >= right: return
    
    mid = (left+right)//2
    merge_sort(nums, aux, left, mid)
    merge_sort(nums, aux, mid+1, right)
    merge(nums, aux, left, mid, right)

def countSmaller(nums):
    n = len(nums)
    aux = []
    nums_copy = []
    for index, num in enumerate(nums):
        nums_copy.append([num, index, 0])
        aux.append([num, index, 0])
    merge_sort(nums_copy, aux, 0, n-1)
    
    count_smaller = [0]*n
    for item in nums_copy:
        count_smaller[item[1]] = item[2]

    return count_smaller

def testSimple():
    assert countSmaller([5, 2, 6, 1]) == [2, 1, 1, 0]
    assert countSmaller([-1]) == [0]
    assert countSmaller([-1, -1]) == [0, 0]
    assert countSmaller([2, 0, 1]) == [2, 0, 0]

testSimple()