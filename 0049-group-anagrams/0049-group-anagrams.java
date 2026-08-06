class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> mp = new HashMap<>();

        for (String s : strs) {
            char[] words = s.toCharArray();
            Arrays.sort(words);
            String sortedWord = new String(words);

            if (!mp.containsKey(sortedWord)) {
                mp.put(sortedWord, new ArrayList<>());
            }

            mp.get(sortedWord).add(s);
        }

        return new ArrayList<>(mp.values());
    }

}