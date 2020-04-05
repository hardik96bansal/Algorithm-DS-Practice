package SearchSortAppl;

import java.util.Arrays;
import java.util.Scanner;

public class AggressiveCows {

    public static long callMe(long[] arr, long start, long end, int cows){
        int curr = 0;
        

        if(end<=start){
            return start;
        }
        if(end-start == 1){
            int check = 0;

            for(int i=0;i<arr.length-1;i++){
                check = i;
                int remaining = cows-1;
                curr = 1;
                for(int j=check+1;j<arr.length;j++){
                    if(arr[j]-arr[check]>=end){
                        curr++;
                        remaining--;
                        check=j;
                    }
                    if(remaining ==0){
                        break;
                    }
                }
                if(remaining ==0){
                    break;
                }
            }
            if(curr>=cows){
                return end;
            }
            return start;
        }
        
        long mid = (start+end)/2;       
        int check = 0;

        for(int i=0;i<arr.length-1;i++){
            check = i;
            int remaining = cows-1;
            curr = 1;
            for(int j=check+1;j<arr.length;j++){
                if(arr[j]-arr[check]>=mid){
                    curr++;
                    remaining--;
                    check=j;
                }
                if(remaining ==0){
                    break;
                }
            }
            if(remaining ==0){
                break;
            }
        }

        if(curr>=cows){
            return callMe(arr, mid, end, cows);
        }
        else{
            return callMe(arr, start, mid-1, cows);
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        long t = scn.nextLong();

        while(t>0){
            int n = scn.nextInt();
            int c = scn.nextInt();
            long[] arr = new long[n];
            long max = Long.MIN_VALUE;

            for(int i=0;i<n;i++){
                arr[i] = scn.nextInt();
                if(arr[i]>max){
                    max = arr[i];
                }
            }

            Arrays.sort(arr);
            
            long ans = callMe(arr, 0, max, c);
            System.out.println(""+ans);
            t--;
        }
    }

}