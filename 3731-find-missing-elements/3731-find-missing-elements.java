class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int min = Arrays.stream(nums).min().getAsInt();

        HashSet<Integer> hs = new HashSet();
        for (int i : nums)
            hs.add(i);

        List<Integer> ls = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            if (!hs.contains(i)) {
                ls.add(i);
            }
        }

        return ls;
    }
}