package CodingNinjas.Graphs1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeSet;

public class AllConnComp {
    public static TreeSet<Integer> bfs(int n, int[][] edges, int curr, boolean[] visited){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(curr);
        visited[curr] = true;
        TreeSet<Integer> result = new TreeSet<>();

        while(!queue.isEmpty()){
            int temp = queue.poll();
            result.add(temp);
            for(int i=0;i<n;i++){
                if(edges[temp][i]==1 && !visited[i]){
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }

        return result;
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int e = scn.nextInt();
        int[][] edges = new int[n][n];
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);

        for(int i=0;i<e;i++){
            int v1 = scn.nextInt();
            int v2 = scn.nextInt();
            edges[v1][v2] = 1;
            edges[v2][v1] = 1;
        }

        for(int i=0;i<n;i++){
            if(!visited[i]){
                TreeSet<Integer> component = bfs(n, edges, i, visited);
                for(int a:component){
                    System.out.print(a+" ");
                }
                System.out.println("");
            }
        }
    }
    
}