'''
https://leetcode.com/problems/next-greater-element-ii/description/
'''
def nextGreaterElements(nums) :
    output = [-1] * len(nums)
    stack = []
    N = len(nums)

    for i in range(N):
        while len(stack) > 0 and nums[i] > stack[-1][1]:
            item = stack.pop()
            output[item[0]] = nums[i]
        stack.append((i, nums[i]))
    
    for i in range(N):
        if not len(stack):
            break
        while nums[i] > stack[-1][1]:
            item = stack.pop()
            output[item[0]] = nums[i]
    return output

def test_nge_2():
    assert nextGreaterElements([1, 2, 1]) == [2, -1, 2]
    assert nextGreaterElements([1, 2, 3, 4, 3]) == [2, 3, 4, -1, 4]

test_nge_2()