/* package codechef; // don't place package name! */
package Prerequisites;

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
        Scanner scn = new Scanner(System.in);
        
        int[] p1 = new int[10000];
        int[] p2 = new int[10000];
        int[] ans = {0,0};

        int t = scn.nextInt();
        
        for(int i=0;i<t;i++){
            p1[i] = scn.nextInt();
            p2[i] = scn.nextInt();
        }
        if(p1[0]>p2[0]){
            ans[0] = p1[0]-p2[0];
        }
        else{
            ans[1] = p2[0]-p1[0];
        }
        for(int i=1;i<t;i++){
            p1[i]=p1[i]+p1[i-1];
            p2[i]=p2[i]+p2[i-1];

            if(p1[i]>p2[i] && p1[i]-p2[i]>ans[0]){
                ans[0]=p1[i]-p2[i];
            }
            else if(p2[i]>p1[i] && p2[i]-p1[i]>ans[1]){
                ans[1]=p2[i]-p1[i];
            }
        }
        if(ans[0]>ans[1]){
            System.out.println("1 "+ans[0]);
        }
        else{
            System.out.println("2 "+ans[1]);
        }
		// your code goes here
	}
}
