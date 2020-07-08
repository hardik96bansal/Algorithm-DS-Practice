package CodingNinjas.Graphs1;

import java.util.Arrays;
import java.util.Scanner;

public class DFS {
    public static void depthFirstTrav(int n, int[][] edges, int curr, boolean[] included){
        System.out.print(curr+" ");
        included[curr] = true;
        for(int i=0;i<n;i++){
            if(edges[curr][i]==1 && !included[i]){
                depthFirstTrav(n, edges, i, included);
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int e = scn.nextInt();
        int[][] edges = new int[n][n];

        for(int[] ar:edges){
            Arrays.fill(ar, 0);
        }

        for(int i=0;i<e;i++){
            int v1 = scn.nextInt();
            int v2 = scn.nextInt();
            edges[v1][v2] = 1;
            edges[v2][v1] = 1;
        }

        boolean[] included = new boolean[n];
        Arrays.fill(included, false);

        depthFirstTrav(n, edges, 0, included);
        

        
    }
}