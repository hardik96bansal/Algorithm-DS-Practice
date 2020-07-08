package CodingNinjas.DynamicProgramming1;

import java.util.Arrays;
import java.util.Scanner;

public class AngryChildren {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        long[] arr = new long[n];
        long[] reff = new long[n];

        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }
        Arrays.sort(arr);
        reff[0] = 0;
        long currTotal = arr[0];

        for(int i=1;i<k;i++){
            reff[i] = reff[i-1] + (i)*arr[i] -currTotal;
            currTotal += arr[i];
        }

        for(int i=k;i<n;i++){
            int out = i-k;
            currTotal = currTotal - arr[out];
            reff[i] = reff[i-1] -2*currTotal +(k-1)*arr[out] + (k-1)*arr[i];
            currTotal += arr[i];
        }

        long ans = Long.MAX_VALUE;
        for(int i=k-1;i<n;i++){
            if(reff[i]<ans){
                ans = reff[i];
            }
        }

        System.out.println(""+ans);

    }
    
}