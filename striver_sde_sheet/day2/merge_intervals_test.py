""" Test cases for https://leetcode.com/problems/merge-intervals. """

import unittest
from merge_intervals import merge_overlapping_intervals

class MergeOverlappingIntervalsTest(unittest.TestCase):
    """ Test class. """
    def test_1(self):
        """ Testcase 1. """
        self.assertEqual(
            merge_overlapping_intervals(
                [[1,3],[2,6],[8,10],[15,18]]),
                [[1,6],[8,10],[15,18]])

    def test_2(self):
        """ Testcase 2. """
        self.assertEqual(
            merge_overlapping_intervals(
                [[1,4],[4,5]]),
                [[1,5]])

if __name__ == '__main__':
    unittest.main()
