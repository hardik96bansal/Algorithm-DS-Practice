package CodingNinjas.GreedyProblems;

import java.util.Arrays;
import java.util.Scanner;

public class ProblemDiscussion {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();

        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }

        Arrays.sort(arr);
        int initDiff = arr[n-1]-arr[0];

        int smallest = arr[0]+k;
        int biggest = arr[n-1]-k;

        if(biggest<smallest){
            int temp = smallest;
            smallest = biggest;
            biggest = temp;
        }

        int remaining = n-2;
        int curr = 1;
        while(remaining>0){
            int sub = arr[curr]-k;
            int add = arr[curr]+k;

            if(sub<smallest&&add>biggest){
                if(smallest-sub<add-biggest){
                    smallest = sub;
                }
                else{
                    biggest = add;
                }
            }
            curr++;
            remaining--;
        }

        int afterDiff = biggest-smallest;
        System.out.println(Math.min(initDiff, afterDiff));        
        scn.close();
    }
    
}