package CodingNinjas.CodeChef;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution{
    public static void main(String[] args){
        int n=0,m=0;
        //ArrayList<Long> arr = new ArrayList<>();
        
        Queue<Long> queue= new LinkedList<>();
        Scanner scn = new Scanner(System.in);
        n = scn.nextInt();
        m = scn.nextInt();

        long[] arr = new long[n];
        for(int i=0;i<n;i++){
            //arr.add(scn.nextLong());
            arr[i] = scn.nextLong();
        }
        
        Arrays.sort(arr);
        //Collections.sort(arr);
        
        int lastIndex = n-1;
        
        int counter = 0;
        long lastElemRemoved = -1;

        for(int i=0;i<m;i++){
            int q = scn.nextInt();
            while(counter<q){
                if(queue.peek()!=null && lastIndex>=0){
                    long qq = queue.peek();
                    long aa = arr[lastIndex];

                    if(aa>qq){
                        lastElemRemoved =aa;
                        arr[lastIndex] = -1;
                        lastIndex--;
                        if(aa/2>0) queue.add(aa/2);
                    }
                    else{
                        
                        lastElemRemoved =qq;
                        queue.poll();
                        if(qq/2>0) queue.add(qq/2);
                    }
                }
                else if(queue.peek()!=null){
                    long qq = queue.poll();
                    lastElemRemoved = qq;
                    if(qq/2>0) queue.add(qq/2);
                }
                else if(lastIndex>=0){
                    long aa = arr[lastIndex];
                    arr[lastIndex] = -1;
                    lastElemRemoved = aa;
                    lastIndex--;
                    if(aa/2>0) queue.add(aa/2);
                }
                counter++;

            }
            System.out.println(""+lastElemRemoved);
        }
        

    }
}