package SegmentTree;

import java.util.Scanner;

public class TwoVsThree1 {
    public static int addModulo(int a, int b){
        return (a%3+b%3)%3;
    }

    public static int productModulo(int a, int b){
        return (a%3*b%3)%3;
    }

    public static void buildTree(String[] arr, int[] tree, int start, int end, int treeNode, int[] pow2){
        if(start==end){
            tree[treeNode] = Integer.parseInt(arr[start]);
            return;
        }

        int mid = (start+end)/2;
        buildTree(arr, tree, start, mid, 2*treeNode,pow2);
        buildTree(arr, tree, mid+1, end, 2*treeNode+1,pow2);

        int prodMod = productModulo(pow2[end-mid], tree[2*treeNode]);
        int addMod = addModulo(prodMod, tree[2*treeNode+1]);
        tree[treeNode] = addMod;       
    }

    public static void updateTree(String[] arr, int[] tree, int start, int end, int treeNode, int[] pow2, int index){
        if(start==end){
            tree[treeNode] = 1;
            return;
        }

        int mid = (start+end)/2;
        if(index>mid){
            updateTree(arr, tree, mid+1, end, 2*treeNode+1, pow2, index);
        }
        else{
            updateTree(arr, tree, start, mid, 2*treeNode, pow2, index);
        }
        int prodMod = productModulo(pow2[end-mid], tree[2*treeNode]);
        int addMod = addModulo(prodMod, tree[2*treeNode+1]);
        tree[treeNode] = addMod;   
    }

    public static int queryTree(int[] tree, int start, int end, int treeNode, int left, int right, int[] pow2){
        if(left>end || right<start){
            return 0;
        }
        if(left<=start && end<=right){
            return tree[treeNode];
        }
        
        int mid = (start+end)/2;
        int ans1 = queryTree(tree, start, mid, 2*treeNode, left, right, pow2);
        int ans2 = queryTree(tree, mid+1, end, 2*treeNode+1, left, right, pow2);
        int prodMod = productModulo(pow2[right-mid], ans1);
        int addMod = addModulo(prodMod, ans2);
        return addMod;   
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        String waste = scn.nextLine();
        String num = scn.nextLine();
        String[] arr = new String[n];
        int[] tree = new int[4*n];
        
        int[] pow2 = new int[n+5];
        pow2[0] = 1;

        arr = num.split("");

        for(int i=1;i<=n;i++){
            pow2[i] = productModulo(pow2[i-1], 2);
        }

        buildTree(arr, tree, 0, n-1, 1, pow2);

        int q = scn.nextInt();
        for(int i=0;i<q;i++){
            int type = scn.nextInt();
            if(type==0){
                int l = scn.nextInt();
                int r = scn.nextInt();
                int result = queryTree(tree, 0, n-1, 1, l, r, pow2);        
                System.out.println(result);
            }
            else{
                int l = scn.nextInt();
                if(arr[l].equals("0")){
                    updateTree(arr, tree, 0, n-1, 1, pow2, l);
                }
            }
        }
        
    }
    
}