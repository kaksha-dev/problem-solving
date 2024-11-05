/*
Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.

You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.



Example 1:

Input: nums = [1,2,0]
Output: 3
Explanation: The numbers in the range [1,2] are all in the array.
Example 2:

Input: nums = [3,4,-1,1]
Output: 2
Explanation: 1 is in the array but 2 is missing.
Example 3:

Input: nums = [7,8,9,11,12]
Output: 1
Explanation: The smallest positive integer 1 is missing.
 */
class FirstMissingPositive {
    public static int firstMissingPositive(int[] a) {

        for (int i = 0; i < a.length; i++) {
            if (a[i] < 0) a[i] = 0;
        }
        for (int i = 0; i < a.length; i++) {
            int index = Math.abs(a[i]);
            if (index > a.length) continue; //don't care about higher than array length - missing number must be in the range of length
            if (index == 0) continue; // interested in positive and non-zero numbers only
            if (a[index - 1] < 0) continue;  //already occurred previously - ignore subsequent occurrences.
            if (a[index - 1] == 0) a[index - 1] = index; // 0 can't be turned into negative hence a hack here. Can have better solution for this case
            a[index - 1] = -1 * a[index - 1]; // multiply by -1 to mark its presence.
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] >= 0) return i + 1; //found an index which is still positive - means not found in array
        }
        return a.length + 1; //when all numbers till array length are found in array

    }

    public static void main(String[] args) {
        System.out.println(FirstMissingPositive.firstMissingPositive(new int[]{100000, 3, 4000, 2, 15, 1, 99999}));
        System.out.println(FirstMissingPositive.firstMissingPositive(new int[]{1, 2}));
        System.out.println(FirstMissingPositive.firstMissingPositive(new int[]{1}));
        System.out.println(FirstMissingPositive.firstMissingPositive(new int[]{1, 0, 2}));
        System.out.println(FirstMissingPositive.firstMissingPositive(new int[]{3, 4, 1, -1}));
    }
}
