import java.util.*;
public class Day85_Solution2 {
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>> graph)
    {
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);
        int mother = -1;
        for (int i = 0; i < V; i++){
            if (!visited[i]){
                dfs(i, graph, visited);
                mother = i;
            }
        }

        Arrays.fill(visited, false);
        dfs(mother, graph, visited);

        for (int i = 0; i < V; i++){
            if (!visited[i]) return -1;
        }

        return mother;

    }

    public void dfs(int node, ArrayList<ArrayList<Integer>> graph, boolean[] visited) {
        visited[node] = true;
        ArrayList<Integer> nbrs = graph.get(node);
        for(int nbr: nbrs){
            if (!visited[nbr]) dfs(nbr, graph, visited);
        }
    }
}
