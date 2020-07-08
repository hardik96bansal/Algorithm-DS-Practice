package CodingNinjas.Backtracking;

import java.util.Arrays;

class NQueens{

    public static boolean isValid(int[][] board,int n, int row, int col){
        boolean ans = true;

        int count = 0;
        for(int i=0;i<n;i++){
            if(board[row][i]==1) count++;            
        }
        if(count>1) return false;

        count = 0;
        for(int i=0;i<n;i++){
            if(board[i][col]==1) count++;            
        }
        if(count>1) return false;
        
        //down right
        count = 0;
        for(int i=row, j=col;i<n&&j<n;i++,j++){
            if(board[i][j]==1) count++;
        }
        if(count>1) return false;

        //up right
        count = 0;
        for(int i=row, j=col;i>=0&&j<n;i--,j++){
            if(board[i][j]==1) count++;
        }
        if(count>1) return false;

        //down left
        count = 0;
        for(int i=row, j=col;i<n&&j>=0;i++,j--){
            if(board[i][j]==1) count++;
        }
        if(count>1) return false;

        //up left
        //down right
        count = 0;
        for(int i=row, j=col;i>=0&&j>=0;i--,j--){
            if(board[i][j]==1) count++;
        }
        if(count>1) return false;

        return ans;        
    }

    public static void placeNQueensUtil(int[][] board, int n, int row){
        if(row==n){
            for(int[] rows:board){
                for(int a:rows){
                    System.out.print(a+" ");
                }                
            }
            System.out.println("");
            return;
        }
        for(int i=0;i<n;i++){
            board[row][i] = 1;
            if(isValid(board,n,row,i)){
                placeNQueensUtil(board, n, row+1);
            }
            board[row][i] = 0;
        }

    }

    public static void placeNQueens(int n){
        int[][] board = new int[n][n];
        for(int[] arr:board){
            Arrays.fill(arr,0);
        }
        placeNQueensUtil(board, n, 0);
    }

    public static void main(String[] args) {
        int[][] arr ={{ 0, 0, 0, 0},
                      { 0, 0, 0, 1},
                      { 0, 1, 0, 0},
                      { 0, 0, 1, 0}};
        //System.out.println(""+isValid(arr, 4,2,1));
        placeNQueens(4);
        
    }
}