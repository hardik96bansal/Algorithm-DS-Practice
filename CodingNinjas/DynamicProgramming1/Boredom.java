package DynamicProgramming1;

import java.util.Arrays;
import java.util.Scanner;

class solution {
    public int solve(int n,int A[])
	{
        if(n==1) return A[0];
        int[] arr = Arrays.copyOf(A, n);
        
        Arrays.sort(arr);
        int[] reff = new int[n];
        Arrays.fill(reff, 0);
        reff[0] = arr[0];

        for(int i=1;i<n;i++){
            reff[i] = arr[i];
            for(int j=i-1;j>=0;j--){
                if(arr[j]==arr[i]-1){
                    continue;
                }
                if(arr[i]+reff[j]>reff[i]){
                    reff[i] = arr[i] + reff[j];
                }
            }
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            if(reff[i]>ans){
                ans = reff[i];
            }
        }

        return ans;
	}
}

class Boredom{
    public static int[] A=new int [100005];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		for(int i=0;i<n;i++)
		{
			A[i]=scan.nextInt();
        }
        int[] arr = {1,2};
		System.out.println(new solution().solve(n,A));
	}
}