""" Problem : Longest Substring Without Repeating Characters.
Problem Id: Day 4, Problem 6
Onine Problem Link : https://leetcode.com/problems/longest-substring-without-repeating-characters/.

Solution:
https://leetcode.com/problems/longest-substring-without-repeating-characters/solutions/127839/longest-substring-without-repeating-characters/

"""

from collections import defaultdict

def longest_substring_no_repeat(s):
    """ Given a string s, find the length of the longest substring
    without repeating characters.

    Arguments:
    s -- input string
    """
    left = right = 0
    longest_count = 0
    d = defaultdict(int)

    while right < len(s):
        if s[right] in d and left <= d[s[right]] < right:
            left = d[s[right]]+1
        longest_count = max(longest_count, right-left+1)
        d[s[right]] = right
        right += 1

    return longest_count
