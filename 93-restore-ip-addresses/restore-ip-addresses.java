class Solution {

    List<String> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {

        backtrack(s, 0, new ArrayList<>());

        return result;
    }

    private void backtrack(String s, int index, List<String> parts) {

        // We have exactly 4 parts
        if (parts.size() == 4) {

            // All characters must be used
            if (index == s.length()) {
                result.add(String.join(".", parts));
            }

            return;
        }

        // Try taking 1, 2, or 3 digits
        for (int len = 1; len <= 3; len++) {

            // Avoid going outside the string
            if (index + len > s.length())
                break;

            String part = s.substring(index, index + len);

            // Leading zero is not allowed
            if (part.length() > 1 && part.charAt(0) == '0')
                break;

            // Value must be <= 255
            if (Integer.parseInt(part) > 255)
                break;

            parts.add(part);

            backtrack(s, index + len, parts);

            // Backtrack
            parts.remove(parts.size() - 1);
        }
    }
}