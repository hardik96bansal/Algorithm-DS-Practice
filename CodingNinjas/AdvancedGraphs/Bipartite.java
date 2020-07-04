package AdvancedGraphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bipartite {
    public static boolean isBipartite(int v, ArrayList<Integer>[] edges){
        HashSet<Integer>[] sets = new HashSet[2];
        sets[0] = new HashSet<>();
        sets[1] = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        sets[0].add(1);
        queue.add(1);

        while(!queue.isEmpty()){
            int out = queue.poll();
            int currSet = sets[0].contains(out) ? 0 : 1;
            for(int neighbour : edges[out]){
                if(!sets[0].contains(neighbour) && !sets[1].contains(neighbour)){
                    sets[1-currSet].add(neighbour);
                    queue.add(neighbour);
                }
                if(sets[currSet].contains(neighbour)){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
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

        if(isBipartite(v, edges)) System.out.println("BIPARTITE");
        else System.out.println("NO BRO");
    }
    
}