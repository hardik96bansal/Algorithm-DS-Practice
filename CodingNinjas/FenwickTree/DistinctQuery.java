package CodingNinjas.FenwickTree;

import java.util.HashSet;
import java.util.Scanner;

public class DistinctQuery {
    public static void update(int n, int[] BIT){
        while(n<300001){
            BIT[n]++;
            n += n&(-n);
        }
    }

    public static int query(int n, int[] BIT){
        int ans = 0;
        while(n>0){
            ans += BIT[n];
            n -= n&(-n);
        }
        return ans;
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n+1];
        HashSet<Integer> set= new HashSet<>();

        for(int i=1;i<=n;i++){
            arr[i] = scn.nextInt();
        }

        int[] BIT = new int[300001];

        for(int i=1;i<=n;i++){
            if(!set.contains(arr[i])){
                update(i, BIT);
                set.add(arr[i]);
            }
        }

        int q = scn.nextInt();
        for(int i=0;i<q;i++){
            int n1 = scn.nextInt();
            int n2 = scn.nextInt();
            int an1 = query(n1-1, BIT);
            int an2 = query(n2, BIT);
            System.out.println(an2-an1);
        }
        scn.close();
    }
}