package Graphs1;

import java.util.Arrays;

public class ConnectingDots {
    public static boolean dfs(String[][] graph, int currN, int currM, int n, int m, int sn, int sm, int chainCount, String chr,  boolean[][] visited){
        if(chainCount>=4 && currN==sn && currM==sm){
            return true;
        }
        boolean result = false;

        if(graph[currN][currM].equals(chr)){
            if(currN>0 && !visited[currN-1][currM]){
                visited[currN-1][currM] = true;
                result = dfs(graph, currN-1, currM, n, m, sn, sm, chainCount+1, chr, visited);
                if(result) return true;
                else visited[currN-1][currM] = false;
            }
    
            if(currM<m-1 && !visited[currN][currM+1]){
                visited[currN][currM+1] = true;
                result = dfs(graph, currN, currM+1, n, m, sn, sm, chainCount+1, chr, visited);
                if(result) return true;
                else visited[currN][currM+1] = false;
            }
    
            if(currN<n-1 && !visited[currN+1][currM]){
                visited[currN+1][currM] = true;
                result = dfs(graph, currN+1, currM, n, m, sn, sm, chainCount+1, chr, visited);
                if(result) return true;
                else visited[currN+1][currM] = false;
            }
    
            if(currM>0 && !visited[currN][currM-1]){
                visited[currN][currM-1] = true;
                result = dfs(graph, currN, currM-1, n, m, sn, sm, chainCount+1, chr, visited);
                if(result) return true;
                else visited[currN][currM-1] = false;
            }
        }

        return result;
    }



    static int solve(String[] board , int n, int m)
	{
        String[][] graph = new String[n][m];
        for(int i=0;i<n;i++){
            String line = board[i];
            graph[i] = line.split("");
        }
        for(String[] line:graph){
            for(String s:line){
                System.out.print(s+" ");
            }
            System.out.println("");
        }

        boolean result = false;

        for(int i=0;i<n&&!result;i++){
            for(int j=0;j<m&&!result;j++){
                
                boolean[][] visited = new boolean[n][m];
                for(boolean[] ar: visited){
                    Arrays.fill(ar, false);
                }
                result = dfs(graph, i, j, n, m, i, j, 1, graph[i][j], visited);                            
            }
        }
        System.out.println(result);
        if(result) return 1;
        return 0;
	}	

    public static void main(String[] args) {
        String[] aa = new String[3];
        aa[0] = "AAAAA";
        aa[1] = "BABCA";
        aa[2] = "BAAAA";
        solve(aa, 3, 5);
    }
    
}