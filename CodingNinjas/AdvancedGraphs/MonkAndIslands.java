package AdvancedGraphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MonkAndIslands{
    public static int dijkastra(int v, ArrayList<Integer>[] edges, int source, int dest){
        int[] distance = new int[v+1];
        HashSet<Integer> visited = new HashSet<>();
        HashSet<Integer> unvisited = new HashSet<>();
        
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;
        for(int i=1;i<=v;i++) unvisited.add(i);

        while(!unvisited.isEmpty()){
            int minDistance = Integer.MAX_VALUE;
            int index = -1;
            for(int a:unvisited){
                if(distance[a]<minDistance){
                    minDistance = distance[a];
                    index = a;
                }
            }
            ArrayList<Integer> aList = edges[index];
            for(int a:aList){
                if(distance[index]+1<distance[a]){
                    distance[a] = distance[index]+1;
                }
            }
            unvisited.remove(index);
            visited.add(index);            
        }

        return distance[dest];
    }

    public static int bfs(int v, ArrayList<Integer>[] edges, int start, int dest){
        int[] distance = new int[v+1];
        boolean[] visited = new boolean[v+1];
        distance[start] = 0;
        Arrays.fill(visited, false);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int top = queue.poll();
            for(int a:edges[top]){
                if(!visited[a]){
                    queue.add(a);
                    visited[a] = true;
                    distance[a] = distance[top]+1;
                    if(a==dest){
                        return distance[a];
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t>0){
            int v = scn.nextInt();
            int e = scn.nextInt();

            ArrayList<Integer>[] edges = new ArrayList[v+1];
            for(int i=0;i<=v;i++){
                edges[i] = new ArrayList();
            }

            for(int i=0;i<e;i++){
                int v1 = scn.nextInt();
                int v2 = scn.nextInt();
                edges[v1].add(v2);
                edges[v2].add(v1);
            }
            System.out.println(bfs(v, edges, 1, v));

            t--;
        }
    }
}