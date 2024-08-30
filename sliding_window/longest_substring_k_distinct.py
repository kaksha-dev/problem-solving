'''
https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters
'''

from collections import defaultdict

def lengthOfLongestSubstringKDistinct(s, k):
    if not k: return 0
    
    left, right = 0, 0
    d = defaultdict(int)
    n = len(s)
    result = 0
    incr = True

    while right < n:
        # Add character to the map only if right index has been incremented
        # Otherwise it has been accounted for already
        if incr: d[s[right]] += 1
        if len(d) <= k:
            # Problem Statement signifies atmost k. If distinct characters
            # in map are less than k, modify result if we find a bigger value
            result = max(result, right-left+1)
            right += 1 
            incr = True
        else:
            d[s[left]] -= 1
            if not d[s[left]]:
                d.pop(s[left])
            # Adjusting left is necessary otherwise we will always get
            # ditintct characters more than k
            left += 1
            incr = False
    return result    
    

def testCases():
    assert lengthOfLongestSubstringKDistinct("eceba", 2) == 3
    assert lengthOfLongestSubstringKDistinct("aa", 1) == 2

testCases()