package Backtracking;

import java.util.Scanner;

public class EmployeeSort {

    public static void merge(int[] arr, int n, int start, int mid, int end){
        int[] temp = new int[n];
        int i=start;
        int j=mid;
        int k=start;

        
        while(i<mid && j<=end){
            if(arr[i]<arr[j] && arr[j]-arr[i]==1 && j-i==1){
                temp[k] = arr[i];
                i++;
                k++;
            }
            else if(arr[j]<arr[i] && arr[i]-arr[j]==1 && j-i==1){
                temp[k] = arr[j];
                j++;
                k++;
            }
            else{
                temp[k] = arr[i];
                i++;
                k++;
            }
        }

        while(i<mid){
            temp[k] = arr[i];
            k++;
            i++;
        }

        while(j<=end){
            temp[k] = arr[j];
            k++;
            j++;
        }

        for(i=start;i<=end;i++){
            arr[i] = temp[i];
        }


    }

    public static void customSort(int[] arr, int n, int start, int end){
        if(start-end>=0){
            return;
        }
        int mid = (start+end)/2;
        customSort(arr, n, start, mid);
        customSort(arr, n, mid+1, end);
        merge(arr, n, start, mid+1, end);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();

        while(t>0){
            int n=scn.nextInt();
            int[] arr = new int[n];

            for(int i=0;i<n;i++){
                arr[i] = scn.nextInt();
            }

            customSort(arr,n,0,n-1);
            for(int a:arr){
                System.out.print(a+" ");
            }

            boolean possible = true;
            for(int i=0;i<n-1;i++){
                if(arr[i]>arr[i+1]){
                    possible = false;
                }
            }
            if(possible) System.out.println("Yes");
            else System.out.println("No");

            t--;
        }
    }

}