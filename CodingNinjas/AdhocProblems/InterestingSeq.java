package CodingNinjas.AdhocProblems;

import java.util.Arrays;
import java.util.Scanner;

public class InterestingSeq {

    public static int callMe(int[] arr, int target, int k, int l){
        int n = arr.length;
        int[] diff = new int[n];
        int toBeReduced = 0, toBeIncreased =0;
        for(int i=0;i<n;i++){
            diff[i] = target - arr[i];
            if(diff[i]<0) toBeReduced += diff[i];
            else toBeIncreased += diff[i];
        }

        if(toBeReduced+toBeIncreased<0) return -1;

        int kCount = 0, lCount = 0;      
        int i=0,j=n-1;
        while(i<j && diff[j]<0){
            if(diff[j]+diff[i]<0){
                kCount = kCount + diff[i];
                diff[j] += diff[i];
                i++;
            }                
            else if(diff[j]+diff[i]>0){
                kCount += -1*diff[j];
                diff[i] += diff[j];
                j--;
            }
            else{
                kCount += diff[i];
                i++;
                j--;
            }
        
        }

        while(diff[i]>0){
            lCount += diff[i];
            i++;
        }

        return kCount*k+lCount*l;        
    }


    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        int l = scn.nextInt();
        int[] arr = new int[n];

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
            if(arr[i]<min) min = arr[i];
            if(arr[i]>max) max = arr[i];
        }
        Arrays.sort(arr);

        int ans = Integer.MAX_VALUE;
        int[] reff = new int[max-min+1];
        for(int i=min;i<=max;i++){
            reff[i-min] = callMe(arr, i, k, l);
            if(reff[i-min]<ans && reff[i-min]!=-1) ans=reff[i-min];
        }

        System.out.println(""+ans);

    }
}