package Graphs2;

import java.util.HashSet;
import java.util.Scanner;

public class Dijkastras {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int v = scn.nextInt();
        int e = scn.nextInt();
        int[][] matrix = new int[v][v];
        int[] distace = new int[v];
        HashSet<Integer> visited = new HashSet<Integer>();
        HashSet<Integer> notVisited = new HashSet<Integer>();
        int source = 0;

        for(int i=0;i<v;i++){
            distace[i] = Integer.MAX_VALUE;
            notVisited.add(i);
        }
        distace[source] = 0;
        

        for(int i=0;i<e;i++){
            int v1 = scn.nextInt();
            int v2 = scn.nextInt();
            int w = scn.nextInt();
            matrix[v1][v2] = w;
            matrix[v2][v1] = w;
        }

        while(visited.size()!=v){
            int index = -1;
            int indexDist = Integer.MAX_VALUE;
            for(int i:notVisited){
                if(distace[i]<indexDist){
                    indexDist = distace[i];
                    index = i;
                }
            }
            for(int i=0;i<v;i++){
                if(matrix[index][i]!=0 && (matrix[index][i]+indexDist)<distace[i] && notVisited.contains(i)){
                    distace[i] = matrix[index][i]+indexDist;
                }
            }
            visited.add(index);
            notVisited.remove(index);
        }

        for(int i=0;i<v;i++){
            System.out.println(i+ " "+ distace[i]);
        }
    }
}