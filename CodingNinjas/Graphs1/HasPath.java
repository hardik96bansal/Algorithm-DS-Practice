package Graphs1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HasPath {
    public static boolean hasPathBFS(int n, int[][] edges, boolean[] visited, int start, int end){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while(!queue.isEmpty()){
            int curr = queue.poll();
            for(int i=0;i<n;i++){
                if(edges[curr][i]==1 && !visited[i]){
                    if(i==end){
                        return true;
                    }
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }

        return false;
    }

    public static boolean hasPathDFS(int n, int[][] edges, int curr, int end, boolean[] visited){
        if(curr==end){
            return true;
        }
        boolean result = false;
        for(int i=0;i<n;i++){
            if(edges[curr][i]==1 && !visited[i]){
                visited[i] = true;
                result = hasPathDFS(n, edges, i, end, visited);
                if(result) return true;
            }
        }
        return false;
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

        int start = scn.nextInt();
        int end = scn.nextInt();
        //System.out.println(hasPathBFS(n, edges, visited, start, end));
        System.out.println(hasPathDFS(n, edges, start, end, visited));


    }
}