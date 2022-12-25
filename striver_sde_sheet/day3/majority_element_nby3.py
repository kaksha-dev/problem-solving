""" Problem : Majority Element that occurs more than N/3 times.
    Problem Id: Day 3, Problem 4
    Onine Problem Link : https://leetcode.com/problems/majority-element-ii/.

"""

def majority_element(nums):
    """Given an array nums of size n, return the majority element."""

    count_candidate_1 = 0
    count_candidate_2 = 0
    candidate1, candidate2 = None, None

    for num in nums:
        if num == candidate1:
            count_candidate_1 += 1
        elif num == candidate2:
            count_candidate_2 += 1
        elif count_candidate_1 == 0:
            candidate1 = num
            count_candidate_1 += 1
        elif count_candidate_2 == 0:
            candidate2 = num
            count_candidate_2 += 1
        else:
            count_candidate_1 -= 1
            count_candidate_2 -= 1

    ans = []
    count1, count2 = 0, 0
    for num in nums:
        if num == candidate1:
            count1 += 1
        if num == candidate2:
            count2 += 1

    if count1 > len(nums)//3:
        ans.append(candidate1)
    if count2 > len(nums)//3:
        ans.append(candidate2)

    return ans
