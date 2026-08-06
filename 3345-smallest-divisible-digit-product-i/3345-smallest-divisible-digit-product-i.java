class Solution {
    public int smallestNumber(int n, int t) {

        if(n <= t)
            return t;

        long product = getProduct(n);

        if (product % t == 0) {
            return n;
        }

        long tmp = n;
        long ans = n;
        for (int i = 0; i < 10; i++) {

            if (getProduct(tmp++) % t == 0) {
                break;
            }
        }

        return (int) tmp - 1;

    }

     public static long getProduct(long n) {
        n = Math.abs(n); // Handle negative numbers
        if (n == 0) return 0; // Special case for 0

        long product = 1;
        while (n > 0) {
            product *= (n % 10); // Extract last digit
            n /= 10;             // Remove last digit
        }
        return product;
    }
}