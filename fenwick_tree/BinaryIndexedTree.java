/*
 * Binary Indexed Tree (In recognition of the close relationship between the
 *  tree traversal algorithms and the binary representation of an element index,
 *  the name - binary indexed tree)
 * 
 * Basic Idea: 
 * if the index contains a `2 bit` we include two frequencies, if it has an
 * `8 bit` we include 8 frequencies, and so on.
 * 
 * Contents are stored as follows:
 * Index   :   0 1  2   3  4   5  6    7  8   9  10   11
 * Contents:   0 1 1..2 3 1..4 5 5..6  7 1..8 9 9..10 11
 * 
 * Example:
 * Item.   : 0 2 0 1 1 1 0 4  4  0  1  0  1  2  3  0
 * Cumu.   : 0 2 0 3 4 5 5 9 13 13 14 14 15 17 20 20
 * Stored. : 0 2 2 1 4 1 1 4 13  0  1  0  2  2  5  0 
 * 
 * Interrogation Tree:
 * The branching ratio of each node is the number of trailing zeros in its binary
 * representation. Example below:
 *    0
 * / \  \ 
 * 1  2  4  
 *   /  /\
 *   3 5  6
 *        /
 *        7
 */      
public class BinaryIndexedTree {
    int[] bit;
    int[] arr;

    BinaryIndexedTree(int[] arr) {
        this.arr = arr;
        this.bit = new int[1+arr.length];
        constructTree();
    }

    public void constructTree() {
        for(int i = 0; i < this.arr.length; i++) {
            int j = i+1;
            while(j < this.bit.length) {
                this.bit[j] += this.arr[i];
                // Add the least-significant 1 bit at each stage to get
                // the next entry to adjust.
                j += Integer.lowestOneBit(j);
            }
        }
    }

    public void update(int index, int value)
    {
        int delta = value - this.arr[index];
        this.arr[index] = value;
        int j = index+1;

        while(j < this.bit.length) {
            this.bit[j] += delta;
            // Add the least-significant 1 bit at each stage to get
            // the next entry to adjust.
            j += Integer.lowestOneBit(j);
        }
    }

    public int prefixSum(int index) {
        int j = index+1;
        int sum = 0;

        // The prefixSum operation involves calculating a new index by
        // stripping the least significant 1 from the old index, and repeating
        // this operation until the index is zero. For an initial index of 11
        // this process yields the sequence 11, 10, 8, 0. To read the cumulative
        // frequency for element 11, we form the sum V[11] + V[10] + V[8] + V[0]
        while( j > 0) {
            sum += this.bit[j];
            // Strip off the least significant one bit of a binary number.
            j -= Integer.lowestOneBit(j);
        }
        return sum;
    }

    public int rangeSum(int left, int right) {
        return this.prefixSum(right) - this.prefixSum(left);
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, -1, 6, 5, 4, -3, 3, 7, 2, 3};
        BinaryIndexedTree binaryIndexedTree = new BinaryIndexedTree(arr);

        assert(binaryIndexedTree.prefixSum(4) == 15);
        binaryIndexedTree.update(1, 3);
        assert(binaryIndexedTree.prefixSum(4)== 16);
        assert(binaryIndexedTree.rangeSum(6, 9) == 12); // (6, 9]
    }

}