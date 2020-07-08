package CodingNinjas.DynamicProgramming1;

import java.util.Arrays;
import java.util.Scanner;

public class JonSnow1 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        int x = scn.nextInt();

        int[] arr = new int[n];
        int[] reff = new int[2000];
        int[] temp = new int[2000];
        Arrays.fill(reff, 0);
        Arrays.fill(temp, 0);

        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
            reff[arr[i]]++;
        }

        for(int i=0;i<k;i++){
            int counted = 0;
            for(int j=0;j<1025;j++){
                if(reff[j]==0) continue;
                int target = j^x;
                int tAdd = 0;
                int cAdd = 0;
                if(j%2==0){
                    tAdd = reff[j]/2;
                    cAdd = reff[j]/2;
                }
                else{
                    if(counted%2==0){
                        tAdd = reff[j]/2+1;
                        cAdd = reff[j]/2;
                    }
                    else{
                        tAdd = reff[j]/2;
                        cAdd = reff[j]/2+1;
                    }
                }
                temp[j] += cAdd;
                temp[target] += tAdd;
                counted += reff[j];
            }
            reff = Arrays.copyOf(temp, 2000);
            Arrays.fill(temp, 0);
        }

        int big = 0, small = 0;

        for(int i=0;i<1025;i++){
            if(reff[i]!=0){
                small = i;
                break;
            }
        }
        for(int i=1025;i>=0;i--){
            if(reff[i]!=0){
                big = i;
                break;
            }
        }

        System.out.println(big+" "+small);
    }

}