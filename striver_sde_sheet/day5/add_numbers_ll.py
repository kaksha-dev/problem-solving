""" Problem : Add two numbers represented as Linked Lists.
Problem Id: Day 5, Problem 5
Onine Problem Link : https://leetcode.com/problems/add-two-numbers/.

"""

class ListNode:
    '''
    Linked List Structure.
    '''
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    '''Add two numbers represented as Linked Lists. '''
    def addTwoNumbers(self, l1, l2):
        l = None
        carry = 0
        head = None

        while l1 and l2:
            x = ListNode()
            x.val = (l1.val+l2.val+carry)%10
            carry = (l1.val+l2.val+carry)//10
            if l: 
                l.next = x
                l = l.next
            else: 
                l = x
                head = l
            l1 = l1.next
            l2 = l2.next
        
        while l1:
            x = ListNode()
            x.val = (l1.val+carry)%10
            carry = (l1.val+carry)//10
            l.next = x
            l = l.next
            l1 = l1.next
        
        while l2:
            x = ListNode()
            x.val = (l2.val+carry)%10
            carry = (l2.val+carry)//10
            l.next = x
            l = l.next
            l2 = l2.next
        
        if not l1 and not l2 and carry:
            x = ListNode()
            x.val = 1
            l.next = x
        
        return head





