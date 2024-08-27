'''
https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters
'''

from collections import defaultdict

def countGoodSubstrings(s):
    d = defaultdict(int)
    ans = 0

    for i in range(3):
        d[s[i]] += 1
    
    if len(d) == 3: ans = 1

    for i in range(3, len(s)):
        d[s[i-3]] -= 1
        if not d[s[i-3]]:
            d.pop(s[i-3])

        d[s[i]] += 1
        if len(d) == 3:
            ans += 1
    
    return ans

def testCases():
    assert countGoodSubstrings("xyzzaz") == 1
    assert countGoodSubstrings("aababcabc") == 4

testCases()
