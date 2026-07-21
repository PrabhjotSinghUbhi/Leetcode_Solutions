class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int start = maxElement(weights);
        int end = sum(weights);
        int ans = end;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (checkDays(weights, days, mid)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;

    }

    boolean checkDays(int[] nums, int reqDays, int currCapacity) {
        int daysTaken = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if(sum == currCapacity) {
                daysTaken++;
                sum = 0;
            } else if (sum > currCapacity) {
                daysTaken++;
                sum = 0;
                i--;
            }

            if (daysTaken > reqDays) {
                return false;
            }

        }

        if(sum != 0) {
            daysTaken++;
        }

        return daysTaken <= reqDays;
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

    int sum(int[] arr) {
        int sum = 0;
        for(int i : arr)
            sum += i;

        return sum;
    }
}