package AdvancedGraphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class CloselyConnectedGraph {
    public static void dfs(int v, int curr, ArrayList<Integer>[] edges, boolean[] visited, Stack<Integer> stack){
        ArrayList<Integer> aList = edges[curr];
        for(int a:aList){
            if(!visited[a]){
                visited[a] = true;
                dfs(v, a, edges, visited, stack);
            }
        }
        stack.add(curr);
    }

    public static Stack<Integer> traverse(int v, ArrayList<Integer>[] edges, boolean[] visited){
        Stack<Integer> stack = new Stack<>();
        for(int i=1;i<=v;i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(v, i, edges, visited, stack);
            }
        }
        return stack;
    }

    public static void dfsTranspose(ArrayList<Integer>[] edges, int curr, boolean[] visited, ArrayList<Integer> curArrayList){
        ArrayList<Integer> aList = edges[curr];
        for(int a:aList){
            if(!visited[a]){
                visited[a] = true;
                dfsTranspose(edges, a, visited, curArrayList);
            }
        }
        curArrayList.add(curr);
    }

    public static ArrayList<ArrayList<Integer>> getComponents(Stack<Integer> stack, ArrayList<Integer>[] transpose, boolean[] visited){
        ArrayList<ArrayList<Integer>> components = new ArrayList<>();

        while(!stack.empty()){
            int start = stack.pop();
            if(!visited[start]){
                ArrayList<Integer> comp = new ArrayList<>();
                visited[start] = true;
                dfsTranspose(transpose, start, visited, comp);
                components.add(comp);
            }           
        }
        return components;
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int v = scn.nextInt();
        int e = scn.nextInt();
        ArrayList<Integer>[] edges = new ArrayList[v+1];
        ArrayList<Integer>[] transpose = new ArrayList[v+1];
        boolean[] visited = new boolean[v+1];

        for(int i=0;i<=v;i++){
            edges[i] = new ArrayList<>();
        }
        for(int i=0;i<=v;i++){
            transpose[i] = new ArrayList<>();
        }
        Arrays.fill(visited, false);

        for(int i=0;i<e;i++){
            int v1 = scn.nextInt();
            int v2 = scn.nextInt();
            edges[v1].add(v2);
            transpose[v2].add(v1);
        }
        Stack<Integer> stack = new Stack<>();
        stack = traverse(v, edges, visited);

        Arrays.fill(visited, false);

        ArrayList<ArrayList<Integer>> ans = getComponents(stack, transpose, visited);
        for(ArrayList<Integer> aList:ans){
            for(int a : aList){
                System.out.print(a+" ");
            }
            System.out.println("");
        }
        

    }
}