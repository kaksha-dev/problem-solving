from collections import defaultdict

def nextGreaterElement(nums1, nums2):
    d = {}
    d = defaultdict(lambda: -1, d)

    monotonic_stack = []
    for x in nums2:
        while len(monotonic_stack) > 0 and monotonic_stack[-1] < x:
            d[monotonic_stack.pop()] = x
        monotonic_stack.append(x)
    
    output = []
    for i in range(len(nums1)):
        output.append(d[nums1[i]])
    
    return output

def test_nge():
    assert nextGreaterElement([4,1,2], [1, 3, 4, 2]) == [-1, 3, -1]
    assert nextGreaterElement([2, 4], [1, 2, 3, 4]) == [3, -1]

test_nge()