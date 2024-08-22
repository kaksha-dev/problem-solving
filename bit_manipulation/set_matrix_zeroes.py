'''
https://leetcode.com/problems/set-matrix-zeroes/ 
'''

def setZeroes(matrix):
    m = len(matrix)
    n = len(matrix[0])
    r, c  = 0, 0

    # Since we need constant space, bits of r store if there is any element in
    # the row which is zero. For example, if matrix[2][3] = 0 r would be xx.xxx100
    for i in range(m):
        for j in range(n):
            if not matrix[i][j]:
                r = (1 << i) | r
                c = (1 << j) | c
        
    for i in range(m):
        if (1 << i) & r:
            for j in range(n):
                matrix[i][j] = 0

    for j in range(n):
        if (1 << j) & c:
            for i in range(m):
                matrix[i][j] = 0
    return matrix

def testCases():
    assert setZeroes([[1, 1, 1],[1, 0, 1], [1, 1, 1]]) == \
        [[1, 0, 1],[0, 0, 0],[1, 0, 1]]
    assert setZeroes([[0, 1, 2, 0],[3, 4, 5, 2],[1, 3, 1, 5]]) == \
        [[0, 0, 0, 0],[0, 4, 5, 0], [0, 3, 1, 0]]

testCases()