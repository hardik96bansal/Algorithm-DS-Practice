package SearchSortAppl;

import java.util.Arrays;
import java.util.Scanner;

class DistributeCandies{
    
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        long t = scn.nextLong();

        while(t>0){
            int n = scn.nextInt();
            int k = scn.nextInt();
            long[] arr = new long[n];

            for(int i=0;i<n;i++){
                arr[i] = scn.nextLong();                
            }
            Arrays.sort(arr);
            if(k<=n){
                System.out.println(arr[n-k]);
            }
            else{
                
            }
            

            t--;
        }
    }

}