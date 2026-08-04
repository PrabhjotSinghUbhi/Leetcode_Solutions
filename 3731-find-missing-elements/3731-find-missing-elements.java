class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        // int max = Arrays.stream(nums).max().getAsInt();
        // int min = Arrays.stream(nums).min().getAsInt();

        int max = maxElement(nums);
        int min = minElement(nums);

        //n*n
        HashSet<Integer> hs = new HashSet();
        for (int i : nums)
            hs.add(i);

        //n*(maxElement)
        List<Integer> ls = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            if (!hs.contains(i)) {
                ls.add(i);
            }
        }

        return ls;
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

    int minElement(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
}