class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int start = 1;
        int end = maxElement(nums);
        int ans = end;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (checkThreshold(nums, threshold, mid)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }

    boolean checkThreshold(int[] nums, int threshold, int divisor) {
        int sum = 0;
        for(int i : nums) {
            // sum += Math.ceil(i/divisor);
            long ceil = (i + divisor - 1) / divisor;

            sum += ceil;

            if(sum > threshold) {
                return false;
            }

        }
        return sum <= threshold;
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