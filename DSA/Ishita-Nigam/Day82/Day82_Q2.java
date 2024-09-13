public class Day82_Q2 {
    public boolean isBipartite(int[][] graph) {
        final int n = graph.length;
        int[] group = new int[n];

        // Try to perform DFS from every node in case the graph has several components
        for (int i = 0; i < n; i++) {
            if (group[i] == 0) {
                if (!dfs(i, -1, group, graph)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean dfs(int curr, int prevG, int[] group, int[][] graph) {
        if (group[curr] != 0) {
            return group[curr] != prevG;
        }

        group[curr] = -prevG;

        for (int next : graph[curr]) {
            if (!dfs(next, -prevG, group, graph)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Day82_Q2 solution = new Day82_Q2();

        // Example graph input
        int[][] graph = {
            {1, 3},
            {0, 2},
            {1, 3},
            {0, 2}
        };

        // Calling the isBipartite method and printing the result
        boolean result = solution.isBipartite(graph);
        System.out.println("Is the graph bipartite? " + result);
    }
}
