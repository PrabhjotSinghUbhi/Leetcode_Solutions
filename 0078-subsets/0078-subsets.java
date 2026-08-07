class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        solve(nums, 0, new ArrayList<Integer>());
        return ans;
    }

    void solve(int[] arr, int index, ArrayList<Integer> curr) {
        if(arr.length == index) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        //include
        curr.add(arr[index]);
        solve(arr, index + 1, curr);

        //exclude
        curr.remove(curr.size() - 1);
        solve(arr, index + 1, curr);
    }
}