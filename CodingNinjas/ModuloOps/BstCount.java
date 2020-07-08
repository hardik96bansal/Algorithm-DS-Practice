package CodingNinjas.ModuloOps;

import java.util.Arrays;

public class BstCount {
    static int prodModulo(long a, long b)  
    { 
        long mod = 1000000007;
        long res = 0; // Initialize result  
        a = a % mod; 
        while (b > 0) 
        { 
            // If b is odd, add 'a' to result  
            if (b % 2 == 1)  
            { 
                res = (res + a) % mod; 
            } 
  
            // Multiply 'a' with 2  
            a = (a * 2) % mod; 
  
            // Divide b by 2  
            b /= 2; 
        } 
  
        // Return result  
        return (int)(res % mod); 
    } 

    public static int addModulo(int x,int y){
        int boss = 1000000007;
        return ((x%boss)+(y%boss))%boss;
    }

    public static int balancedTreesOfHeightHUtil(int height, int arr[]){
		if(height==1||height==0){
            return 1;
        }

        if(arr[height]!=-1){
            return arr[height];
        }

        int x = balancedTreesOfHeightHUtil(height-1,arr);
        int y = balancedTreesOfHeightHUtil(height-2,arr);
        int x2 = prodModulo(x,x);
        int xy = prodModulo(x,y);
        int twoxy = addModulo(xy,xy);
        int ans = addModulo(x2,twoxy);

        arr[height] = ans;
        return ans;
    }
    
    public static int balancedTreesOfHeightH(int height){
        int[] reff = new int[50];

        Arrays.fill(reff, -1);
        return balancedTreesOfHeightHUtil(height, reff);

    }

    public static void main(String[] args) {
        
        System.out.println(balancedTreesOfHeightH(6));
        
    }

}