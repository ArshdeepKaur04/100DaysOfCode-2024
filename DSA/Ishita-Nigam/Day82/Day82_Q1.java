//BFS of graph

import java.util.*;

public class Day82_Q1 {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // boolean list to mark all the vertices as not visited.
        boolean visited[] = new boolean[V];

        int s = 0;
        // initially we mark first vertex as visited(true).
        visited[s] = true;

        ArrayList<Integer> res = new ArrayList<>();

        // creating a queue for BFS and pushing first vertex in queue.
        LinkedList<Integer> q = new LinkedList<Integer>();
        q.add(s);

        while (q.size() != 0) {
            // adding front element in output list and popping it from queue.
            s = q.poll();
            res.add(s);

            // traversing over all the connected components of front element.
            Iterator<Integer> i = adj.get(s).listIterator();
            while (i.hasNext()) {
                int n = i.next();
                // if they aren't visited, we mark them visited and add to queue.
                if (!visited[n]) {
                    visited[n] = true;
                    q.add(n);
                }
            }
        }
        // returning the output list.
        return res;
    }

    public static void main(String[] args) {
        Day82_Q1 solution = new Day82_Q1();

        // Example graph initialization
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Adding edges to the adjacency list
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(3);
        adj.get(1).add(4);

        // Calling the bfsOfGraph method
        ArrayList<Integer> result = solution.bfsOfGraph(V, adj);

        // Printing the BFS traversal result
        System.out.println("BFS Traversal of the graph: " + result);
    }
}
