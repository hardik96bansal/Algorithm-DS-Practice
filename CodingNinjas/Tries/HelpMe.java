package CodingNinjas.Tries;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

class ListTrie {
    TreeSet<String> list;
    ListTrie[] arr;

    ListTrie() {
        list = new TreeSet<>();
        arr = new ListTrie[27];
    }
}

public class HelpMe {
    public static void insert(ListTrie head, String word) {
        for (int i = 0; i < word.length(); i++) {
            head.list.add(word);
            int bit = (int) word.charAt(i) - 96;
            if (head.arr[bit] != null) {
                head = head.arr[bit];
                head.list.add(word);
            } else {
                head.arr[bit] = new ListTrie();
                head = head.arr[bit];
                head.list.add(word);
            }
        }
    }

    public static TreeSet<String> query(ListTrie head, String word) {
        ListTrie curr = head;
        for (int i = 0; i < word.length(); i++) {
            int bit = (int) word.charAt(i) - 96;
            if (curr.arr[bit] == null) {
                insert(head, word);
                return null;
            }
            curr = curr.arr[bit];
        }
        return curr.list;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        ListTrie head = new ListTrie();
        int n = scn.nextInt();
        for (int i = 0; i < n; i++) {
            String word = scn.next();
            insert(head, word);
        }

        int q = scn.nextInt();
        for (int i = 0; i < q; i++) {
            String word = scn.next();
            TreeSet<String> set = query(head, word);
            if (set == null) {
                System.out.println("No Suggestions");
            } else {
                Iterator<String> iter = set.iterator();
                while(iter.hasNext()){
                    System.out.println(iter.next());
                }
            }
        }
    }
}