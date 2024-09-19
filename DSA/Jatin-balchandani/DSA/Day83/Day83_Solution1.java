public class Day83_Solution1 {
        public boolean isBipartite(int[][] graph) {
            // Solving using DFS
            int n = graph.length;
            int[] visited = new int[n];
            for(int i = 0; i < n;i++) visited[i] = -1;
            for(int i = 0; i < n;i++){
                if(visited[i] == -1){
                    // visited[i] = 0;
                    if(!dfs(i , visited , graph , 0)) return false;
                }
            }
            return true;
        }
        static boolean dfs(int iy , int[] visited , int[][] graph , int start){
            visited[iy] = start;
            for(int i : graph[iy]){
                if(visited[i] == -1){
                    if(!dfs(i , visited , graph , 1-start)) return false;
                }
                else if(visited[i] == start) return false;
            }
            return true;
        }
    }

