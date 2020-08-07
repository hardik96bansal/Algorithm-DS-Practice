package CodingNinjas.FenwickTree;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Coder{
    int x, y;
    int index;

    Coder(int x, int y, int index){
        this.x = x;
        this.y = y;
        this.index = index;
    }
}

public class CoderRating { 
    public static void update(int y, int[] BIT){
        while(y<=100001){
            BIT[y]++;
            y += y&(-y);
        }
    }

    public static int query(int y, int[] BIT){
        int ans = 0;
        while(y>0){
            ans = ans+BIT[y];
            y -= y&(-y);
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        Coder[] arr = new Coder[n];

        for(int i=0;i<n;i++){
            int x = scn.nextInt();
            int y = scn.nextInt();
            arr[i] = new Coder(x, y, i);
        }

        Comparator<Coder> coderComparator = new Comparator<Coder>(){
            @Override
            public int compare(Coder arg0, Coder arg1) {
                if(arg0.x==arg1.x) return arg0.y-arg1.y;
                return arg0.x-arg1.x;
            }
        };

        Arrays.sort(arr, coderComparator);

        int[] BIT = new int[100001];
        int[] ans = new int[n];

        for(int i=0;i<n;){
            int endIndex = i;
            while(endIndex<n && arr[i].x==arr[endIndex].x && arr[i].y==arr[endIndex].y){
                ans[arr[endIndex].index] = query(arr[endIndex].y, BIT);
                endIndex++;
            }
            endIndex = i;
            while(endIndex<n && arr[i].x==arr[endIndex].x && arr[i].y==arr[endIndex].y){
                update(arr[i].y, BIT);
                endIndex++;
            }
            i = endIndex;          
        }

        for(int a:ans){
            System.out.print(a+" ");
        }

        

        scn.close();
    }
}