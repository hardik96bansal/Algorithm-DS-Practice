package CodingNinjas.AdvancedGraphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeSet;

public class Bottoms {
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
    public static void dfsTranspose(int curr, ArrayList<Integer>[] edges, boolean[] visited, HashSet<Integer> comp){
        ArrayList<Integer> aList = edges[curr];
        for(int a: aList){
            if(!visited[a]){
                visited[a] = true;
                dfsTranspose(a, edges, visited, comp);
            }
        }
        comp.add(curr);
    }

    public static ArrayList<HashSet<Integer>> getComponents(Stack<Integer> stack, boolean[] visited, ArrayList<Integer>[] edges){
        ArrayList<HashSet<Integer>> components = new ArrayList<>();
        while(!stack.isEmpty()){
            int top = stack.pop();
            if(!visited[top]){
                visited[top] = true;
                HashSet<Integer> comp = new HashSet<>();
                dfsTranspose(top, edges, visited, comp);
                components.add(comp);
            }
        }
        return components;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        while(true){
            int v = scn.nextInt();
            if(v==0) break;
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
            ArrayList<HashSet<Integer>> components = getComponents(stack, visited, transpose);
            
            HashSet<Integer> ansComponents = new HashSet<>();
            for(int i=0;i<components.size();i++){
                ansComponents.add(i);
            }

            TreeSet<Integer> ans = new TreeSet<>();
            
            for(int i=0;i<components.size();i++){
                HashSet<Integer> comp= components.get(i);
                for(int vert : comp){
                    boolean violated = false;
                    ArrayList<Integer> aList = edges[vert];
                    for(int a:aList){
                        if(!comp.contains(a)){
                            violated = true;
                            ansComponents.remove(i);
                            break;
                        }
                    }
                    if(violated) break;
                }                
            }

            for(int a: ansComponents){
                ans.addAll(components.get(a));
            }

            for(int a:ans){
                System.out.print(a+" ");
            }           
            System.out.println("");
        }

        scn.close();
    }
}