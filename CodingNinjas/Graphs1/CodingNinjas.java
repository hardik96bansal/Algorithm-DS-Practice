package CodingNinjas.Graphs1;

import java.util.Arrays;

public class CodingNinjas {
    public static boolean dfs(String[][] graph, int currN, int currM, String rem, int n, int m, boolean[][] visited){
        if(rem.length()==1 && rem.equals(graph[currN][currM])){
            return true;
        }
        boolean result = false;
        if(rem.charAt(0)==graph[currN][currM].charAt(0)){
            rem = rem.substring(1);

            if(currN>0 && !visited[currN-1][currM]){
                visited[currN-1][currM] = true;
                result = dfs(graph, currN-1, currM, rem, n, m, visited);
                if(result) return true;
                else visited[currN-1][currM] = false;
            }
    
            if(currM<m-1 && !visited[currN][currM+1]){
                visited[currN][currM+1] = true;
                result = dfs(graph, currN, currM+1, rem, n, m, visited);
                if(result) return true;
                else visited[currN][currM+1] = false;
            }
    
            if(currN<n-1 && !visited[currN+1][currM]){
                visited[currN+1][currM] = true;
                result = dfs(graph, currN+1, currM, rem, n, m, visited);
                if(result) return true;
                else visited[currN+1][currM] = false;
            }
    
            if(currM>0 && !visited[currN][currM-1]){
                visited[currN][currM-1] = true;
                result = dfs(graph, currN, currM-1, rem, n, m, visited);
                if(result) return true;
                else visited[currN][currM-1] = false;
            }
    
            if(currN>0 && currM<m-1 && !visited[currN-1][currM+1]){
                visited[currN-1][currM+1] = true;
                result = dfs(graph, currN-1, currM+1, rem, n, m, visited);
                if(result) return true;
                else visited[currN-1][currM+1] = false;
            }
    
            if(currN<n-1 && currM<m-1 && !visited[currN+1][currM+1]){
                visited[currN+1][currM+1] = true;
                result = dfs(graph, currN+1, currM+1, rem, n, m, visited);
                if(result) return true;
                else visited[currN+1][currM+1] = false;
            }
    
            if(currN<n-1 && currM>0 && !visited[currN+1][currM-1]){
                visited[currN+1][currM-1] = true;
                result = dfs(graph, currN+1, currM-1, rem, n, m, visited);
                if(result) return true;
                else visited[currN+1][currM-1] = false;
            }
    
            if(currN>0 && currM>0 && !visited[currN-1][currM-1]){
                visited[currN-1][currM-1] = true;
                result = dfs(graph, currN-1, currM-1, rem, n, m, visited);
                if(result) return true;
                else visited[currN-1][currM-1] = false;
            }
        }        
        

        return result;
    }

    static int solve(String[] Graph , int n, int m)
	{
        String[][] graph = new String[n][m];
        for(int i=0;i<n;i++){
            String line = Graph[i];
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
                if(graph[i][j].equals("C")){
                    boolean[][] visited = new boolean[n][m];
                    for(boolean[] ar: visited){
                        Arrays.fill(ar, false);
                    }
                    result = dfs(graph, i, j, "CODINGNINJA", n, m, visited);
                }                
            }
        }
        System.out.println(result);
        if(result) return 1;
        return 0;
	}	

    public static void main(String[] args) {
        String[] aa = new String[4];
        aa[0] = "CANI";
        aa[1] = "OOJN";
        aa[2] = "DDIG";
        aa[3] = "JNIN";
        solve(aa, 4, 4);
    }
    
}