package AdvancedGraphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ConnectedHorses {
    public static int productModulo(int a, int b){
        int bigNum = 1000000007;
        return (a%bigNum * b%bigNum)%bigNum;
    }

    public static int addModulo(int a, int b){
        int bigNum = 1000000007;
        return (a%bigNum + b%bigNum)%bigNum;
    }

    public static int factorial(int n){
        if(n==1){
            return 1;
        }
        return productModulo(n, factorial(n-1));
    }


    public static int traverse(int currN, int currM, int n, int m, int[][] board, boolean[][] visited){
        int ans = 0;

        if(currN-2>0&&currM+1<=m && board[currN-2][currM+1]==1 && !visited[currN-2][currM+1]){
            visited[currN-2][currM+1] = true;
            int temp  =  traverse(currN-2, currM+1, n, m, board, visited);
            ans = addModulo(ans, 1);
            ans = addModulo(ans, temp);
        }
        if(currN-1>0&&currM+2<=m && board[currN-1][currM+2]==1 && !visited[currN-1][currM+2]){
            visited[currN-1][currM+2] = true;
            int temp  =  traverse(currN-1, currM+2, n, m, board, visited);
            ans = addModulo(ans, 1);
            ans = addModulo(ans, temp);
        }

        if(currN+1<=n&&currM+2<=m && board[currN+1][currM+2]==1 && !visited[currN+1][currM+2]){
            visited[currN+1][currM+2] = true;
            int temp  =  traverse(currN+1, currM+2, n, m, board, visited);
            ans = addModulo(ans, 1);
            ans = addModulo(ans, temp);
        }
        if(currN+2<=n&&currM+1<=m && board[currN+2][currM+1]==1 && !visited[currN+2][currM+1]){
            visited[currN+2][currM+1] = true;
            int temp  =  traverse(currN+2, currM+1, n, m, board, visited);
            ans = addModulo(ans, 1);
            ans = addModulo(ans, temp);
        }

        if(currN+2<=n&&currM-1>0 && board[currN+2][currM-1]==1 && !visited[currN+2][currM-1]){
            visited[currN+2][currM-1] = true;
            int temp  =  traverse(currN+2, currM-1, n, m, board, visited);
            ans = addModulo(ans, 1);
            ans = addModulo(ans, temp);
        }
        if(currN+1<=n&&currM-2>0 && board[currN+1][currM-2]==1 && !visited[currN+1][currM-2]){
            visited[currN+1][currM-2] = true;
            int temp  =  traverse(currN+1, currM-2, n, m, board, visited);
            ans = addModulo(ans, 1);
            ans = addModulo(ans, temp);
        }

        if(currN-1>0&&currM-2>0 && board[currN-1][currM-2]==1 && !visited[currN-1][currM-2]){
            visited[currN-1][currM-2] = true;
            int temp  =  traverse(currN-1, currM-2, n, m, board, visited);
            ans = addModulo(ans, 1);
            ans = addModulo(ans, temp);
        }
        if(currN-2>0&&currM-1>0 && board[currN-2][currM-1]==1 && !visited[currN-2][currM-1]){
            visited[currN-2][currM-1] = true;
            int temp  =  traverse(currN-2, currM-1, n, m, board, visited);
            ans = addModulo(ans, 1);
            ans = addModulo(ans, temp);
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();

        while(t>0){
            int n = scn.nextInt();
            int m = scn.nextInt();
            int q = scn.nextInt();

            int[][] board = new int[n+1][m+1];
            for(int i=0;i<q;i++){
                int x = scn.nextInt();
                int y = scn.nextInt();
                board[x][y] = 1;
            }
            boolean[][] visited = new boolean[n+1][m+1];
            for(boolean[] ar: visited){
                Arrays.fill(ar, false);
            }

            ArrayList<Integer> components = new ArrayList<>();
            for(int i=0;i<=n;i++){
                for(int j=0;j<=m;j++){
                    if(board[i][j]==1 && !visited[i][j]){
                        visited[i][j] = true;
                        int count = 1 + traverse(i, j, n, m, board, visited);
                        components.add(count);
                    }
                }
            }
            int ans = 1;
            for(int a: components){
                int fact = factorial(a);
                ans = productModulo(ans, fact);
            } 
            System.out.println(ans);
            t--;
        }
    }
    
}