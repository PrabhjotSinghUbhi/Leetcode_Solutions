class Solution {
    // digit -> [exp2, exp3, exp5, exp7]
    private static final int[][] DIGIT_FACTORS = new int[10][4];
    static {
        DIGIT_FACTORS[2] = new int[]{1,0,0,0};
        DIGIT_FACTORS[3] = new int[]{0,1,0,0};
        DIGIT_FACTORS[4] = new int[]{2,0,0,0};
        DIGIT_FACTORS[5] = new int[]{0,0,1,0};
        DIGIT_FACTORS[6] = new int[]{1,1,0,0};
        DIGIT_FACTORS[7] = new int[]{0,0,0,1};
        DIGIT_FACTORS[8] = new int[]{3,0,0,0};
        DIGIT_FACTORS[9] = new int[]{0,2,0,0};
    }

    public String smallestNumber(String num, long t) {
        int[] req = new int[4];
        int[] primes = {2, 3, 5, 7};
        for (int i = 0; i < 4; i++) {
            while (t % primes[i] == 0) {
                req[i]++;
                t /= primes[i];
            }
        }
        if (t != 1) return "-1"; // t has a prime factor other than 2,3,5,7 -> impossible

        int[] factorCount = getFactorCount(req);
        int minDigits = sum(factorCount);
        int n = num.length();

        // Case 1: even the shortest zero-free number satisfying divisibility
        // already needs more digits than num -> it's automatically the answer
        // (any number with more digits than num is numerically larger).
        if (minDigits > n) return construct(factorCount);

        int[] prefix = getPrimeCountFromString(num);
        int firstZeroIndex = num.indexOf('0');
        if (firstZeroIndex == -1) {
            firstZeroIndex = n;
            if (isSubset(req, prefix)) return num; // num itself already works
        }

        // Case 2: keep num's length; find the rightmost position we can bump up.
        for (int i = n - 1; i >= 0; i--) {
            int d = num.charAt(i) - '0';
            prefix = subtract(prefix, DIGIT_FACTORS[d]); // now = contribution of [0, i)
            int spaceAfter = n - 1 - i;

            if (i > firstZeroIndex) continue; // prefix [0,i) would contain a 0 -> invalid

            int[] needAfterPrefix = subtract(req, prefix);
            for (int big = d + 1; big <= 9; big++) {
                int[] remaining = subtract(needAfterPrefix, DIGIT_FACTORS[big]);
                int[] fc = getFactorCount(remaining);
                int need = sum(fc);
                if (need <= spaceAfter) {
                    int fillOnes = spaceAfter - need;
                    StringBuilder sb = new StringBuilder();
                    sb.append(num, 0, i);
                    sb.append((char) ('0' + big));
                    for (int k = 0; k < fillOnes; k++) sb.append('1');
                    sb.append(construct(fc));
                    return sb.toString();
                }
            }
        }

        // Case 3: no same-length fix works -> answer needs one more digit.
        int[] fcFull = getFactorCount(req);
        int need = sum(fcFull);
        int fillOnes = (n + 1) - need;
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < fillOnes; k++) sb.append('1');
        sb.append(construct(fcFull));
        return sb.toString();
    }

    private int[] subtract(int[] a, int[] b) {
        int[] res = new int[a.length];
        for (int i = 0; i < a.length; i++) res[i] = Math.max(0, a[i] - b[i]);
        return res;
    }

    private boolean isSubset(int[] need, int[] have) {
        for (int i = 0; i < 4; i++) if (need[i] > have[i]) return false;
        return true;
    }

    private int[] getPrimeCountFromString(String num) {
        int[] res = new int[4];
        for (int idx = 0; idx < num.length(); idx++) {
            int d = num.charAt(idx) - '0';
            for (int i = 0; i < 4; i++) res[i] += DIGIT_FACTORS[d][i];
        }
        return res;
    }

    // Convert required [e2,e3,e5,e7] into the minimal multiset of digits 2..9.
    // Returned index: 0->'2',1->'3',2->'4',3->'5',4->'6',5->'7',6->'8',7->'9'
    private int[] getFactorCount(int[] req) {
        int e2 = req[0], e3 = req[1], e5 = req[2], e7 = req[3];
        int c8 = e2 / 3;
        int rem2 = e2 % 3;
        int c9 = e3 / 2;
        int rem3 = e3 % 2;
        int c4 = rem2 / 2;
        int c2 = rem2 % 2;
        int c6 = 0;
        if (c2 == 1 && rem3 == 1) {
            c2 = 0; rem3 = 0; c6 = 1;
        }
        if (rem3 == 1 && c4 == 1) {
            c2 = 1; c6 = 1; rem3 = 0; c4 = 0;
        }
        int c3 = rem3;
        return new int[]{c2, c3, c4, e5, c6, e7, c8, c9};
    }

    private int sum(int[] a) {
        int s = 0;
        for (int v : a) s += v;
        return s;
    }

    private String construct(int[] fc) {
        StringBuilder sb = new StringBuilder();
        for (int d = 2; d <= 9; d++) {
            int cnt = fc[d - 2];
            for (int k = 0; k < cnt; k++) sb.append((char) ('0' + d));
        }
        return sb.toString();
    }
}