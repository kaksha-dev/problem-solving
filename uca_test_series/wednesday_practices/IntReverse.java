public class IntReverse {

    public static int reverse(int x) {
        int result = 0;
        int max = Integer.MAX_VALUE/10;
        int lastDigit = x <0 ? Integer.MAX_VALUE%10+1 : Integer.MAX_VALUE%10;
        int sign = x < 0 ? -1 : 1;
        while(x!=0){
            int digit = Math.abs(x%10);
            if(result>max || (result*10>max && digit > lastDigit)){
                return 0;
            }
            result = result*10 +digit;
            x /= 10;
        }
        return sign ==1 ? result : -result;
    }

    public static void main(String[] args) {
        System.out.println(IntReverse.reverse(-2147483648));
        System.out.println(IntReverse.reverse(-123));
        System.out.println(IntReverse.reverse(1534236469));
        System.out.println(IntReverse.reverse(123));
    }
    
}
