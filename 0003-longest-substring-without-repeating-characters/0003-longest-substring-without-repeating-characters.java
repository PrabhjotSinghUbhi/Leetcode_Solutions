class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int i = 0;
        int j = 0;
        HashMap<Character, Integer> mp = new HashMap<>();
        while (j < s.length()) {
            char currChar = s.charAt(j);
            if (mp.containsKey(currChar)) {
                i = Math.max(mp.get(currChar) + 1, i);
            }
            mp.put(currChar, j);
            maxLength = Math.max(maxLength, j - i + 1);
            j++;
        }
        return maxLength;
    }
}