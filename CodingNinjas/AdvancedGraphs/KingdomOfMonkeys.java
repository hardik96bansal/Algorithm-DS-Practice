package CodingNinjas.AdvancedGraphs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeSet;

public class KingdomOfMonkeys {

    public static long bfs(int v, int curr, ArrayList<Integer>[] edges, boolean[] visited, int[] bananas){
        long ans = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(curr);
        ans = ans+bananas[curr];
        visited[curr] = true;

        while(!queue.isEmpty()){
            int top = queue.poll();
            for(int a : edges[top]){
                if(!visited[a]){
                    visited[a] = true;
                    ans = ans + bananas[a];
                    queue.add(a);
                }
            }
        }
        
        return ans;
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t>0){
            int v = scn.nextInt();
            int e = scn.nextInt();
            ArrayList<Integer>[] edges = new ArrayList[v+1];
            for(int i=0;i<=v;i++){
                edges[i] = new ArrayList<>();
            }
            for(int i=0;i<e;i++){
                int v1 = scn.nextInt();
                int v2 = scn.nextInt();
                edges[v1].add(v2);
                edges[v2].add(v1);
            }
            int[] bananas = new int[v+1];
            for(int i=1;i<=v;i++){
                bananas[i] = scn.nextInt();
            }
            boolean[] visited = new boolean[v+1];
            Arrays.fill(visited, false);
            TreeSet<Long> components = new TreeSet<>();
            for(int i=1;i<=v;i++){
                if(!visited[i]){
                    long count = bfs(v, i, edges, visited, bananas);
                    components.add(count);
                }
            }
            System.out.println(components.last());
            t--;
        }
    }
}