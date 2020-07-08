package CodingNinjas.SearchSortAppl;

import java.util.Scanner;

public class TajMahalEntry {

    public static void main(String[] args) {
        long smallest = Long.MAX_VALUE;
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        long[] arr = new long[n];
        for(int i=0;i<n;i++){
            arr[i] = scn.nextLong();
            if(arr[i]<smallest){
                smallest = arr[i];
            }
        }

        int pos = 0;
        

    }

}