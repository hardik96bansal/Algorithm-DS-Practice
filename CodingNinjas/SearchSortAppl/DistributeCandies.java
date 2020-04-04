package SearchSortAppl;

import java.util.Arrays;
import java.util.Scanner;

class DistributeCandies{

    public static long callMe(long[] arr, long start, long end, int k){
        long curr = 0;
        if(end<=start){
            return start;
        }
        if(end-start == 1){
            long curr1 = 0;
            long curr2 = 0;

            for(int i=0;i<arr.length;i++){
                curr1 = curr1+arr[i]/start;
            }
            for(int i=0;i<arr.length;i++){
                curr2 = curr2+arr[i]/end;
            }
            if(curr2>=k){
                return end;
            }
            return start;

        }
        long mid = (start+end)/2;

        for(int i=0;i<arr.length;i++){
            curr = curr+arr[i]/mid;
        }
        if(curr>=k){
            return callMe(arr, mid, end, k);
        }
        else{
            return callMe(arr, start, mid, k);
        }

    }
    
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        long t = scn.nextLong();

        while(t>0){
            int n = scn.nextInt();
            int k = scn.nextInt();
            long[] arr = new long[n];


            long max = Long.MIN_VALUE;
            long min = Long.MAX_VALUE;

            for(int i=0;i<n;i++){
                arr[i] = scn.nextLong();     
                if(arr[i]>max){
                    max = arr[i];
                }           
                if(arr[i]<min){
                    min = arr[i];
                }
            }

            long ans = callMe(arr, 0, max, k);

            System.out.println(ans);


            
            t--;
        }
    }

}