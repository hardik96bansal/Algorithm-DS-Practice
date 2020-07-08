package CodingNinjas.SearchSortAppl;

import java.util.Scanner;

public class Murder1 {

    public static long merge(long[] arr, int start, int mid, int end){
        long currAns = 0;

        int i = start;
        int j = mid;

        long[] tempArr = new long[end-start+1];

        for(int k=0;k<end-start+1;k++){
            if(i==mid){
                tempArr[k] = arr[j];
                j++;
            }
            else if(j==end+1){
                tempArr[k] = arr[i];
                i++;
            }
            else{
                if(arr[i]<arr[j]){
                    tempArr[k] = arr[i];
                    currAns = currAns+arr[i]*(end-j+1);
                    i++;
                }
                else{
                    tempArr[k] = arr[j];
                    j++;
                }
            }
        }

        for(int k=start; k<end+1; k++){
            arr[k] = tempArr[k-start];
        }


        return currAns;
    }

    public static long divide(long[] arr, int start, int end){
        long ans = 0;
        if(end<=start){
            return 0;
        }
        int mid = (start+end)/2;
        ans = ans+divide(arr, start, mid);
        ans = ans+divide(arr, mid+1, end);
        ans = ans+merge(arr, start, mid+1, end);

        return ans;
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        long t = scn.nextLong();

        while(t>0){
            int n = scn.nextInt();
            long[] arr = new long[n];

            for(int i=0;i<n;i++){
                arr[i] = scn.nextLong();
            }
            long ans = divide(arr, 0, n-1);
            System.out.println(""+ans);

            t--;
        }

    }

}