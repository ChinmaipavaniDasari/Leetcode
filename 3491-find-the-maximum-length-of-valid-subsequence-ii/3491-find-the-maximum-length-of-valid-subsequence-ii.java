class Solution {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        int[][] dp = new int[n][k];
        int maxLen = 1;

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < j; i++) {
                int mod = (nums[i] + nums[j]) % k;
                dp[j][mod] = Math.max(dp[j][mod], dp[i][mod] + 1);
                maxLen = Math.max(maxLen, dp[j][mod] + 1);
            }
        }

        return maxLen;    
    }
}