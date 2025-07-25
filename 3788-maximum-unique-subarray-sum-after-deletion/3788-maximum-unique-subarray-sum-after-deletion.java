class Solution {
    public int maxSum(int[] nums) {
        int mx = Arrays.stream(nums).max().getAsInt();
        if (mx <= 0) {
            return mx;
        }
        boolean[] seen = new boolean[201]; // nums[i] ∈ [-100,100], offset by +100 if tracking array
        int ans = 0;
        for (int num : nums) {
            if (num > 0 && !seen[num + 100]) {
                ans += num;
                seen[num + 100] = true;
            }
        }
        return ans;
    }
}