import java.util.Scanner;

class RectangleArea{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int ax1 = scn.nextInt();
        int ay1 = scn.nextInt();
        
        int ax2 = scn.nextInt();
        int ay2 = scn.nextInt();

        int bx1 = scn.nextInt();
        int by1 = scn.nextInt();
        
        int bx2 = scn.nextInt();
        int by2 = scn.nextInt();

        int area1 = (ax2-ax1)*(ay2-ay1);
        int area2 = (bx2-bx1)*(by2-by1);

        System.out.println(area1+" "+area2);
        
        
    }
}