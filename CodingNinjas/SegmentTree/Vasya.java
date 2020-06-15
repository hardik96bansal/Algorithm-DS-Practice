package SegmentTree;

import java.util.Scanner;

class NodeMax{
    int maxNum;
    int index;

    public NodeMax(int maxNum, int index){
        this.maxNum = maxNum;
        this.index = index;
    }
}
public class Vasya {
    public static void buildTree(int[] arr, NodeMax[] tree, int start, int end, int treeNode, int[] minArr){
        if(start==end){
            tree[treeNode] = new NodeMax(arr[start], start);
            return;
        }
        int mid = (start+end)/2;
        buildTree(arr, tree, start, mid, 2*treeNode, minArr);
        buildTree(arr, tree, mid+1, end, 2*treeNode+1, minArr);
        NodeMax opt1 = tree[2*treeNode];
        NodeMax opt2 = tree[2*treeNode+1];
        if(opt1.maxNum>opt2.maxNum){
            tree[treeNode] = new NodeMax(opt1.maxNum, opt1.index);
        }
        else if(opt1.maxNum<opt2.maxNum){
            tree[treeNode] = new NodeMax(opt2.maxNum, opt2.index);
        }
        else{
            int m1 = minArr[opt1.index];
            int m2 = minArr[opt2.index];
            if(m1<=m2){
                tree[treeNode] = new NodeMax(opt1.maxNum, opt1.index);
            }
            else{
                tree[treeNode] = new NodeMax(opt2.maxNum, opt2.index);
            }
        }
    }

    public static NodeMax queryTree(NodeMax[] tree, int start, int end, int treeNode, int left, int right, int[] minArr){
        if(left>end || right<start){
            return new NodeMax(Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        if(left<=start && end <= right){
            return tree[treeNode];
        }

        int mid = (start+end)/2;
        NodeMax opt1 = queryTree(tree, start, mid, 2*treeNode, left, right, minArr);
        NodeMax opt2 = queryTree(tree, mid+1, end, 2*treeNode+1, left, right, minArr);

        if(opt1.maxNum>opt2.maxNum){
            return new NodeMax(opt1.maxNum, opt1.index);
        }
        else if(opt1.maxNum<opt2.maxNum){
            return new NodeMax(opt2.maxNum, opt2.index);
        }
        else{
            int m1 = minArr[opt1.index];
            int m2 = minArr[opt2.index];
            if(m1<=m2){
                return new NodeMax(opt1.maxNum, opt1.index);
            }
            else{
                return new NodeMax(opt2.maxNum, opt2.index);
            }
        }
        
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        int[] minArr = new int[n];
        NodeMax[] tree = new NodeMax[4*n];
        
        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }

        for(int i=0;i<n;i++){
            minArr[i] = scn.nextInt();
        }

        buildTree(arr, tree, 0, n-1, 1, minArr);

        int q = scn.nextInt();
        for(int i=0;i<q;i++){
            int left = scn.nextInt();
            int right = scn.nextInt();
            NodeMax ans = queryTree(tree, 0, n-1, 1, left-1, right-1, minArr);
            System.out.println(ans.index+1);
        }

        
    }
    
}