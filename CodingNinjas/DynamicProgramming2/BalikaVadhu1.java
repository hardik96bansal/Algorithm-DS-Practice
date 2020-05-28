package DynamicProgramming2;

import java.util.Arrays;
import java.util.Scanner;

public class BalikaVadhu1 {
    public static int blessingScore(String s1, int k){
        int l = s1.length();
        int start = 0;
        if(k<=l) start = l-k;

        char[] arr = s1.toCharArray();
        Arrays.sort(arr);
        int res = 0;
        for(int i = start; i<l;i++){
            res += arr[i];
        }
        //System.out.print("hb "+s1+","+res);
        return res;
    }

    public static String lcs(String s1, String s2, int m, int n, int k, String[][] arr){
        if(s1.length()==0 || s2.length()==0){
            return "";
        }
        if(!arr[m][n].equals("123")){
            return arr[m][n];
        }
        String ans = "";
        if(s1.charAt(0)==s2.charAt(0)){
            ans = s1.charAt(0) + lcs(s1.substring(1), s2.substring(1), m-1, n-1, k, arr);
        }
        else{
            String opt1 = lcs(s1.substring(1),s2,m-1,n, k, arr);
            String opt2 = lcs(s1,s2.substring(1),m,n-1, k, arr);
            if(opt1.equals("")) ans = opt2;
            else if(opt2.equals("")) ans = opt1;
            else{
                int b1 = blessingScore(opt1, k);
                int b2 = blessingScore(opt2, k);

                //System.out.print("hb "+ m+","+n+","+opt1+","+opt2+","+b1+","+b2);

                if(b1>b2){
                    ans = opt1;
                }
                else{
                    ans = opt2;
                }   
            }
        }
        arr[m][n] = ans;
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();        

        while(t>0){
            String waste = scn.nextLine();
            String s1 = scn.nextLine();
            String s2 = scn.nextLine();
            int k = scn.nextInt();

            int m = s1.length();
            int n = s2.length();
            String[][] arr = new String[m+1][n+1];
            int[][] bScore = new int[m+1][n+1];

            for(String[] ar: arr){
                Arrays.fill(ar, "123");
            }
            for(int[] ar: bScore){
                Arrays.fill(ar, -1);
            }

            lcs(s1, s2, m, n, k, arr);
            String ans = arr[m][n];
            if(ans.length()<k){
                System.out.println(0);
            }
            else{
                System.out.println(blessingScore(ans, k));
            }
            

            t--;
        }
        scn.close();
    }
    
}