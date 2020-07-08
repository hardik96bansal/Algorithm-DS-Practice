package CodingNinjas.GreedyProblems;

import java.util.Arrays;
import java.util.Scanner;

public class NikunjDonuts {
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }
        Arrays.sort(arr);
        
        int ans = 0;
        for(int i=n-1;i>=0;i--){
            ans += arr[i]*1<<(n-i-1);
        }

        System.out.println(ans);
        scn.close();
    }
}