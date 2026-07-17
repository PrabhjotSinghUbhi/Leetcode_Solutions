class Solution {
    public int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        if (nums.length == 1) {
            return nums[0];
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;
 
            // if mid occurence is starting from odd index that means the single element is on the left side.
            if (mid - 1 >= start && nums[mid - 1] == nums[mid]) {
                //starting from an odd occurence;
                if ((mid - 1) % 2 != 0) {
                    end = mid - 2;
                }
                // starting from a even occurence
                else {
                    start = mid + 1;
                }

                
            }
            // if nums[mid] is repeating on the right.
             else if (mid + 1 <= end && nums[mid + 1] == nums[mid]) {
                //if that index is odd, problem is on the left
                if ((mid) % 2 != 0) {
                    end = mid - 1;
                } else {
                    start = mid + 2;
                }
            }
            else {
                return nums[mid];
            }
        }

        return 0;
    }
}