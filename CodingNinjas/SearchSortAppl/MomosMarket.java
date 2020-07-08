package CodingNinjas.SearchSortAppl;

import java.util.Scanner;

public class MomosMarket {
    public static int findIndex(long[] arr, int start, int end, long num){
        if(end<=start){
            if(arr[start]<num) return start+1;
            return start;
        }
        int mid = (end + start)/2;
        if(arr[mid]<=num){
            return findIndex(arr, mid+1, end, num);
        }
        else{
            return findIndex(arr, start, mid, num);
        }
    }
    
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        long[] arr = new long[n];
        long[] reff = new long[n];
        for(int i=0;i<n;i++){
            arr[i] = scn.nextLong();
            if(i==0){
                reff[i] = arr[i];
            }
            else{
                reff[i] = reff[i-1] + arr[i];
            }
        }
        
        long q = scn.nextLong();

        while(q>0){
            long x = scn.nextLong();
            int oneExtra = findIndex(reff, 0, n-1, x);
            if(oneExtra == 0){
                System.out.println("0 "+x);
            }
            else{
                System.out.println(oneExtra+" "+(x-reff[oneExtra-1]));
            }
            q--;
        }
    }

}