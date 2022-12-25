""" Problem : Rotate Matrix
Problem Id: Day 3, Problem 2
Onine Problem Link : https://leetcode.com/problems/powx-n/.

Solution Approach:
  1. Maintain a variable ans to store the final answer.
  2. If k is even,square n and divide k by 2. As nk can be written as 
     (n2)k/2  i.e (n*n)k/2.
  3. If k is odd,multiply ans with n and reduce k by 1,as nk can be 
     written as n*(n)k-1.Print the ans.

"""

def myPow(x, n):
    '''Given a double x and integer n, returns x raised to power n'''
    num = n
    num = abs(num)
    ans = 1.0

    while num > 0:
        if num%2:
            ans = ans*x
            num -= 1
        else:
            x *= x
            num = num//2

    if n < 0:
        ans = 1.0/ans
   
    return round(ans, 5)
