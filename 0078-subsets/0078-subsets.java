class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        getSubsets(nums);
        return ans;
    }

    void getSubsets(int[] nums) {
        int n = nums.length;

        for (int mask = 0; mask < (1 << n); mask++) {

            List<Integer> ls = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    ls.add(nums[i]);
                }
            }

            ans.add(ls);
        }
    }
}