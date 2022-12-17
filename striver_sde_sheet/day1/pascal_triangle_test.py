""" Test cases for https://leetcode.com/problems/pascals-triangle/. """

import unittest
from pascal_triangle import pascal_triangle

class PascalTriangleTest(unittest.TestCase):
    """ Test class. """
    def test_1(self):
        """ Testcase 1. """
        self.assertEqual(pascal_triangle(1),
            [[1]])

    def test_2(self):
        """ Testcase 2. """
        self.assertEqual(pascal_triangle(5),
            [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]])

if __name__ == '__main__':
    unittest.main()
