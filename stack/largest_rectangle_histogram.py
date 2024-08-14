'''
https://leetcode.com/problems/largest-rectangle-in-histogram

'''
def calculate_max_area(heights):
    # Maintain a monotonic stack with largest element at the top.
    stack = []
    N = len(heights)
    max_area = -1

    for i in range(N):
        if not len(stack) or heights[i] > stack[-1][1]:
            stack.append((i, heights[i]))
        else:
            min_index = i
            while len(stack) and heights[i] <= stack[-1][1]:
                # Monotoncity will be broken if we insert a smaller element at
                # the top. Keep popping till we find element smaller than the
                # current element
                rect = stack.pop()
                # Current Element to be inserted at the top can extend to the
                # left side of the array. Hence, maintaining a min_index to
                # ensure maximum area pertaining to the current element can
                # account both for left and right sides.
                min_index = rect[0]
                max_area = max(max_area, rect[1]*(i-rect[0]))
            stack.append((min_index, heights[i]))

    # A monotonic stack is remaining. We have already accomodate how far
    # each integer can expand to the left. Since every element at the right
    # of the element at top will be greater current element can extend all
    # the way to the end.
    while len(stack):
        rect = stack.pop() 
        max_area = max(max_area, rect[1]*(N-rect[0]))
    
    return max_area

def largestRectangleArea(heights):
    return calculate_max_area(heights[::-1])
    

def test_lra():
    assert largestRectangleArea([2,1,5,6,2,3]) == 10
    assert largestRectangleArea([2,4]) == 4
    assert largestRectangleArea([1, 3, 1]) == 3
    assert largestRectangleArea([1, 2, 1]) == 3
    assert largestRectangleArea([5, 4, 3, 2, 1]) == 9
    assert largestRectangleArea([1, 2, 3, 4, 5]) == 9
    assert largestRectangleArea([2, 1, 2]) == 3

test_lra()