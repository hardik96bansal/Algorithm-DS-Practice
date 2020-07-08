package CodingNinjas.DynamicProgramming2;

public class ShortestSub {

    public static int solver(String a, String b, int al, int bl, int at, int bt, int[][] arr){
        if(al==at+1 || bl==bt+1){
            return 0;
        }
        int opt1 = solver(a.substring(1), b, al+1, bl, at, bt, arr);
        char firstChar = a.charAt(0);
        int indInB = b.indexOf(firstChar);
        if(indInB == -1){
            return opt1;
        }
        String next = b.substring(b.indexOf(firstChar)+1);
        int opt2 = 1+ solver(a.substring(1), next, al+1, b.indexOf(next)+1,at, bt, arr);
        
        if(opt1!=0 && opt2!=0){
            return Math.min(opt1, opt2);
        }
        if(opt1!=0){
            return opt1;
        }
        return opt2;        
    }
    
    public static void main(String[] args) {
        //System.out.println("sdabcd".substring("sdabcd".indexOf("a")+1));
        //System.out.println("sdabcd".indexOf("bcd"));
        int[][] arr = new int[1][1];
        System.out.println(solver("bab", "aba", 1, 1, 3, 3, arr));
    }
}