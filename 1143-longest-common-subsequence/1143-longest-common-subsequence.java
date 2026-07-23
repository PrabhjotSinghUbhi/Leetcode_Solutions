class Solution {
    public int longestCommonSubsequence(String text1, String text2) {

        int n = text1.length();
        int m = text2.length();

        if (n == 0 || m == 0)
            return 0;

        int[][] dp = new int[m][n];

        if (text1.charAt(0) == text2.charAt(0)) {
            dp[0][0] = 1;
        }

        // First row
        for (int j = 1; j < n; j++) {
            if (text1.charAt(j) == text2.charAt(0)) {
                dp[0][j] = 1;
            } else {
                dp[0][j] = dp[0][j - 1];
            }
        }

        // First column
        for (int i = 1; i < m; i++) {
            if (text2.charAt(i) == text1.charAt(0)) {
                dp[i][0] = 1;
            } else {
                dp[i][0] = dp[i - 1][0];
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (text2.charAt(i) == text1.charAt(j)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}