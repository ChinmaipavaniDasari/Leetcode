class Solution {

    class TrieNode {
        Map<String, TrieNode> children = new HashMap<>();
        String name;
        boolean toDelete = false;
    }

    Map<String, Integer> seen = new HashMap<>();
    Map<TrieNode, String> nodeToSerial = new HashMap<>();

    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        TrieNode root = new TrieNode();

        // Build the folder structure as a Trie
        for (List<String> path : paths) {
            TrieNode curr = root;
            for (String folder : path) {
                curr.children.putIfAbsent(folder, new TrieNode());
                curr = curr.children.get(folder);
                curr.name = folder;
            }
        }

        // Serialize the subtree structures and record how many times each appears
        serialize(root);

        // Mark duplicate subtrees for deletion
        for (Map.Entry<TrieNode, String> entry : nodeToSerial.entrySet()) {
            if (seen.get(entry.getValue()) > 1) {
                entry.getKey().toDelete = true;
            }
        }

        // DFS to collect remaining valid paths
        List<List<String>> result = new ArrayList<>();
        dfs(root, new ArrayList<>(), result);
        return result;
    }

    private String serialize(TrieNode node) {
        if (node.children.isEmpty()) return "";

        List<String> serializedChildren = new ArrayList<>();
        for (Map.Entry<String, TrieNode> entry : node.children.entrySet()) {
            String childSerial = serialize(entry.getValue());
            serializedChildren.add("(" + entry.getKey() + childSerial + ")");
        }

        Collections.sort(serializedChildren);
        String serial = String.join("", serializedChildren);

        nodeToSerial.put(node, serial);
        seen.put(serial, seen.getOrDefault(serial, 0) + 1);
        return serial;
    }

    private void dfs(TrieNode node, List<String> path, List<List<String>> result) {
        for (Map.Entry<String, TrieNode> entry : node.children.entrySet()) {
            TrieNode child = entry.getValue();
            if (!child.toDelete) {
                path.add(entry.getKey());
                result.add(new ArrayList<>(path));
                dfs(child, path, result);
                path.remove(path.size() - 1);
            }
        }
    }
}
