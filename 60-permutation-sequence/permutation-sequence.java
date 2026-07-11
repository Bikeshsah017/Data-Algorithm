import java.util.*;

class Solution {
    public String getPermutation(int n, int k) {

        List<Integer> numbers = new ArrayList<>();
        int factorial = 1;

        // Store numbers 1 to n
        for (int i = 1; i <= n; i++) {
            numbers.add(i);

            if (i < n)
                factorial *= i;
        }

        k--; // Convert to 0-based indexing

        StringBuilder answer = new StringBuilder();

        while (!numbers.isEmpty()) {

            int index = k / factorial;

            answer.append(numbers.get(index));

            numbers.remove(index);

            if (numbers.isEmpty())
                break;

            k %= factorial;

            factorial /= numbers.size();
        }

        return answer.toString();
    }
}