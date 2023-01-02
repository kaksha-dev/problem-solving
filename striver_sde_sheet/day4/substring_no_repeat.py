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
    longest_cnt = 0
    current_cnt = 0
    char_index_map = defaultdict(int)

    for i, c in enumerate(s):
        if c not in char_index_map:
            current_cnt += 1
            char_index_map[c] = i
            longest_cnt = max(longest_cnt, current_cnt)
        else:
            prev = char_index_map[c]
            longest_cnt = max(longest_cnt, i-prev)
            char_index_map = {key:val for key, val in char_index_map.items() if val >=prev}
            char_index_map[c] = i
            current_cnt = i-prev
    return longest_cnt
