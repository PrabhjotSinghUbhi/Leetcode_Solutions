class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        solve(0,subset,ans,nums);
        return ans;
    }

    void solve(int index, List<Integer> subset, List<List<Integer>> ans, int[] nums) {
        if(index == nums.length) {
            ans.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[index]);
        solve(index + 1, subset,ans,nums);
        subset.removeLast();
        solve(index + 1, subset, ans, nums);
    }
}