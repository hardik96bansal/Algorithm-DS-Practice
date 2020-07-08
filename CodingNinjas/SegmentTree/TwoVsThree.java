package CodingNinjas.SegmentTree;

import java.util.Scanner;

public class TwoVsThree {
    public static void buildTree(String[] arr, String[] tree, int start, int end, int treeNode){
        if(start==end){
            tree[treeNode] = arr[start];
            return;
        }
        int mid = (start+end)/2;
        buildTree(arr, tree, start, mid, 2*treeNode);
        buildTree(arr, tree, mid+1, end, 2*treeNode+1);
        tree[treeNode] = tree[2*treeNode] + tree[2*treeNode+1];
    }
    public static void updateTree(String[] arr, String[] tree, int start, int end, int treeNode, int index, String value){
        if(start==end){
            arr[start] = value;
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
        tree[treeNode] = tree[2*treeNode] + tree[2*treeNode+1];
    }

    public static String queryTree(String[] tree, int start ,int end, int treeNode, int left, int right){
        if(left>end || right<start){
            return "";
        }
        if(left<=start && end<=right){
            return tree[treeNode];
        }
        
        int mid = (start+end)/2;
        String ans1 = queryTree(tree, start, mid, 2*treeNode, left, right);
        String ans2 = queryTree(tree, mid+1, end, 2*treeNode+1, left, right);
        return ans1+ans2;
    }



    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        String waste = scn.nextLine();
        String num = scn.nextLine();
        String[] arr = new String[n];
        String[] tree = new String[4*n];
        int cnt = n-1;
        
        arr = num.split("");
        buildTree(arr, tree, 0, n-1, 1);

        int q = scn.nextInt();
        for(int i=0;i<q;i++){
            int type = scn.nextInt();
            if(type==0){
                int l = scn.nextInt();
                int r = scn.nextInt();
                String result = queryTree(tree, 0, n-1, 1, l, r);        
                if(result!=null && !"".equals(result)){
                    int conv = Integer.parseInt(result,2);
                    System.out.println(conv%3);
                }
            }
            else{
                int l = scn.nextInt();
                if(arr[l].equals("0")){
                    updateTree(arr, tree, 0, n-1, 1, l, "1");            
                }
            }
        }
    }
}