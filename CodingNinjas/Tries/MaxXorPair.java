package CodingNinjas.Tries;

class TrieNode{
    int value;
    TrieNode left;
    TrieNode right;
}

public class MaxXorPair {
    public static void insertNode(TrieNode curr, int n){
        for(int i=31;i>=0;i--){
            int bit = n>>i&1;
            if(bit==0){
                if(curr.left==null){
                    curr.left = new TrieNode();
                }
                curr = curr.left;
            }
            else{
                if(curr.right==null){
                    curr.right = new TrieNode();
                }
                curr = curr.right;
            }
        }
    }

    public static int findMaxXor(TrieNode head, int[] arr){
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            TrieNode curr = head;
            int n = arr[i];
            int currMaxXor = 0;

            for(int j=31;j>=0;j--){
                int bit = n>>j&1;

                if(bit==0){
                    if(curr.right!=null){
                        curr = curr.right;
                        currMaxXor += Math.pow(2, j);
                    }
                    else{
                        curr = curr.left;
                    }
                }
                else{
                    if(curr.left!=null){
                        curr = curr.left;
                        currMaxXor += Math.pow(2, j);
                    }
                    else{
                        curr = curr.right;
                    }
                }
            }
            if(currMaxXor>ans) ans = currMaxXor;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {8, 1, 2, 10 , 5};
        TrieNode head = new TrieNode();
        for(int i=0;i<5;i++){
            insertNode(head, arr[i]);
        }
        System.out.println(findMaxXor(head, arr));
        
    }
    
}