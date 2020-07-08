package CodingNinjas.DynamicProgramming1;

import java.util.Arrays;
import java.util.Scanner;

public class JonSnow {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        int x = scn.nextInt();

        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }

        for(int j=0;j<k;j++){
            Arrays.sort(arr);
            for(int i=0;i<n;i=i+2){
                arr[i] = arr[i] ^ x;
            }
        }

        Arrays.sort(arr);

        System.out.println(arr[n-1]+" "+ arr[0]);
    }

}