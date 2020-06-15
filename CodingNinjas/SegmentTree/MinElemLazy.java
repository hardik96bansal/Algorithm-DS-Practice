package SegmentTree;

import java.util.Arrays;

public class MinElemLazy {

    public static void buildTree(int[] arr, int[] tree, int start, int end, int treeNode){
        if(start==end){
            tree[treeNode] = arr[start];
            return;
        }

        int mid = (start+end)/2;
        buildTree(arr, tree, start, mid, 2*treeNode);
        buildTree(arr, tree, mid+1, end, 2*treeNode+1);
        tree[treeNode] = Math.min(tree[2*treeNode], tree[2*treeNode+1]);
    }

    public static void lazyUpdate(int[] tree, int[] lazy, int start, int end, int left, int right, int treeNode, int value){
        if(lazy[treeNode]!=0){
            tree[treeNode] += lazy[treeNode];
            if(start!=end){
                lazy[2*treeNode] += lazy[treeNode];
                lazy[2*treeNode+1] += lazy[treeNode];
            }
            lazy[treeNode] = 0;
        }

        if(end<left || start>right){
            return;
        }

        if(left<=start && end<=right){
            tree[treeNode] +=  value;
            if(start!=end){
                lazy[2*treeNode] += value;
                lazy[2*treeNode+1] += value;
            }
            return;
        }

        int mid = (start+end)/2;
        lazyUpdate(tree, lazy, start, mid, left, right, 2*treeNode, value);
        lazyUpdate(tree, lazy, mid+1, end, left, right, 2*treeNode+1, value);
        tree[treeNode] = Math.min(tree[2*treeNode], tree[2*treeNode+1]);
    }

    public static int lazyQuery(int[] tree, int[] lazy, int start, int end, int left, int right, int treeNode){
        if(lazy[treeNode]!=0){
            tree[treeNode] += lazy[treeNode];
            if(start!=end){
                lazy[2*treeNode] += lazy[treeNode];
                lazy[2*treeNode+1] += lazy[treeNode];
            }
            lazy[treeNode] = 0;
        }

        if(right<start || end<left){
            return Integer.MAX_VALUE;
        }

        if(left<=start && end<=right){
            return tree[treeNode];
        }

        int mid = (start+end)/2;
        int opt1 = lazyQuery(tree, lazy, start, mid, left, right, 2*treeNode);
        int opt2 = lazyQuery(tree, lazy, mid+1, end, left, right, 2*treeNode+1);
        return Math.min(opt1, opt2);       
    }
    public static void main(String[] args) {
        int[] arr = {1,2,-3,0,3};
        int[] tree = new int[20];
        int[] lazy = new int[20];
        Arrays.fill(lazy, 0);
        buildTree(arr, tree, 0, 4, 1);
        lazyUpdate(tree, lazy, 0, 4, 0, 2, 1, 1);
        System.out.println(lazyQuery(tree, lazy, 0, 4, 2, 4, 1));
        for(int a: tree){
            System.out.print(a+" ");
        }
        System.out.println("\n");
        for(int a: lazy){
            System.out.print(a+" ");
        }
        
    }
    
}