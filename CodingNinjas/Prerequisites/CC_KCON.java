/* package codechef; // don't place package name! */
package Prerequisites;

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef1
{
	public static long kadanesSum(long[] arr){
		long maxSoFar = 0;
		long currSum = 0;

		for(int i=0;i<arr.length;i++){
			long currElem = arr[i];
			currSum = currSum + currElem;
			if(currSum<0) currSum = 0;
			maxSoFar = Math.max(currSum, maxSoFar);
		}

		return maxSoFar;
	}

	public static long maxPrefixSum(long[] arr){
		long maxPrefixSum = 0;
		long currSum = 0;

		for(int i=0;i<arr.length;i++){
			long currElem = arr[i];
			currSum = currSum + currElem;
			maxPrefixSum = Math.max(currSum, maxPrefixSum);
		}

		return maxPrefixSum;
	}

	public static long maxSuffixSum(long[] arr){
		long maxSuffixSum = 0;
		long currSum = 0;

		for(int i=arr.length-1;i>=0;i--){
			long currElem = arr[i];
			currSum = currSum + currElem;
			maxSuffixSum = Math.max(currSum, maxSuffixSum);
		}

		return maxSuffixSum;
	}
	public static void main (String[] args) throws java.lang.Exception
	{
        // your code goes here
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        for(int i=0;i<t;i++){
			long temp =0;
            int l = scn.nextInt();
            int k = scn.nextInt();

            long arr[] = new long[100005];

            long sum = 0;
            for(int j=0;j<l;j++){
                arr[j] = scn.nextInt();
                sum = sum+arr[j];
			}

			long ks = kadanesSum(arr);
			if(k==1){
				System.out.println(""+ks);
			}
			else{
				long mps = maxPrefixSum(arr);
				long mss = maxSuffixSum(arr);
	
				temp = mss+mps;
				if(sum>=0) temp = temp+(k-2)*sum;
				
				System.out.println(""+Math.max(temp, ks));
			}
        }
	}
}
