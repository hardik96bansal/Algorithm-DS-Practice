package Backtracking;

import java.util.Scanner;

public class EmployeeSort1 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();

        while (t > 0) {
            int n = scn.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = scn.nextInt();
            }

            boolean changeMade = true;

            while (changeMade) {
                changeMade = false;
                for (int i = 0; i < n - 1; i++) {
                    if (arr[i] > arr[i + 1] && (arr[i] - arr[i+1]) == 1) {
                        int temp = arr[i];
                        arr[i] = arr[i + 1];
                        arr[i + 1] = temp;
                        changeMade = true;
                    }
                }
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