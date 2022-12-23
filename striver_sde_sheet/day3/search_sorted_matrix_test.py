""" Test cases for https://leetcode.com/problems/search-a-2d-matrix/. """

import unittest
from search_sorted_matrix import search_matrix, search_matrix_optimized

class SearchMatrixTest(unittest.TestCase):
    """ Test class. """
    def test_1(self):
        """ Testcase 1. """
        self.assertEqual(
            search_matrix(
                [[1,3,5,7],[10,11,16,20],[23,30,34,60]], 3),
                True)
        self.assertEqual(
            search_matrix_optimized(
                [[1,3,5,7],[10,11,16,20],[23,30,34,60]], 3),
                True)

    def test_2(self):
        """ Testcase 2. """
        self.assertEqual(
            search_matrix(
                [[1,3,5,7],[10,11,16,20],[23,30,34,60]], 13),
                False)
        self.assertEqual(
            search_matrix_optimized(
                [[1,3,5,7],[10,11,16,20],[23,30,34,60]], 13),
                False)
    
    def test_3(self):
        """ Testcase 3. """
        self.assertEqual(
            search_matrix(
                [[1,3]], 3),
                True)
        self.assertEqual(
            search_matrix_optimized(
                [[1,3]], 3),
                True)

if __name__ == '__main__':
    unittest.main()