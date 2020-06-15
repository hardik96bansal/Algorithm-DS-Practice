package SegmentTree;

import java.util.Arrays;
import java.util.Scanner;

public class HorribleQueries {
    public static void lazyUpdate(int[] tree, int start, int end, int left, int right, int treeNode, int value, int[] lazy){
        if(lazy[treeNode] != 0){
            tree[treeNode] += (end-start+1)*lazy[treeNode];
            if(start!=end){
                tree[2*treeNode] += lazy[treeNode];
                tree[2*treeNode+1] += lazy[treeNode];
            }
            lazy[treeNode] = 0;
        }
        
        if(left>end || right<start){
            return;
        }

        if(left<=start && end<=right){
            tree[treeNode] += (end-start+1)*value;
            if(start!=end){
                lazy[2*treeNode] += value;
                lazy[2*treeNode+1] += value;
            }
            return;
        }

        int mid = (start+end)/2;
        lazyUpdate(tree, start, mid, left, right, 2*treeNode, value, lazy);
        lazyUpdate(tree, mid+1, end, left, right, 2*treeNode+1, value, lazy);
        tree[treeNode] = tree[2*treeNode] + tree[2*treeNode+1];
    }

    public static int lazyQuery(int[] tree, int start, int end, int treeNode, int left, int right, int[] lazy){
        if(lazy[treeNode]!=0){
            tree[treeNode] += (end-start+1)*lazy[treeNode];
            if(start!=end){
                lazy[2*treeNode] += lazy[treeNode];
                lazy[2*treeNode+1] += lazy[treeNode];
            }
            lazy[treeNode] = 0;
        }

        if(left>end || right<start){
            return 0;
        }
        if(left<=start && end<=right){
            return tree[treeNode];
        }

        int mid = (start+end)/2;
        int ans1 = lazyQuery(tree, start, mid, 2*treeNode, left, right, lazy);
        int ans2 = lazyQuery(tree, mid+1, end, 2*treeNode+1, left, right, lazy);
        return ans1+ans2;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        
        while(t>0){
            int n = scn.nextInt();
            int q = scn.nextInt();

            int[] arr = new int[n];
            int[] tree = new int[4*n];
            int[] lazy = new int[4*n];

            Arrays.fill(arr, 0);
            Arrays.fill(tree, 0);
            Arrays.fill(lazy, 0);
            
            for(int i=0;i<q;i++){
                int type = scn.nextInt();
                int l = scn.nextInt();
                int r = scn.nextInt();
                if(type==0){
                    int value = scn.nextInt();
                    lazyUpdate(tree, 0, n-1, l-1, r-1, 1, value, lazy);
                    System.out.println("");
                }                
                else{
                    System.out.println(lazyQuery(tree, 0, n-1, 1, l-1, r-1, lazy));
                    System.out.println("");
                }
            }
            t--;
        }     
        
        scn.close();
    }
}