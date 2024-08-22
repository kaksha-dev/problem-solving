/*
* https://leetcode.com/problems/single-number-ii 
*/

public class SingleNumberII {
    public int singleNumber(int[] nums) {
        int result = 0;
        
        // Per contstraints, each num is a signed integer of 32 bits.
        for(int i = 0; i < 32; i++) {
            int x = 1 << i;
            int count_bits = 0;
            
            for(int j = 0; j < nums.length; j++) {
                // Calculate the count of set bits at each of the 32 places
                if((nums[j] & x) != 0) count_bits += 1;
            }
            
            // If not a mutiple of 3, this bit is set in the single number.
            if(count_bits%3 != 0) result |= x;
        }
        return result;
    }

    public static void main(String[] args) {
        SingleNumberII sn = new SingleNumberII();

        int[] arr1 = {2, 2, 3, 2};
        assert(sn.singleNumber(arr1) == 3);

        int[] arr2 = {0, 1, 0, 1, 0, 1, 99};
        assert(sn.singleNumber(arr2) == 99);

        int[] arr3 = {-2, -2, 1, 1, 4, 1, 4, 4, -4, -2};
        assert(sn.singleNumber(arr3) == -4);
    }
}