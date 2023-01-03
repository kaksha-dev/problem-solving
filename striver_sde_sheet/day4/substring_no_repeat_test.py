""" Test cases for https://leetcode.com/problems/longest-substring-without-repeating-characters/. """

import unittest
from substring_no_repeat import longest_substring_no_repeat

class LongestSubstringNoRepeatTest(unittest.TestCase):
    """ Test class. """
    def test_1(self):
        """ Testcase 1. """
        self.assertEqual(
            longest_substring_no_repeat(
                "abcabcbb"),
                3)

    def test_2(self):
        """ Testcase 2. """
        self.assertEqual(
            longest_substring_no_repeat(
                "bbbbb"),
                1)

    def test_3(self):
        """ Testcase 3. """
        self.assertEqual(
            longest_substring_no_repeat(
                "pwwkew"),
                3)
    
    def test_4(self):
        """ Testcase 4. """
        self.assertEqual(
            longest_substring_no_repeat(
                "abba"),
                2)


if __name__ == '__main__':
    unittest.main()
