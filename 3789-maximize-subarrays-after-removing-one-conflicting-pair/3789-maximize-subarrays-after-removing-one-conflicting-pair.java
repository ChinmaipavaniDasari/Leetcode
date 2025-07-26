class Solution {
    public long maxSubarrays(int n, int[][] conflictingPairs) {
        long valid = 0;
        int maxLeft = 0, secondMaxLeft = 0;
        long[] gains = new long[n + 2];
        List<Integer>[] conflicts = new List[n + 2];
        for (int i = 0; i <= n + 1; i++) conflicts[i] = new ArrayList<>();

        for (int[] p : conflictingPairs) {
            int a = p[0], b = p[1];
            int r = Math.max(a, b), l = Math.min(a, b);
            conflicts[r].add(l);
        }

        for (int r = 1; r <= n; r++) {
            for (int l : conflicts[r]) {
                if (l > maxLeft) {
                    secondMaxLeft = maxLeft;
                    maxLeft = l;
                } else if (l > secondMaxLeft) {
                    secondMaxLeft = l;
                }
            }
            valid += (r - maxLeft);
            gains[maxLeft] += (maxLeft - secondMaxLeft);
        }

        long bestGain = 0;
        for (int i = 0; i <= n; i++) bestGain = Math.max(bestGain, gains[i]);
        return valid + bestGain;
    }
}
