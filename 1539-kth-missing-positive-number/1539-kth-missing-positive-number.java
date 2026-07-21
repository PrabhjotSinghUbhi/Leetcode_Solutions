class Solution {
    public int findKthPositive(int[] arr, int k) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : arr) {
            set.add(i);
        }

        ArrayList<Integer> ls = new ArrayList<>();
        int i = 1;
        while (true) {
            if(!(set.contains(i))){
                ls.add(i);
            }

            if(ls.size() == k) {
                return ls.get(k - 1);
            }

            i++;
        }
    }
}