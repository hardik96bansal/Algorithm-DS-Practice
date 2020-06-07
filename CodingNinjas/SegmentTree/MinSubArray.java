package SegmentTree;

import java.util.Arrays;
import java.util.Scanner;

public class MinSubArray {
    public static void buildTree(int[] arr, int[] tree, int start, int end, int treeNode){
        if(start==end){
            tree[treeNode] = arr[start];
            return;
        }
        int mid = (start+end)/2;
        buildTree(arr, tree, start, mid, 2*treeNode);
        buildTree(arr, tree, mid+1, end, 2*treeNode+1);

        tree[treeNode] = Math.min(tree[2*treeNode] , tree[2*treeNode+1]);
    }

    public static void updateTree(int[] arr, int[] tree, int start, int end, int treeNode, int index, int value){
        if(start==end){
            arr[index] = value;
            tree[treeNode] = value;
            return;
        }
        int mid = (start+end)/2;
        if(index>mid){
            updateTree(arr, tree, mid+1, end, 2*treeNode+1, index, value);
        }
        else{
            updateTree(arr, tree, start, mid, 2*treeNode, index, value);
        }

        tree[treeNode] = Math.min(tree[2*treeNode], tree[2*treeNode+1]);
    }

    public static int queryTree(int[] arr, int[] tree, int start, int end, int treeNode, int left, int right){
        if(end<left || start>right){
            return Integer.MAX_VALUE;
        }
        if(left<=start && end<=right){
            return tree[treeNode];
        }

        int mid = (start+end)/2;
        int ans1 = queryTree(arr, tree, start, mid, 2*treeNode, left, right);
        int ans2 = queryTree(arr, tree, mid+1, end, 2*treeNode+1, left, right);
        return Math.min(ans1, ans2);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int q = scn.nextInt();

        int[] arr = new int[n];
        int[] tree = new int[4*n];
        Arrays.fill(tree, Integer.MAX_VALUE);

        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }
        buildTree(arr, tree, 0, n-1, 1);

        String waste = scn.nextLine();
        for(int i=0;i<q;i++){
            String line = scn.nextLine();
            String[] str = line.split(" ");
            if("q".equals(str[0])){
                int l = Integer.parseInt(str[1]);
                int r = Integer.parseInt(str[2]);
                System.out.println(queryTree(arr, tree, 0, n-1, 1, l-1, r-1));
            }

            if("u".equals(str[0])){
                int index = Integer.parseInt(str[1]);
                int value = Integer.parseInt(str[2]);
                updateTree(arr, tree, 0, n-1, 1, index-1, value);
            }
        }
    }    
}