package Backtracking;

import java.util.Arrays;

public class RatInAMaze {
    public static boolean isValid(int[][] maze,int row, int col, int[][] visited){
        int n=maze.length;
        if(row<n&&row>=0 && col<n&&col>=0 && maze[row][col]!=0 && visited[row][col]!=1) return true;
        return false;
    }

    public static void ratInAMazeUtil(int[][] maze, int[][] sol, int row, int col, char prevMove, int[][] visited){
        int n = maze.length;
        if(row == n-1 && col ==n-1){
            for(int[] rows:sol){
                for(int a : rows){
                    System.out.print(a+" ");
                }
            }
            System.out.println("");
            return;
        }
        //move down
        if(isValid(maze, row+1, col, visited) && prevMove!='U'){
            sol[row+1][col] = 1;
            visited[row+1][col] = 1;
            ratInAMazeUtil(maze, sol, row+1, col,'D', visited);
            sol[row+1][col] = 0;
            visited[row+1][col] = 0;
        }
        //move right
        if(isValid(maze, row, col+1, visited) && prevMove!='L'){
            sol[row][col+1] = 1;
            visited[row][col+1] = 1;
            ratInAMazeUtil(maze, sol, row, col+1, 'R', visited);
            sol[row][col+1] = 0;
            visited[row][col+1] = 0;
        }

        //move up
        if(isValid(maze, row-1, col, visited) && prevMove!='D'){
            sol[row-1][col] = 1;
            visited[row-1][col] = 1;
            ratInAMazeUtil(maze, sol, row-1, col,'U', visited);
            sol[row-1][col] = 0;
            visited[row-1][col] = 0;
        }

        //move left
        if(isValid(maze, row, col-1, visited) && prevMove!='R'){
            sol[row][col-1] = 1;
            visited[row][col-1] = 1;
            ratInAMazeUtil(maze, sol, row, col-1, 'L', visited);
            sol[row][col-1] = 0;
            visited[row][col-1] = 0;
        }
    }
    public static void ratInAMaze(int maze[][]){
        int n = maze.length;
        int[][] sol = new int[n][n];
        for(int[] rows:sol){
            Arrays.fill(rows, 0);
        }
        sol[0][0] = 1;

        int[][] visited = new int[n][n];
        for(int[] rows:visited){
            Arrays.fill(rows, 0);
        }
        visited[0][0] = 1;
        
        ratInAMazeUtil(maze, sol, 0, 0, '1', visited);
    }

    public static void main(String[] args) {
        int[][] maze = {{1, 0, 1},
                        {1, 1, 1},
                        {1, 1, 1}};
        
        ratInAMaze(maze);

    }

}