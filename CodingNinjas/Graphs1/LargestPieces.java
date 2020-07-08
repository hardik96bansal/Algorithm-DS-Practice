package CodingNinjas.Graphs1;

import java.util.Arrays;

public class LargestPieces {
    public static int dfs(String[][] graph, int currN, int currM, int n, int m, boolean[][] visited){
        int fromHere = 0;
        if(Integer.parseInt(graph[currN][currM])==1){
            fromHere++;
            if(currN>0 && !visited[currN-1][currM]){
                visited[currN-1][currM] = true;
                int ans = dfs(graph, currN-1, currM, n, m, visited) ;
                fromHere += ans;
            }
    
            if(currM<m-1 && !visited[currN][currM+1]){
                visited[currN][currM+1] = true;
                int ans = dfs(graph, currN, currM+1, n, m, visited);
                fromHere += ans;
            }
    
            if(currN<n-1 && !visited[currN+1][currM]){
                visited[currN+1][currM] = true;
                int ans = dfs(graph, currN+1, currM, n, m, visited);
                fromHere += ans;
            }
    
            if(currM>0 && !visited[currN][currM-1]){
                visited[currN][currM-1] = true;
                int ans = dfs(graph, currN, currM-1, n, m, visited); 
                fromHere += ans;
            }
            return fromHere;
        }
        
        return 0;
    }
    
    static int solve(int n, String[] cake){
        String[][] graph = new String[n][n];
        for(int i=0;i<n;i++){
            String line = cake[i];
            graph[i] = line.split("");
        }
        // for(String[] line:graph){
        //     for(String s:line){
        //         System.out.print(s+" ");
        //     }
        //     System.out.println("");
        // }

        int maxCount = 0;
        boolean[][] visited = new boolean[n][n];
        for(boolean[] ar: visited){
            Arrays.fill(ar, false);
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(Integer.parseInt(graph[i][j])==1 && !visited[i][j]){
                    visited[i][j] = true;
                    int ans = dfs(graph, i, j, n, n, visited);
                    if(ans>maxCount){
                        maxCount = ans;
                    }
                }
            }
        }

        //System.out.println(maxCount);
        return maxCount;
	}	

    public static void main(String[] args) {
        String[] aa = new String[4];
        aa[0] = "111";
        aa[1] = "011";
        aa[2] = "101";
        solve(3, aa);
    }
}