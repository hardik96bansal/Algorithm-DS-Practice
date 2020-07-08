package CodingNinjas.Backtracking;

import java.util.Scanner;

public class Sudoku {

    public static boolean isValid(int[][] board, int row, int col, int num){
        int count = 0;

        for(int i=0;i<9;i++){
            if(board[row][i] == num) count++;
        }
        if(count >0) return false;
        
        count = 0;
        for(int i=0;i<9;i++){
            if(board[i][col] == num) count++;
        }
        if(count >0) return false;

        count = 0;
        int rowStart = row/3;
        rowStart = rowStart*3;
        int colStart = col/3;
        colStart = colStart*3;

        for(int i=rowStart;i<rowStart+3;i++){
            for(int j=colStart;j<colStart+3;j++){
                if(board[i][j]==num) count++;
            }
        }
        if(count>0) return false;
        
        return true;
    }

    public static int findEmpty(int[][] board){
        int n=board.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==0){
                    return i*10+j;
                }
            }
        }
        return -1;

    }

    public static boolean solveSudoku(int[][] board){
        int ret = findEmpty(board);
        if(ret ==-1) return true;

        int i=ret/10;
        int j=ret%10;

        for(int k=1;k<=9;k++){
            if(isValid(board, i, j, k)){
                board[i][j] = k;
                boolean result = solveSudoku(board);
                if(result) return true;
                board[i][j] = 0;
            }
        }
        return false;        
    }

    public static void main(String[] args) {

        int[][] board = new int[9][9];
        Scanner scn = new Scanner(System.in);

        int blank = 0;
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                board[i][j] = scn.nextInt();
                if(board[i][j]==0) blank++;
            }
        }

        boolean ans = solveSudoku(board);
        System.out.println(""+ans);
    }

}