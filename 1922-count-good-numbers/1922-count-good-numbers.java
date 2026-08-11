class Solution {
    public int countGoodNumbers(long n) {
        long even_pos = (n + 1) / 2;
        long odd_pos = n / 2;

        int MOD = (int) (1e9 + 7);

        long ans = modPow(5, even_pos, MOD) * modPow(4, odd_pos, MOD);
        return (int) (ans % MOD);
    }

    long modPow(long base, long exp, int mod) {
        long ans = 1;
        while (exp > 0) {
            if ((exp & 1) != 0) {
                ans = (ans % mod) * (base % mod);
                exp = exp - 1;
            } else {
                exp = exp / 2;
                base = ((base % mod) * (base % mod) % mod);
            }
        }
        return ans % mod;
    }
}