class Solution {
    public long minimumDifference(int[] nums) {
       int n = nums.length / 3;
        int total = nums.length;

        long[] prefixSum = new long[total];
        long[] suffixSum = new long[total];

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        long leftSum = 0;

        for (int i = 0; i < 2 * n; i++) {
            maxHeap.offer(nums[i]);
            leftSum += nums[i];
            if (maxHeap.size() > n) {
                leftSum -= maxHeap.poll();
            }
            if (i >= n - 1) {
                prefixSum[i] = leftSum;
            }
        }

        // Min heap for last n largest
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long rightSum = 0;

        for (int i = total - 1; i >= n; i--) {
            minHeap.offer(nums[i]);
            rightSum += nums[i];
            if (minHeap.size() > n) {
                rightSum -= minHeap.poll();
            }
            if (i <= 2 * n) {
                suffixSum[i] = rightSum;
            }
        }

        long result = Long.MAX_VALUE;
        for (int i = n - 1; i < 2 * n; i++) {
            result = Math.min(result, prefixSum[i] - suffixSum[i + 1]);
        }

        return result;
        
    }
}