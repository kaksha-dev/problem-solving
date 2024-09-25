
public class TwoLonelyNumbers {
    public static void main(String[] args) {
        int[] a = {100, 200, 300, 300, 400, 100, 200, 500};
        int xor = 0;
        for (int i : a) {
            xor = xor ^ i;
        }
        int firstSetBit = 1;
        for (int i = 0; i < 31; i++) {
            if ((xor & firstSetBit) == firstSetBit) {
                break;
            }
            firstSetBit = firstSetBit << 1;
        }
        int x = 0;
        int y = 0;
        for (int i : a) {
            if ((i & firstSetBit) == 0) {
                x = x ^ i;
            } else {
                y = y ^ i;
            }
        }
        System.out.println("two lonely numbers are " + x + " and " + y);
    }
}
