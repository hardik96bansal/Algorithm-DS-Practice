package AdvancedGraphs;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Airports{

    public static ArrayList<Integer> bfs(int v, int curr, int[][] edges, boolean[] visited, int aCost){
        ArrayList<Integer> comp = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(curr);
        comp.add(curr);

        while(!queue.isEmpty()){
            int top = queue.poll();
            for(int i=1;i<=v;i++){
                if(edges[top][i]>0 && !visited[i] && edges[top][i]<aCost){
                    visited[i] = true;
                    queue.add(i);
                    comp.add(i);
                }
            }
        }

        return comp;
    }

    public static int minUnvisited(int[] joins, boolean[] visited){
        int ans = Integer.MAX_VALUE;
        int index =0;
        for(int i=0;i<joins.length;i++){
            if(!visited[i] && joins[i]<ans){
                ans = joins[i];
                index = i;
            }
        }
        return index;
    }

    public static int prims(int v, ArrayList<Integer> comp, int[][] edges){
        HashSet<Integer> unvisited = new HashSet<>();
        HashSet<Integer> visited = new HashSet<>();
        int[] join = new int[v+1];
        Arrays.fill(join, Integer.MAX_VALUE);

        for(int a: comp){
            unvisited.add(a);
        }

        int start = comp.get(0);
        join[start] = 0;

        while(visited.size()!=comp.size()){
            int minValue = Integer.MAX_VALUE;
            int num = -1;
            for(int a:unvisited){
                if(join[a]<minValue){
                    minValue = join[a];
                    num = a;
                }

            }

            unvisited.remove(num);
            visited.add(num);

            for(int i=1;i<=v;i++){
                if(unvisited.contains(i) && edges[num][i]>0  && edges[num][i]<join[i]){
                    join[i] = edges[num][i];
                }
            }
        }

        int ans = 0;
        for(int a:comp){
            ans+=join[a];
        }

        return ans;
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        int k = 1;

        while(t>0){
            int v = scn.nextInt();
            int e = scn.nextInt();
            int aCost = scn.nextInt();

            int [][] edges = new int[v+1][v+1];

            for(int i=0;i<e;i++){
                int v1 = scn.nextInt();
                int v2 = scn.nextInt();
                int cost = scn.nextInt();
                if(edges[v1][v2]!=0 && cost<edges[v1][v2]){
                    edges[v1][v2] = cost;
                    edges[v2][v1] = cost;
                }
                if(edges[v1][v2]==0){
                    edges[v1][v2] = cost;
                    edges[v2][v1] = cost;
                }
            }

            boolean[] visited = new boolean[v+1];
            Arrays.fill(visited, false);
            ArrayList<ArrayList<Integer>> components = new ArrayList<>();

            for(int i=1;i<=v;i++){
                if(!visited[i]){
                    visited[i] = true;
                    ArrayList<Integer> comp = bfs(v,i,edges, visited, aCost);
                    components.add(comp);
                }
            }

            int ans = 0;
            int c = components.size();
            for(ArrayList<Integer> comp:components){
                ans = ans + prims(v, comp, edges);
            }

            ans = ans + c*aCost;
            System.out.println("Case #"+k+": "+ans+" "+c);
            t--;
            k++;
        }
    }
}