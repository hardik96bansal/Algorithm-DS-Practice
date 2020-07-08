package CodingNinjas.Graphs1;

import java.util.Arrays;

public class Islands {
    public static void dfs(int n, int[][] edges, int curr, boolean[] visited){
        visited[curr] = true;
        for(int i=0;i<=n;i++){
            if(edges[curr][i]==1 && !visited[i]){
                dfs(n, edges, i, visited);
            }
        }
    }

    public static int solve(int n, int m, int U[], int V[]){
        int ans =0;
        int[][] edges = new int[n+1][n+1];
        for(int i=0;i<m;i++){
            int v1 = U[i];
            int v2 = V[i];
            edges[v1][v2] = 1;
            edges[v2][v1] = 1;
        }

        boolean[] visited = new boolean[n+1];
        Arrays.fill(visited, false);

        for(int i=1;i<=n;i++){
            if(!visited[i]){
                ans++;
                dfs(n, edges, i, visited);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int n = 2;
        int m = 1;
        int[] U = {1};
        int[] V = {2};
        System.out.println(solve(n, m, U, V));
        
    }
    
}