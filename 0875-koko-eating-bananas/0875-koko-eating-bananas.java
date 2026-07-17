class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = maxElement(piles);
        int minK = end;

        while (start <= end) {
            int k = start + (end - start) / 2;

            if (canEatAll(piles, k, h)) {
                minK = k;
                end = k - 1;
            } else {
                start = k + 1;
            }
        }
        return minK;
    }

    boolean canEatAll(int[] piles, int k, int h) {
        long hr = 0;

        for (int pile : piles) {
            long ceil = (pile + k - 1) / k;

            hr += ceil;

            if (hr > h) {
                return false;
            }
        }
        return hr <= h;
    }

    int maxElement(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

}