package AdhocProblems;

import java.util.Scanner;
import java.util.TreeMap;

public class RectangleHeights {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        TreeMap<Integer, Integer> hMap = new TreeMap<>();
        int maxL = -1;

        for(int i=0;i<n;i++){
            int l = scn.nextInt();
            l=l/2;
            if(l>maxL) maxL=l;
            int h = scn.nextInt();
            hMap.put(l, h);
        }

        int[] arr = new int[maxL+1];

        for(int i=maxL;i>0;i--){
            if(hMap.get(i)==null){
                arr[i] = arr[i+1];
            }
            else{
                if(i!=maxL && hMap.get(i)<arr[i+1]){
                    arr[i] = arr[i+1];
                }
                else{
                    arr[i] = hMap.get(i);
                }
            }
        }

        int ans = 0;

        for(int i=maxL;i>0;i--){
            ans = ans + arr[i];
        }
        System.out.println(""+ans*2);

    }

}