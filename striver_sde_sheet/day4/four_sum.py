""" Problem : 4 Sum
Problem Id: Day 4, Problem 2
Onine Problem Link : https://leetcode.com/problems/4sum/.

Ofificial Solution: https://leetcode.com/problems/4sum/solutions/666283/4sum/

"""

from collections import defaultdict

def four_sum(nums, target):
    """ Given an array and target, returns all unique quadruplets
    [nums[a], nums[b], nums[c], nums[d]] such that
      1. 0 <= 1, b, c, d < n
      2. a, b, c and d are distinct
      3. nums[a] + nums[b] + nums[c] + nums[d] = target

    Arguments:
    nums -- input array
    target -- sum of four numbers to be found out
    """
    pair_sum = defaultdict(list)
    lnums = len(nums)
    output = []

    for i in range(lnums):
        for j in range(i+1, lnums):
            pair_sum[nums[i]+nums[j]].append((i, j))

    for psum, indices in pair_sum.items():
        if target-psum in pair_sum:
            for lindices in indices:
                for rindices in pair_sum[target-psum]:
                    if lindices[0] == rindices[0] or lindices[0] == rindices[1] or \
                        lindices[1] == rindices[0] or lindices[1] == rindices[1]:
                        continue
                    l = [nums[lindices[0]], nums[lindices[1]], nums[rindices[0]], nums[rindices[1]]]
                    if tuple(sorted(l)) not in output:
                        output.append(tuple(sorted(l)))
    return [list(t) for t in output]

def four_sum_optimized(nums, target):
    """ Given an array and target, returns all unique quadruplets
    [nums[a], nums[b], nums[c], nums[d]] such that
      1. 0 <= 1, b, c, d < n
      2. a, b, c and d are distinct
      3. nums[a] + nums[b] + nums[c] + nums[d] = target

    Arguments:
    nums -- input array
    target -- sum of four numbers to be found out
    """
    output = []
    nums.sort()
    lnums = len(nums)
    i = 0
    while i < lnums:
        nums_1 = nums[i]
        j = i+1
        while j < lnums:
            nums_2 = nums[j]
            pair_sum = target - (nums_1+nums_2)
            left, right = j+1, lnums-1
            while left < right:
                pair_sum_candidate = nums[left] + nums[right]
                if pair_sum_candidate < pair_sum:
                    left += 1
                elif pair_sum_candidate > pair_sum:
                    right -= 1
                elif pair_sum == pair_sum_candidate:
                    quadruplet = [nums_1, nums_2, nums[left], nums[right]]
                    output.append(quadruplet)
                    while left < right and nums[left] == quadruplet[2]:
                        left += 1
                    while left < right and nums[right] == quadruplet[3]:
                        right -= 1
            while j < lnums and nums[j] == nums_2:
                j += 1
        while i < lnums and nums[i] == nums_1:
            i += 1
    return output
