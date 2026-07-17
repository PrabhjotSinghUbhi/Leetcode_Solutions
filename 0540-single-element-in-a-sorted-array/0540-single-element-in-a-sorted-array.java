class Solution {
    public int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        if (nums.length == 1) {
            return nums[0];
        }

        while (start < end) {
           int mid = start + (end - start) / 2;

           int partnerIndex = mid ^ 1;

           if (nums[mid] == nums[partnerIndex]) {
                start = mid + 1;
           } else {
                end = mid;
           }

        }

        return nums[start];
    }
}