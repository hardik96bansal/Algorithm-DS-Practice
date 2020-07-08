package CodingNinjas.Prerequisites;

import java.util.Scanner;

class MaxProdSubarray{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        long[] arr = new long[100005];
        long currProd = 1, maxProd=0;

        for(int i=0;i<n;i++){
            arr[i] = scn.nextLong();
        }
        for(int i=0;i<n;i++){
            currProd = currProd*arr[i];
            if(currProd==0) currProd=1;
            maxProd = Math.max(currProd, maxProd);

        }

        System.out.println(""+maxProd);

    }
}