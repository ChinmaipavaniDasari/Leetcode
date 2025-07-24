class Solution {
    int[] nums;
    List<Integer>[] tree;
    int[] xor, in, out;
    int time = 0;

    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        this.nums = nums;
        xor = new int[n];
        in = new int[n];
        out = new int[n];
        tree = new ArrayList[n];

        for (int i = 0; i < n; i++) tree[i] = new ArrayList<>();
        for (int[] e : edges) {
            tree[e[0]].add(e[1]);
            tree[e[1]].add(e[0]);
        }

        dfs(0, -1);
        int totalXor = xor[0];
        int minScore = Integer.MAX_VALUE;

        List<int[]> directedEdges = new ArrayList<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if (in[u] < in[v]) {
                directedEdges.add(new int[]{v, u});
            } else {
                directedEdges.add(new int[]{u, v});
            }
        }
        for (int i = 0; i < directedEdges.size(); i++) {
            for (int j = i + 1; j < directedEdges.size(); j++) {
                int a = directedEdges.get(i)[0];
                int b = directedEdges.get(j)[0];

                if (isAncestor(a, b)) {
                    int x = xor[b];
                    int y = xor[a] ^ xor[b];
                    int z = totalXor ^ xor[a];
                    minScore = Math.min(minScore, getScore(x, y, z));
                } else if (isAncestor(b, a)) {
                    int x = xor[a];
                    int y = xor[b] ^ xor[a];
                    int z = totalXor ^ xor[b];
                    minScore = Math.min(minScore, getScore(x, y, z));
                } else {
                    int x = xor[a];
                    int y = xor[b];
                    int z = totalXor ^ x ^ y;
                    minScore = Math.min(minScore, getScore(x, y, z));
                }
            }
        }

        return minScore;
    }

    private void dfs(int node, int parent) {
        xor[node] = nums[node];
        in[node] = time++;
        for (int child : tree[node]) {
            if (child != parent) {
                dfs(child, node);
                xor[node] ^= xor[child];
            }
        }
        out[node] = time++;
    }

    private boolean isAncestor(int u, int v) {
        return in[u] <= in[v] && out[v] <= out[u];
    }

    private int getScore(int a, int b, int c) {
        int max = Math.max(a, Math.max(b, c));
        int min = Math.min(a, Math.min(b, c));
        return max - min;
    }
}
