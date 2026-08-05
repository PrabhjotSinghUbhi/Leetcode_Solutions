class Solution {
    int[] arr;

    public int minAbsDifference(int[] nums, int goal) {
        //meet in the middle appraoch. 
        arr = nums;
        int n = nums.length;

        //make first half
        List<Integer> first = new ArrayList<>();
        //make second help
        List<Integer> second = new ArrayList<>();

        //generate all frist half
        generate(0, n / 2, 0, first);
        //generate all second half
        generate(n / 2, n, 0, second);

        //sort first
        Collections.sort(first);

        int ans = Integer.MAX_VALUE;
        //traverse the second
        for (int secondSetSum : second) {
            int left = goal - secondSetSum; // How far off are we from the desired goal?

            if (first.get(0) > left) { // all subset sums from first half are too big => Choose the smallest
                ans = (int) (Math.min(ans, Math.abs((first.get(0) + secondSetSum) - goal)));
                continue;
            }

            if (first.get(first.size() - 1) < left) { // all subset sums from first half are too small => Choose the largest
                ans = (int) (Math.min(ans, Math.abs((first.get(first.size() - 1) + secondSetSum) - goal)));
                continue;
            }

            int pos = Collections.binarySearch(first, left);
            if (pos >= 0)
                return 0;
            else
                pos = -1 * (pos + 1);
 
            int low = pos - 1;
            
            ans = (int) Math.min(ans, Math.abs(secondSetSum + first.get(low) - goal)); // Checking for the floor value (largest sum < goal)
            ans = (int) Math.min(ans, Math.abs(secondSetSum + first.get(pos) - goal)); //Checking for the ceiling value (smallest sum > goal)
        }

        return ans;
    }

    void generate(int i, int end, int sum, List<Integer> listOfSubsetSums) {
        if (i == end) {
            listOfSubsetSums.add(sum);
            return;
        }

        generate(i + 1, end, sum + arr[i], listOfSubsetSums);
        generate(i + 1, end, sum, listOfSubsetSums);
    }

}