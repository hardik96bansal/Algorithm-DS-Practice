package CodingNinjas.Tries;

import java.util.Scanner;

public class MaxXorSubArr {

    public static void insert(TrieNode head, int num){
        for(int i=31;i>=0;i--){
            int bit = num>>i&1;

            if(bit==0){
                if(head.left==null){
                    head.left = new TrieNode();
                }
                head = head.left;
            }
            else{
                if(head.right == null){
                    head.right = new TrieNode();
                }
                head = head.right;
            }
        }
        head.value = num;
    }

    public static int query(TrieNode head, int num){
        for(int i=31;i>=0;i--){
            int bit = num>>i&1;
            if(bit == 0){
                if(head.right != null){
                    head = head.right;
                }
                else{
                    head = head.left;
                }
            }
            else{
                if(head.left != null){
                    head = head.left;
                }
                else{
                    head = head.right;
                }
            }
        }

        return head.value ^ num;
    }


    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }

        int ans = Integer.MIN_VALUE;
        int xor = 0;
        TrieNode head = new TrieNode();
        insert(head, 0);

        for(int i=0;i<n;i++){
            xor = xor^arr[i];
            insert(head, xor);

            int result = query(head, xor);
            ans = Math.max(ans, result);
        }

        System.out.println(ans);
    }
}