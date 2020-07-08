package CodingNinjas.AdhocProblems;

import java.util.Scanner;

class CostToConvert{

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n=scn.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
 
        for(int i=0;i<n;i++){
            arr1[i] = scn.nextInt();
        }

        for(int i=0;i<n;i++){
            arr2[i] = scn.nextInt();
        }
        
        int count = 0;

        for(int i=0;i<n-1;i++){
            if(arr1[i]!=arr2[i]){
                if(arr1[i]!=arr1[i+1] && arr1[i+1]!=arr2[i+1]){
                    int temp = arr1[i];
                    arr1[i] = arr1[i+1];
                    arr1[i+1] = temp;
                    count++;
                }
                else{
                    arr1[i] = ~ arr1[i];
                    count++;
                }
            }            
        }

        if(arr1[n-1]!=arr2[n-1]) count++;

        System.out.println(count);
    }
}