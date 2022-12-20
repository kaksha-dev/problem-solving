""" Problem : Missing and repeating numbers
Problem Id: Day 2, Problem 4
Onine Problem Link : https://www.interviewbit.com/problems/repeat-and-missing-number-array.

Solution Approach:
    1. Taking a xor of all nautral numbers to n and numbers in the input array will give
       xor of missing and repeating number.
    2. For all set bits in the resultant xor, set bits either corresond to missing or repeating
       number.
    3. Keep only the set bit using x & ~(x-1) where x is the resultant xor.
    4. Form two buckets A and B.
        a. In first bucket xor all natural numners and numbers in the array which have the bit set.
        b. All remianing numbers, xor in the second bucket.
    5. Identify which is missing and repeating and return.

"""

def missing_repeating(arr, n):
    """ Returns the duplicate number in an array of integers 
    containing n+1 integers where each integer is in the range [1, n].

    Arguments:
    nums -- input array
    """
    xor = 0
    missing, repeating = 0, 0

    for num in arr:
        xor ^= num

    for i in range(1, n+1):
        xor ^= i

    # Inverts all set bits apart from the rightmost.
    right_set_bit = xor & ~(xor-1)

    for num in arr:
        if num & right_set_bit:
            missing ^= num
        else:
            repeating ^= num

    for i in range(1, n+1):
        if i & right_set_bit:
            missing ^= i
        else:
            repeating ^= i

    if missing in arr:
        missing, repeating = repeating, missing

    return (missing, repeating)
