package SegmentTree;

import java.util.*;

class Node{
    int max;
    int secondMax;

    public Node(int max, int secondMax) {
        this.max = max;
        this.secondMax = secondMax;
    }
}
public class MaxPairSubarray {
    public static void buildTree(int[] arr, Node[] tree, int start, int end, int treeNode){
        if(end==start){
            tree[treeNode] = new Node(arr[start], Integer.MIN_VALUE);
            return;
        }
        int mid = (start+end)/2;
        buildTree(arr, tree, start, mid, 2*treeNode);
        buildTree(arr, tree, mid+1, end, 2*treeNode+1);

        int[] temp = new int[4];
        temp[0] = tree[2*treeNode].max;
        temp[1] = tree[2*treeNode].secondMax;
        temp[2] = tree[2*treeNode+1].max;
        temp[3] = tree[2*treeNode+1].secondMax;

        Arrays.sort(temp);
        tree[treeNode] = new Node(temp[3], temp[2]);        
    }

    public static void updateTree(int[] arr, Node[] tree, int start, int end, int treeNode, int index, int value){
        if(end==start){
            tree[treeNode] = new Node(value , Integer.MIN_VALUE);
            arr[index] = value;
            return;
        }

        int mid = (start+end)/2;
        if(mid<index){
            updateTree(arr, tree, mid+1, end, 2*treeNode+1, index, value);
        }
        else{
            updateTree(arr, tree, start, mid, 2*treeNode, index, value);
        }

        int[] temp = new int[4];
        temp[0] = tree[2*treeNode].max;
        temp[1] = tree[2*treeNode].secondMax;
        temp[2] = tree[2*treeNode+1].max;
        temp[3] = tree[2*treeNode+1].secondMax;

        Arrays.sort(temp);
        tree[treeNode] = new Node(temp[3], temp[2]);
    }

    public static Node queryTree(Node[] tree, int start, int end, int treeNode, int left, int right){
        if(right<start || left > end){
            return new Node(Integer.MIN_VALUE, Integer.MIN_VALUE);
        }

        if(left<=start && right>=end){
            return tree[treeNode];
        }

        int mid = (start+end)/2;
        Node opt1 = queryTree(tree, start, mid, 2*treeNode, left, right);
        Node opt2 = queryTree(tree, mid+1, end, 2*treeNode+1, left, right);

        int[] temp = new int[4];
        if(opt1!=null){
            temp[0] = opt1.max;
            temp[1] = opt1.secondMax;
        }
        if(opt2!=null){
            temp[2] = opt2.max;
            temp[3] = opt2.secondMax;
        }  

        Arrays.sort(temp);
        return new Node(temp[3], temp[2]);     
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr= new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }

        Node[] tree = new Node[4*n];
        buildTree(arr, tree, 0, n-1, 1);

        int q = scn.nextInt();
        String waste = scn.nextLine();

        for(int i=0;i<q;i++){
            String input = scn.nextLine();
            String[] inpArr = input.split(" ");
            if(inpArr[0].equals("Q")){
                int left = Integer.parseInt(inpArr[1]);
                int right = Integer.parseInt(inpArr[2]);
                Node result = queryTree(tree, 0, n-1, 1, left-1, right-1);
                System.out.println(""+(result.max+result.secondMax));
            }
            else{
                int index = Integer.parseInt(inpArr[1]);
                int value = Integer.parseInt(inpArr[2]);
                updateTree(arr, tree, 0, n-1, 1, index-1, value);
            }
        }
        scn.close();
    }
    
}