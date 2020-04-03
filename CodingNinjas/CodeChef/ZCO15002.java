package CodeChef;

import java.util.Arrays;
import java.util.Scanner;

public class ZCO15002 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        long[] arr = new long[n];

        for(int i=0;i<n;i++){
            arr[i] = scn.nextLong();
        }

        Arrays.sort(arr);

        long ans = 0;

        for(int i=0;i<n-1;i++){
            for(int j=i;j<n;j++){
                if(arr[j]-arr[i]>=k){
                    ans = ans+n-j;
                    break;
                }
            }
        }
        System.out.println(""+ans);
    }

}