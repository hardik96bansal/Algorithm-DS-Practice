package CodingNinjas.Graphs1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GetPath {

    public static ArrayList<Integer> getPathDFS(int n, int[][] edges, int curr, int end,  boolean[] visited ){
        visited[curr] = true;
        if(curr==end){
            ArrayList<Integer> aList = new ArrayList<>();
            aList.add(curr);
            return aList;
        }
        for(int i=0;i<n;i++){
            if(edges[curr][i]==1 && !visited[i]){
                //visited[i] = true;
                ArrayList<Integer> aList = getPathDFS(n, edges, i, end, visited);
                if(aList!=null){
                    aList.add(curr);
                    return aList;
                }
            }
        }

        return null;
    }

    public static ArrayList<Integer> getPathBFS(int n, int[][] edges, int start, int end, boolean[] visited){
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        HashMap<Integer, Integer> hMap = new HashMap<>();
        
        while(!queue.isEmpty()){
            int curr = queue.poll();
            result.add(curr);

            if(curr==end){
                int temp = curr;
                ArrayList<Integer> res = new ArrayList<>();
                while(temp!=start){
                    res.add(temp);
                    temp = hMap.get(temp);
                }
                res.add(start);
                return res;
            }
            
            for(int i=0;i<n;i++){
                if(edges[curr][i]==1 && !visited[i]){
                    queue.add(i);
                    visited[i] = true;
                    hMap.put(i, curr);
                }
            }
        }
        return null;
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

        int start = scn.nextInt();
        int end = scn.nextInt();
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);

        ArrayList<Integer> aList = getPathBFS(n, edges, start, end, visited);
        if(aList!=null){
            for(int a: aList){
                System.out.print(a+" ");
            }
        }

    }
}