'''
Example Segment Tree Implementation - Range Query Sum (Mutable)
https://leetcode.com/problems/range-sum-query-mutable/description/

'''

import math

class NumArray:
    segment_tree = None
    nums = None
    N = 0
    n = 0

    def __init__(self, nums):
        self.n = len(nums)
        self.nums = nums
        if math.log(self.n, 2).is_integer(): self.N = 2*self.n-1
        else: self.N = 2*(2**(int(math.log(self.n, 2))+1))-1

        self.segment_tree = [0] * self.N
        self.createTree(nums, 0, self.n-1, 0)

    def createTree(self, nums, left, right, pos):
        if left >= right:
            self.segment_tree[pos] = nums[left]
            return
        
        mid = (left+right) // 2
        self.createTree(nums, left, mid, 2*pos+1)
        self.createTree(nums, mid+1, right, 2*pos+2)
        self.segment_tree[pos] = self.segment_tree[2*pos+1] + \
            self.segment_tree[2*pos+2]

    
    def updateSegTree(self, left, right, index, val, pos):
        if left == index:
            self.segment_tree[pos] = val
            return
        
        mid = (left+right) // 2
        if index <= mid: self.updateSegTree(left, mid, index, val, 2*pos+1)
        else: self.updateSegTree(mid+1, right, index, val, 2*pos+2)
        self.segment_tree[pos] = self.segment_tree[2*pos+1] + \
            self.segment_tree[2*pos+2]        
    
    def update(self, index, val) -> None:
        self.nums[index] = val
        self.updateSegTree(0, self.n-1, index, val, 0)

    def sumRange(self, left, right):
        return self.sumRangeQuery(left, right, 0, self.n-1, 0)


    def sumRangeQuery(self, left, right, low, high, pos):
        if left <= low and right >= high: # Total Overlap
            return self.segment_tree[pos]
        
        if left > high or right < low: # No Overlap
            return 0
        
        mid = (low+high) // 2
        return self.sumRangeQuery(left, right, low, mid, 2*pos+1) + \
            self.sumRangeQuery(left, right, mid+1, high, 2*pos+2)
    

def testSumRange():
    segmentTree = NumArray([1, 3, 5])
    assert segmentTree.sumRange(0, 2) == 9
    assert segmentTree.sumRange(1, 2) == 8
    assert segmentTree.sumRange(0, 1) == 4
    assert segmentTree.sumRange(0, 0) == 1
    assert segmentTree.sumRange(1, 1) == 3
    assert segmentTree.sumRange(2, 2) == 5

    segmentTree.update(1, 2)
    assert segmentTree.sumRange(0, 2) == 8
    assert segmentTree.sumRange(1, 2) == 7
    assert segmentTree.sumRange(0, 1) == 3
    assert segmentTree.sumRange(0, 0) == 1
    assert segmentTree.sumRange(1, 1) == 2
    assert segmentTree.sumRange(2, 2) == 5

    segmentTree = NumArray([-28,-39,53,65,11,-56,-65,-39,-43,97])
    assert segmentTree.sumRange(5, 6) == -121


if __name__ == "__main__":
    testSumRange()