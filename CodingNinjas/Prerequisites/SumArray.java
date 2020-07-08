package CodingNinjas.Prerequisites;

import java.util.Scanner;

class SumArray{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] arr = new int[100][100];
        int sum = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = scn.nextInt();
            }
        }
        
        for(int i=0;i<n;i++){
            sum = sum+arr[0][i];
            sum = sum+ arr[n-1][i];
        }
        
        for(int i=1;i<n-1;i++){
            sum = sum+arr[i][0];
            sum = sum+arr[i][n-1];
        }
        
        for(int i=1;i<n-1;i++){
            sum = sum+arr[i][i];
        }
        for(int i=1;i<n-1;i++){
            sum = sum+arr[n-1-i][i];
        }
        if(n%2==1){
            int x = (n-1)/2;
            sum = sum-arr[x][x];
        }

        System.out.println(""+sum);


    }
}