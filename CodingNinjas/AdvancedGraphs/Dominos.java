package AdvancedGraphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Dominos {
    public static void dfs(int curr, ArrayList<Integer>[] edges, boolean[] visited, Stack<Integer> stack){
        ArrayList<Integer> aList = edges[curr];
        for(int a:aList){
            if(!visited[a]){
                visited[a] = true;
                dfs(a, edges, visited, stack);
            }
        }
        stack.add(curr);
    }

    public static Stack<Integer> getStack(int v, ArrayList<Integer>[] edges, boolean[] visited){
        Stack<Integer> stack = new Stack<>();
        for(int i=1;i<=v;i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(i, edges, visited, stack);
            }
        }
        return stack;
    }

    public static void dfsTranspose(int curr, ArrayList<Integer>[] edges, boolean[] visited, ArrayList<Integer> comp){
        ArrayList<Integer> aList = edges[curr];
        for(int a: aList){
            if(!visited[a]){
                visited[a] = true;
                dfsTranspose(a, edges, visited, comp);
            }
        }
        comp.add(curr);
    }

    public static ArrayList<ArrayList<Integer>> getComponents(Stack<Integer> stack, ArrayList<Integer>[] edges, boolean[] visited){
        ArrayList<ArrayList<Integer>> components = new ArrayList<>();
        while(!stack.isEmpty()){
            int top = stack.pop();
            if(!visited[top]){
                ArrayList<Integer> comp = new ArrayList<>();
                visited[top] = true;
                dfsTranspose(top, edges, visited, comp);
                components.add(comp);
            }            
        }
        return components;
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t>0){
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

            for(int i=0;i<e;i++){
                int v1 = scn.nextInt();
                int v2 = scn.nextInt();
                edges[v1].add(v2);
                transpose[v2].add(v1);
            }
            
            Arrays.fill(visited, false);

            Stack<Integer> stack = getStack(v, edges, visited);

            Arrays.fill(visited, false);
            ArrayList<ArrayList<Integer>> ans = getComponents(stack, transpose, visited);
            Arrays.fill(visited, false);
            // System.out.println(ans.size());
            int count = 0;
            for(int i=0;i<ans.size();i++){
                ArrayList<Integer> aList = ans.get(i);
                for(int a:aList){
                    if(!visited[a]){
                        count++;
                        dfs(a, edges, visited, stack);
                    }
                }
            }
            System.out.println(count);
            t--;
        }
    }
}