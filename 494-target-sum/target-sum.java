class Solution {

    public int findTargetSumWays(int[] nums, int target) {

        Map<String, Integer> memo = new HashMap<>();

        return solve(nums, target, 0, 0, memo);
    }

    private int solve(int[] nums, int target,
                      int index, int sum,
                      Map<String, Integer> memo) {

        // Base case
        if (index == nums.length) {
            return sum == target ? 1 : 0;
        }

        String key = index + "," + sum;

        // Already calculated
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // Choice 1: Add the current number
        int add = solve(
            nums,
            target,
            index + 1,
            sum + nums[index],
            memo
        );

        // Choice 2: Subtract the current number
        int subtract = solve(
            nums,
            target,
            index + 1,
            sum - nums[index],
            memo
        );

        int totalWays = add + subtract;

        memo.put(key, totalWays);

        return totalWays;
    }
}