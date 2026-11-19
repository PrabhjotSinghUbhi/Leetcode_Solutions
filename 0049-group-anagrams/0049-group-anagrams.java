class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> mp = new HashMap<>();

        for(String str : strs) {
            char[] chars = str.toCharArray();

            Arrays.sort(chars);

            String key = new String(chars);

            if(mp.containsKey(key)) {
                (mp.get(key)).add(str);
            } else {
                mp.put(key, new ArrayList<String>());
                mp.get(key).add(str);
            }
        }

        List<List<String>> ans = new ArrayList<>();
        for(var x : mp.entrySet()) {
            ans.add(x.getValue());
        }

        return ans;
    }
}