package Backtracking;

import java.util.ArrayList;
import java.util.Scanner;

public class Crossword {
    public static boolean hFillPossible(char[][] arr, int i, int j, String word){
        boolean prevEmpty;
        if(j==0) prevEmpty = true;
        else prevEmpty = arr[i][j-1]=='+';

        int k=j,c=0;
        if(!prevEmpty){
            if(arr[i][j-1]!=word.charAt(0)) return false;
            else c++;
        }
        for(;k<10 && c<word.length();k++,c++){
            if(arr[i][k]=='-' || arr[i][k]==word.charAt(c)){}
            else break;
        }
        
        if(k<10 && arr[i][k]=='-') return false;
        if(c==word.length()) return true;
        else return false;
    }

    public static boolean vFillPossible(char[][] arr, int i, int j, String word){
        boolean prevEmpty;
        if(i==0) prevEmpty = true;
        else prevEmpty = arr[i-1][j]=='+';

        int k=i,c=0;
        if(!prevEmpty){
            if(arr[i-1][j]!=word.charAt(0)) return false;
            else c++;
        }
        for(;k<10 && c<word.length();k++,c++){
            if(arr[k][j]=='-' || arr[k][j]==word.charAt(c)){}
            else break;
        }
        
        if(k<10 && arr[k][j]=='-') return false;
        if(c==word.length()) return true;
        else return false;
    }

    public static void vFill(char[][] arr, int i, int j, String word){
        boolean prevEmpty;
        if(i==0) prevEmpty = true;
        else prevEmpty = arr[i-1][j]=='+';

        int k=i,c=0;
        if(!prevEmpty){
            c++;
        }
        for(;k<10 && c<word.length();k++,c++){
            arr[k][j] = word.charAt(c);
        }
    }

    public static void hFill(char[][] arr, int i, int j, String word){
        boolean prevEmpty;
        if(j==0) prevEmpty = true;
        else prevEmpty = arr[i][j-1]=='+';

        int k=j,c=0;
        if(!prevEmpty){
            c++;
        }
        for(;k<10 && c<word.length();k++,c++){
            arr[i][k] = word.charAt(c);
        }
    }

    public static void vClear(char[][] arr, int i, int j, String word){
        boolean prevEmpty;
        if(i==0) prevEmpty = true;
        else prevEmpty = arr[i-1][j]=='+';

        int k=i,c=0;
        if(!prevEmpty){
            c++;
        }
        for(;k<10 && c<word.length();k++,c++){
            arr[k][j] = '-';
        }
    }

    public static void hClear(char[][] arr, int i, int j, String word){
        boolean prevEmpty;
        if(j==0) prevEmpty = true;
        else prevEmpty = arr[i][j-1]=='+';

        int k=j,c=0;
        if(!prevEmpty){
            c++;
        }
        for(;k<10 && c<word.length();k++,c++){
            arr[i][k] = '-';
        }
    }
    


    public static int nextNeg(char[][] arr){
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                if(arr[i][j] == '-') return i*10+j;
            }
        }
        return -1;
    }

    public static boolean solve(char[][] arr, ArrayList<String> aList){
        int pos = nextNeg(arr);

        if(pos == -1){
            for(int i=0;i<10;i++){
                for(int j=0;j<10;j++){
                    System.out.print(arr[i][j]);
                }System.out.println("");
            }
            return true;
        }
        
        int i = pos/10;
        int j = pos%10;
        for(int k=0;k<aList.size();k++){
            String word = aList.get(k);
            if(hFillPossible(arr, i, j, word)){
                aList.remove(word);
                hFill(arr, i, j, word);
                boolean result = solve(arr, aList);
                if(result) return true;
                hClear(arr, i, j, word);
                aList.add(k,word);
            }

            if(vFillPossible(arr, i, j, word)){
                aList.remove(word);
                vFill(arr, i, j, word);
                boolean result = solve(arr, aList);
                if(result) return true;
                vClear(arr, i, j, word);
                aList.add(k,word);
            }

        }

        return false;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String[] board = new String[10];
        char[][] arr = new char[10][10];
        
        for(int i=0;i<10;i++){
            board[i] = scn.nextLine();
        }
        String wordLine = scn.nextLine();

        String[] words = wordLine.split(";");
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                arr[i][j] = board[i].charAt(j);
            }
        }

        ArrayList<String> aList = new ArrayList<>();
        for(int i=0;i<words.length;i++){
            aList.add(words[i]);
        }

        solve(arr, aList);

        //System.out.println(vFillPossible(arr, 0, 1, "CANADA"));
        //hClear(arr, 2, 2, "NIGERIA");

        // vFill(arr, 0, 1, "CANADA");
        // for(int i=0;i<10;i++){
        //     for(int j=0;j<10;j++){
        //         System.out.print(arr[i][j]);
        //     }System.out.println("");
        // }
    }

}