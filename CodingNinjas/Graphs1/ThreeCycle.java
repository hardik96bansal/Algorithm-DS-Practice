package Graphs1;

import java.util.Arrays;

public class ThreeCycle {

    public static int dfs(int n, int[][] graph, int curr, int currCount, int start,  boolean[] visited){
        if(start==curr && currCount==3){
            return 1;
        }
        if(currCount>=3){
            return 0;
        }
        int ans = 0;
        for(int i=0;i<=n;i++){
            if(graph[curr][i]==1){
                visited[i]=true;
                int temp = dfs(n, graph, i, currCount+1, start, visited);
                //visited[i] = false;
                ans = ans+temp;
            }
        }
        return ans;
    }

    public static int solve(int n,int m,int U[],int V[]) {
        int[][] graph = new int[n+1][n+1];
        for(int i=0;i<m;i++){
            int v1 = U[i];
            int v2 = V[i];
            graph[v1][v2] = 1;
            graph[v2][v1] = 1;
        }

        boolean[] visited = new boolean[n+1];
        Arrays.fill(visited, false);
        int ans = 0;
        for(int i=1;i<=n;i++){
            
                visited[i] = true;
                int temp = dfs(n, graph, i, 0, i, visited);
                temp = temp/2;
                ans = ans+temp;
                      
        }
        System.out.println(ans/3);
        return ans/3;
    }
    
    public static void main(String[] args) {
        int n = 3;
        int m = 3;
        int[] U = {1,2,3,1,4};
        int[] V = {2,3,1,4,3};

        solve(n, m, U, V);
        

        
    }
}