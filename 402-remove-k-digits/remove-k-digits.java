class Solution {
    public String removeKdigits(String num, int k) {

        StringBuilder stack = new StringBuilder();

        for (char digit : num.toCharArray()) {

            while (stack.length() > 0 &&
                   k > 0 &&
                   stack.charAt(stack.length() - 1) > digit) {

                stack.deleteCharAt(stack.length() - 1);
                k--;
            }

            stack.append(digit);
        }

        // If k is still greater than 0,
        // remove digits from the end
        while (k > 0) {
            stack.deleteCharAt(stack.length() - 1);
            k--;
        }

        // Remove leading zeros
        int index = 0;

        while (index < stack.length() &&
               stack.charAt(index) == '0') {
            index++;
        }

        String result = stack.substring(index);

        return result.length() == 0 ? "0" : result;
    }
}