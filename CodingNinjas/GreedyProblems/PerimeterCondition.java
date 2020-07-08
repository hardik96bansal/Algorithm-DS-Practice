package CodingNinjas.GreedyProblems;

import java.util.Arrays;
import java.util.Scanner;

public class PerimeterCondition {

    public static boolean trianglePossible(int a,int b, int c){
        if(a+b>c && b+c>a && c+a>b){
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i]= scn.nextInt();
        }

        Arrays.sort(arr);

        for(int i=n-1;i>=2;i--){
            if(trianglePossible(arr[i], arr[i-1], arr[i-2])){
                System.out.println(arr[i-2] + " " + arr[i-1] + " " + arr[i]);
                return;
            }
        }

        System.out.println("-1");        
    }
}