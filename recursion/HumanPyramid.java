public class HumanPyramid {
    /**
     * A human pyramid is a formation of people where participants make a horizontal
     * row along the ground, and each subsequent row is formed by standing on the shoulders
     * of the row below. Each row had one less person than the row below it, and the topmost
     * row has a single person. Example of a human pyramid with 4 rows:
     *        A
     *       / \
     *      B   C
     *     / \ / \
     *    D   E   F
     *   / \ / \ / \
     *  G   H   I   J
     * 
     * Each person in the pyramid has a weight, and each person supports their own weight
     * plus half the weight of each person directly above them. For example, in the pyramid
     * E supports half the weight supported by B and half the weight supported by C, in
     * addition to their own weight.
     * 
     * Given a human pyramid represented as a list of lists of integers, where each integer
     * represents the weight of a person, write a function that calculates the total weight
     * supported by the person at a given position in the pyramid.
     * 
     * Constraints:
     * 1. The pyramid will have at least 1 row and at most 100 rows.
     * 2. Each person's weight will be a positive integer less than or equal to 300.
     * 3. The position in the pyramid is given as a pair of integers (row, col), where row
     *    is the row index (0-indexed from the top) and col is the column index (0-indexed from the left). 
     * 4. You may assume that the given position is valid within the pyramid.
     * 5. Your solution should be recursive and not use any loops.
     * 
     * @param pyramid - A list of lists of integers representing the weights of people in the pyramid.
     * @param row - The row index of the person whose supported weight is to be calculated.
     * @param col - The column index of the person whose supported weight is to be calculated.
     * @returns float - The total weight supported by the person at the given position.
     */
    public float totalWeightSupported(List<List<Integer>> pyramid, int row, int col) {
        return 0;
    }

    /**
     * Main method for testing the HumanPyramid class.
     */
    public static void main(String[] args) {
        HumanPyramid hp = new HumanPyramid();
        List<List<Integer>> pyramid = Arrays.asList(
            Arrays.asList(51.18),
            Arrays.asList(55.90, 131.25),
            Arrays.asList(69.05, 133.66, 132.82),
            Arrays.asList(53.43, 139.61, 134.06, 121.63)
        );

        assert Math.abs(hp.totalWeightSupported(pyramid, 0, 0) - 51.18) < 1e-2 : "Test case 1 failed";
        assert Math.abs(hp.totalWeightSupported(pyramid, 1, 0) - 81.49) < 1e-2 : "Test case 2 failed";
        assert Math.abs(hp.totalWeightSupported(pyramid, 1, 1) - 156.84) < 1e-2 : "Test case 3 failed";
        assert Math.abs(hp.totalWeightSupported(pyramid, 2, 0) - 109.80) < 1e-2 : "Test case 4 failed";
        assert Math.abs(hp.totalWeightSupported(pyramid, 2, 1) - 252.82) < 1e-2 : "Test case 5 failed";
        assert Math.abs(hp.totalWeightSupported(pyramid, 2, 2) - 211.24) < 1e-2 : "Test case 6 failed";
        assert Math.abs(hp.totalWeightSupported(pyramid, 3, 0) - 108.32) < 1e-2 : "Test case 7 failed";
        assert Math.abs(hp.totalWeightSupported(pyramid, 3, 1) - 320.92) < 1e-2 : "Test case 8 failed";
        assert Math.abs(hp.totalWeightSupported(pyramid, 3, 2) - 326.09) < 1e-2 : "Test case 9 failed";
        assert Math.abs(hp.totalWeightSupported(pyramid, 3, 3) - 227.25) < 1e-2 : "Test case 10 failed";  
    }
}