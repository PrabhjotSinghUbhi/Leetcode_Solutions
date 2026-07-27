class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int e1 = nums[n - 1] - 1;
        int e2 = nums[n - 2] - 1;
        return e1 * e2;
    }
}