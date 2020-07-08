package CodingNinjas.AdvancedGraphs;

import java.util.Arrays;
import java.util.Scanner;

public class PermutationSwaps {
    public static boolean hasPath(int n, int source, int dest, int[][] edges, boolean[] visited){
        if(source==dest){
            return true;
        }
        for(int i=0;i<=n;i++){
            if(edges[source][i]==1 && !visited[i]){
                visited[i] = true;
                boolean result = hasPath(n, i, dest, edges, visited);
                if(result){
                    return true;
                }
            }
        }
        return false;
    }

    public static void answer(int n, int[][] edges, int[][] changes){
        for(int i=0;i<=n;i++){
            int source = changes[i][0];
            int dest = changes[i][1];
            boolean[] visited = new boolean[n+1];
            Arrays.fill(visited, false);
            if(source != dest){
                visited[source] = true;
                boolean result = hasPath(n, source, dest, edges, visited);
                //System.out.println("path for "+ source+ " "+ dest+ " " + result);
                if(!result){
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();

        while(t>0){
            int n = scn.nextInt();
            int m = scn.nextInt();
            int[] orig = new int[n+1];
            int[] targ = new int[n+1];
            int[][] edges = new int[n+1][n+1];
            int[][] changes = new int[n+1][2];

            for(int i=1;i<=n;i++){
                orig[i] = scn.nextInt();
            }

            for(int i=1;i<=n;i++){
                targ[i] = scn.nextInt();
            }

            for(int i=0;i<m;i++){
                int v1 = scn.nextInt();
                int v2 = scn.nextInt();
                edges[v1][v2] = 1;
                edges[v2][v1] = 1;
            }

            for(int i=1;i<=n;i++){
                int dest = 0;
                while(targ[dest]!=orig[i]){
                    dest++;
                }
                changes[i][0] = i;
                changes[i][1] = dest;
            }

            answer(n, edges, changes);
            t--;
        }
        scn.close();
    }
    
}