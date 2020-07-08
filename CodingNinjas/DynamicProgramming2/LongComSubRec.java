package CodingNinjas.DynamicProgramming2;

import java.util.Arrays;

public class LongComSubRec {

    public static int lcs(String a, String b, int al, int bl, int[][] arr){
        if(a.length()==0 || b.length()==0){
            return 0;
        }

        if(arr[al][bl] != -1){
            return arr[al][bl];
        }
        int ans = 0;
        if(a.charAt(0) == b.charAt(0)){
            ans = 1+lcs(a.substring(1), b.substring(1), al-1, bl-1, arr);
        }
        else{
            int opt1 = lcs(a.substring(1), b, al-1, bl, arr);
            int opt2 = lcs(a, b.substring(1), al, bl-1, arr);
            ans = Math.max(opt1, opt2);
        }
        arr[al][bl] = ans;
        return ans;
    }

    public static int lcsIter(String a, String b){
        int m = a.length();
        int n = b.length();

        int[][] arr = new int[m+1][n+1];

        for(int i=0;i<m;i++){
            arr[i][0] = 0;
        }

        for(int i=0;i<n;i++){
            arr[0][n] = 0;
        }

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(a.charAt(m-i)==b.charAt(n-j)){
                    arr[i][j] = 1 + arr[i-1][j-1];
                }
                else{
                    arr[i][j] = Math.max(arr[i-1][j], arr[i][j-1]);
                }
            }
        }

        return arr[m][n];
    }

    public static void main(String[] args) {
        String a = "aabbcc";
        String b = "abc";

        int m = a.length();
        int n = b.length();
        int[][] arr = new int[m+1][n+1];

        for(int[] temp:arr){
            Arrays.fill(temp, -1);
        }

        int ansRec = lcs(a, b, m, n, arr);
        int ansIter = lcsIter(a, b);
        System.out.println(ansIter);

        
    }
    
}