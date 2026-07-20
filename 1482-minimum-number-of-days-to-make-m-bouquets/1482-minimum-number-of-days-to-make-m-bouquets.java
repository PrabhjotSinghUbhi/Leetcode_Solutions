class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int start = minElement(bloomDay);
        int end = maxElement(bloomDay);
        int ans = end;

        if ((long) m * k > bloomDay.length) {
            return -1;
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (checkIfBloomed(bloomDay, mid, m, k)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }

    boolean checkIfBloomed(int[] bloomDay, int day, int m, int k) {

        int n = bloomDay.length;
        int consecutives = 0;
        int bouquets = 0;
        for (int i = 0; i < n; i++) {

            if (valid(bloomDay[i],day)) {
                consecutives++;
                if(consecutives == k){
                    bouquets++;
                    consecutives = 0;
                }
            } else {
                consecutives = 0;
            }

            if (bouquets >= m){
                return true;
            }
        }

        return false;
    }

    boolean valid(int num, int day) {
        return num <= day;
    }

    int minElement(int[] nums) {
        int min = nums[0];
        for (int i : nums) {
            if (i < min)
                min = i;
        }
        return min;
    }

    int maxElement(int[] nums) {
        int max = nums[0];
        for (int i : nums) {
            if (i > max)
                max = i;
        }
        return max;
    }

}