class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i : nums)
            hs.add(i);

        int mxStreak = 0;
        for (int x : hs) {
            if (!hs.contains(x - 1)) {
                int current = x;
                int streak = 1;

                while (hs.contains(current + 1)) {
                    streak++;
                    current++;
                }

                mxStreak = Math.max(mxStreak, streak);
            }
        }

        return mxStreak;

    }
}