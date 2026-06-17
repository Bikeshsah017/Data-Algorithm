class Solution {
    public int maxProduct(int[] nums) {
        int minimum = nums[0];
        int maximum = nums[0];
        int result = nums[0];

        for(int i = 1; i < nums.length; i++){
            int current = nums[i];

            if(current < 0){
                int temp = maximum;
                maximum = minimum;
                minimum = temp;
            }
            maximum = Math.max(current,current*maximum);
            minimum = Math.min(current,current*minimum);
            result = Math.max(result,maximum);
        }

        return result;
    }
}