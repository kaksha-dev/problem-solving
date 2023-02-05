""" Problem : Reverse Linked List
Problem Id: Day 5, Problem 1
Onine Problem Link : https://leetcode.com/problems/two-sum/.

"""

class Solution:
    '''Merge two sorted linked lists. '''
    def reverse_list(self, list1, list2):
        '''Merges two sorted linked lists in O(N) time. '''
        head = ListNode()        
        x = head

        while list1 and list2:
            if list1.val <= list2.val:
                x.next = list1
                list1 = list1.next
            else:
                x.next = list2
                list2 = list2.next
            x = x.next
        
        if not list1:
            x.next = list2
        else:
            x.next = list1

        return head.next
