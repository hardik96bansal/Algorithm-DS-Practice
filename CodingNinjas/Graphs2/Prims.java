package Graphs2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

class Edge1{
    int vertex;
    int parent;
    int weight;

    public Edge1(int vertex, int parent, int weight) {
        this.vertex = vertex;
        this.parent = parent;
        this.weight = weight;
    }
}
public class Prims {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int v = scn.nextInt();
        int e = scn.nextInt();
        int[] vertex = new int[v];
        int[] parent = new int[v];
        int[] weight = new int[v];
        int[][] matrix = new int[v][v];
        HashSet<Integer> visited = new HashSet<Integer>();
        HashSet<Integer> notVisited = new HashSet<Integer>();

        for(int i=0;i<v;i++){
            vertex[i] = i;
            notVisited.add(i);
        }
        Arrays.fill(parent, -1);
        Arrays.fill(weight, Integer.MAX_VALUE);
        weight[0] = 0;

        for(int i=0;i<e;i++){
            int v1 = scn.nextInt();
            int v2 = scn.nextInt();
            int w = scn.nextInt();

            matrix[v1][v2] = w;
            matrix[v2][v1] = w;
        }

        while(visited.size()!=v){
            int minWeight = Integer.MAX_VALUE;
            int index = -1;
            for(int i:notVisited){
                if(weight[i]<minWeight){
                    index = i;
                    minWeight = weight[i];
                }
            }
            for(int j=0;j<v;j++){
                if(matrix[index][j]!=0 && matrix[index][j]<weight[j] && notVisited.contains(j)){
                    weight[j] = matrix[index][j];
                    parent[j] = index;
                }
            }
            notVisited.remove(index);
            visited.add(index);
        }

        for(int i=1;i<v;i++){
            if(i<parent[i])System.out.println(i + " " + parent[i] + " " + weight[i]);
            else System.out.println(parent[i] + " " + i + " " + weight[i]);;
        }

        scn.close();
    }
    
}