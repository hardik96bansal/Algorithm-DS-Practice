package CodingNinjas.Tries;

import java.util.Scanner;

class WordTrie{
    WordTrie[] arr;
    int weight;

    WordTrie(){
        this.arr = new WordTrie[27];
    }
}

public class SearchEngine {
    public static void insert(WordTrie head, String word, int weight){
        for(int i=0;i<word.length();i++){
            int bit = (int)word.charAt(i) - 96;
            if(head.arr[bit]!=null){
                if(weight>head.weight) head.weight = weight;
                head = head.arr[bit];
            }
            else{
                head.arr[bit] = new WordTrie();
                if(weight>head.weight) head.weight = weight;
                head = head.arr[bit];
            }
        }
    }

    public static int query(WordTrie head, String word){
        for(int i=0;i<word.length();i++){
            int bit = (int) word.charAt(i) - 96;
            if(head.arr[bit]==null) return -1;
            head = head.arr[bit];
        }
        return head.weight;
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int w = scn.nextInt();
        int q = scn.nextInt();
        WordTrie head = new WordTrie();

        for(int i=0;i<w;i++){
            String line = scn.next();
            String[] wordArr = line.split(" ");
            String word = wordArr[0];
            int number = scn.nextInt();

            insert(head, word, number);
        }

        for(int i=0;i<q;i++){
            String word = scn.next();
            System.out.println(query(head, word));
        }
    }
}