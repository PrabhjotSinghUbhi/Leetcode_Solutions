class Solution {
    public int[] searchRange(int[] nums, int target) {
        //requires 2 binary searches on to find the rightmost element, and other to find the leftmost element;
        int rightIndex = -1;
        int leftIndex = -1;

        //To find the left most element occurence.
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                leftIndex = mid;
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        } 

        //to find the rightmost occurence;
        start = 0;
        end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                rightIndex = mid;
                start = mid + 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        } 

        if(leftIndex == -1 || rightIndex == -1) {
            return new int[]{-1,-1};
        }

        return new int[] {leftIndex, rightIndex};

    }
}