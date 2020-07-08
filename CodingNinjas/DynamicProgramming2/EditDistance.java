package CodingNinjas.DynamicProgramming2;

import java.util.Arrays;

public class EditDistance {

    public static int lcs(String s1, String s2, int remS1L, int remS2L, int[][] arr){
        if(s1.length()==0||s2.length()==0){
            return 0;
        }

        if(arr[remS1L][remS2L]!=-1){
            return arr[remS1L][remS2L];
        }
        
        int ans = 0;
        if(s1.charAt(0)==s2.charAt(0)){
            ans = 1+ lcs(s1.substring(1), s2.substring(1), remS1L-1, remS2L-1, arr);
        }
        else{
            int opt1 = lcs(s1.substring(1), s2, remS1L-1, remS2L, arr);
            int opt2 = lcs(s1, s2.substring(1), remS1L, remS2L-1, arr);
            ans = Math.max(opt1, opt2);
        }
        arr[remS1L][remS2L] = ans;
        return ans;

    }


    public static int callMe(String s1, String s2, int m, int n, int[][] arr){
        if(s1.length()==0 && s2.length()==0){
            return 0;
        }
        if(s1.length()==0){
            return s2.length();
        }
        if(s2.length()==0){
            return s1.length();
        }

        if(arr[m][n]!=-1){
            return arr[m][n];
        }

        int ans = 0;
        if(s1.charAt(0)==s2.charAt(0)){
            ans = callMe(s1.substring(1), s2.substring(1), m-1, n-1, arr);
        }
        else{
            int opt1 = 1 + callMe(s1.substring(1), s2, m-1, n, arr);
            int opt2 = 1 + callMe(s1, s2.substring(1), m, n-1, arr);
            int opt3 = 1 + callMe(s1.substring(1), s2.substring(1), m-1, n-1, arr);
            if(opt1<=opt2 && opt1<=opt3){
                ans = opt1;
            }
            else if(opt2<=opt1 && opt2<=opt3){
                ans = opt2;
            }
            else if(opt3<=opt2 && opt3<=opt1){
                ans = opt3;
            }
        }

        arr[m][n] = ans;
        return ans;
    }

    public static int editDistance(String s1, String s2){
        int remS1L = s1.length();
        int remS2L = s2.length();
        int[][] arr = new int[remS1L+1][remS2L+1];
        for(int[] temp : arr){
            Arrays.fill(temp, -1);
        }
        int ans = callMe(s1, s2, remS1L, remS2L, arr);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(editDistance("abcd", "acbd"));
        
    }
}