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
            j += Integer.lowestOneBit(j);
        }
    }

    public int prefixSum(int index) {
        int j = index+1;
        int sum = 0;

        while( j > 0) {
            sum += this.bit[j];
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