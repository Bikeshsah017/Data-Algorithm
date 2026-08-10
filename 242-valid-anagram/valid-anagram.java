class Solution {
    public boolean isAnagram(String s, String t) {

        // Anagrams must have the same length
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];

        // Count characters from s
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // Remove characters using t
        for (char c : t.toCharArray()) {
            count[c - 'a']--;
        }

        // Every count should be 0
        for (int value : count) {
            if (value != 0) {
                return false;
            }
        }

        return true;
    }
}