package SegmentTree;

import java.util.Scanner;

public class OddEven {

    public static void buildTree(int[] arr, int[] tree, int start, int end, int treeNode){
        if(start==end){
            tree[treeNode] = arr[start]%2;
            return;
        }
        int mid = (start+end)/2;
        buildTree(arr, tree, start, mid, 2*treeNode);
        buildTree(arr, tree, mid+1, end, 2*treeNode+1);
        tree[treeNode] = tree[2*treeNode] + tree[2*treeNode+1];
    }

    public static void updateTree(int[] arr, int[] tree, int start, int end, int treeNode, int index, int value){
        if(start==end){
            arr[start] = value;
            tree[treeNode] = value%2;
            return;
        }
        int mid = (start+end)/2;
        if(index > mid){
            updateTree(arr, tree, mid+1, end, 2*treeNode+1, index, value);
        }
        else{
            updateTree(arr, tree, start, mid, 2*treeNode, index, value);
        }
        tree[treeNode] = tree[2*treeNode] + tree[2*treeNode+1];
    }

    public static int queryTree(int[] tree, int start, int end, int treeNode, int left, int right){
        if(left>end || right<start){
            return 0;
        }
        if(left<=start && end<=right){
            return tree[treeNode];
        }

        int mid = (start+end)/2;
        int ans1 = queryTree(tree, start, mid, 2*treeNode, left, right);
        int ans2 = queryTree(tree, mid+1, end, 2*treeNode+1, left, right);
        return ans1+ans2;
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        int[] tree = new int[4*n];

        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }

        int q = scn.nextInt();
        buildTree(arr, tree, 0, n-1, 1);

        for(int i=0;i<q;i++){
            int a = scn.nextInt();
            int b = scn.nextInt();
            int c = scn.nextInt();

            if(a==0){
                updateTree(arr, tree, 0, n-1, 1, b-1, c);
            }
            if(a==1){
                System.out.println((c-b+1 - queryTree(tree, 0, n-1, 1, b-1, c-1)));                
            }
            if(a==2){
                System.out.println(queryTree(tree, 0, n-1, 1, b-1, c-1));
            }
        }
    }
}