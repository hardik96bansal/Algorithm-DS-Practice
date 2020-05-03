package DynamicProgramming1;

import java.util.Arrays;

public class MinSqCount {

    public static int minCountUtil(int n, int[] arr) {
        if(n<=3){
            return n;
        }

        int ans = n;
        if(arr[n]!=-1) return arr[n];
        for(int i=1;i<=n;i++){
            int temp = i*i;
            if(temp>n) break;
            ans = Math.min(ans, 1+minCountUtil(n-temp, arr));
        }
        arr[n] = ans;
        return ans;
    }

    public static int minCount(int n){
        int[] arr = new int[n+1];
        Arrays.fill(arr, -1);
        return minCountUtil(n, arr);
    }

    public static void main(String[] args) {
        System.out.println(minCount(67));
    }

}