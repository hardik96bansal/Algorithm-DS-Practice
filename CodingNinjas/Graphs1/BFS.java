package CodingNinjas.Graphs1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {

    public static int breadthFirstTrav(int n, int[][] edges, int curr, Queue<Integer> que, boolean[] visited, int remaining){
        //System.out.println(curr+" ");
        que.add(curr);
        visited[curr] = true;
        remaining--;
        while(!que.isEmpty()){
            int firstElem = que.poll();
            System.out.print(firstElem + " ");
            for(int i=0;i<n;i++){
                if(edges[firstElem][i]==1 && !visited[i]){
                    que.add(i);
                    visited[i] = true;
                    remaining--;
                }
            }
        }

        return remaining;
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

        Queue<Integer> queue = new LinkedList<>();
        int remaining = n;

        while(remaining!=0){
            int start = 0;
            for(int i=0;i<n;i++){
                if(!visited[i]){
                    start = i;
                    break;
                }
            }
            remaining = breadthFirstTrav(n, edges, start, queue, visited, remaining);
            System.out.println("");
        }
    }
    
}