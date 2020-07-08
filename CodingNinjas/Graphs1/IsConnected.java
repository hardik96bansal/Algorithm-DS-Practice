package CodingNinjas.Graphs1;

import java.util.Arrays;
import java.util.Scanner;

public class IsConnected {
    
    public static void dfs(int n, int[][] edges, int curr, boolean[] visited){
        visited[curr] = true;
        for(int i=0;i<n;i++){
            if(edges[curr][i]==1 && !visited[i]){
                dfs(n, edges, i, visited);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int e = scn.nextInt();
        int[][] edges = new int[n][n];

        for(int i=0;i<e;i++){
            int v1 = scn.nextInt();
            int v2 = scn.nextInt();
            edges[v1][v2] = 1;
            edges[v2][v1] = 1;
        }

        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);

        boolean res = true;
        dfs(n, edges, 0, visited);

        for(boolean val:visited){
            if(!val){
                res = false;
                break;
            }
        }
        System.out.println(res);


    }
}