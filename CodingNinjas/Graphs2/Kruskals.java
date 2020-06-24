package Graphs2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Edge{
    int v1;
    int v2; 
    int weight;

    public Edge(int v1, int v2, int weight) {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }
}

public class Kruskals {

    public static int findParent(int n, int[] parent){
        if(n==parent[n]){
            return n;
        }
        return findParent(parent[n], parent);
    }

    public static boolean unionFind(int v1, int v2, int[] parent){
        int p1 = findParent(v1, parent);
        int p2 = findParent(v2, parent);

        if(p1==p2){
            return false;
        }

        parent[v2] = v1;
        return true;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int v = scn.nextInt();
        int e = scn.nextInt();
        ArrayList<Edge> edges = new ArrayList<>();

        for(int i=0;i<e;i++){
            int v1 = scn.nextInt();
            int v2 = scn.nextInt();
            int weight = scn.nextInt();
            Edge edge = new Edge(v1, v2, weight);
            edges.add(edge);
        }

        Comparator<Edge> cmp = new Comparator<Edge>() {

            @Override
            public int compare(Edge e1, Edge e2) {
                return e1.weight-e2.weight;
            }
        };

        Collections.sort(edges, cmp);
        ArrayList<Edge> ans = new ArrayList<>();
        int[] parent = new int[v];
        for(int i=0;i<v;i++){
            parent[i] = i;
        }

        int consEdges = 0;

        for(int i=0;i<e;i++){
            if(consEdges==v-1){
                break;
            }
            Edge edge = edges.get(i);
            if(unionFind(edge.v1, edge.v2, parent)){
                ans.add(edge);
                consEdges++;
            }
        }

        for(int i=0;i<ans.size();i++){
            Edge edge = ans.get(i);
            if(edge.v1<edge.v2)
                System.out.println(edge.v1 + " " + edge.v2 + " " + edge.weight);
            else
                System.out.println(edge.v2 + " " + edge.v1 + " " + edge.weight);
        }

    }
    
}