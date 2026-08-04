class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        // int max = Arrays.stream(nums).max().getAsInt();
        // int min = Arrays.stream(nums).min().getAsInt();

        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
            if (nums[i] > max) {
                max = nums[i];
            }
        }

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
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return min;
    }
}