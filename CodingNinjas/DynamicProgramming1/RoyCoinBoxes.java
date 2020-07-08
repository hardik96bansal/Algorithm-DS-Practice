package CodingNinjas.DynamicProgramming1;

import java.util.Arrays;
import java.util.Scanner;

public class RoyCoinBoxes {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int d = scn.nextInt();

        int[] reff = new int[n+1];
        int[] starting = new int[n+1];
        int[] ending = new int[n+1];
        int[] count = new int[n+1];
        Arrays.fill(reff, 0);
        for(int i=0;i<d;i++){
            int start = scn.nextInt();
            int end = scn.nextInt();

            starting[start]++;
            ending[end]++;
        }
        count[1] = starting[1];

        for(int i=2;i<=n;i++){
            count[i] = count[i-1]+starting[i]-ending[i-1];
        }

        for(int i=0;i<=n;i++){
            reff[count[i]]++;
        }

        int q = scn.nextInt();
        for(int i=n-1;i>=1;i--){
            reff[i] = reff[i]+reff[i+1];
        }
        for(int i=0;i<q;i++){
            int x = scn.nextInt();
            System.out.println(reff[x]);
        }
    }

}