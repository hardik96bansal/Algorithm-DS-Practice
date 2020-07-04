package AdvancedGraphs;

import java.util.Scanner;

public class NewYearTranspotation {

    public static boolean hasPath(int start, int dest, int[] edges, int last){
        if(start==dest){
            return true;
        }
        if(start==last) return false;
        return hasPath(edges[start], dest, edges, last);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int t = scn.nextInt();
        int[] edges = new int[n];
        for(int i=1;i<n;i++){
            edges[i] = i+scn.nextInt();
        }

        if(hasPath(1, t, edges, edges[n-1])) System.out.println("YES");
        else System.out.println("NO");

    }
    
}