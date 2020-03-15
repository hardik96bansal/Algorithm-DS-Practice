package Prerequisites;

import java.util.Scanner;

class RectangleArea{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int diff = 0;
        int x1 = scn.nextInt();
        int y1 = scn.nextInt();
        
        int x2 = scn.nextInt();
        int y2 = scn.nextInt();

        int x3 = scn.nextInt();
        int y3 = scn.nextInt();
        
        int x4 = scn.nextInt();
        int y4 = scn.nextInt();

        int area1 = (x2-x1)*(y2-y1);
        int area2 = (x4-x3)*(y4-y3);

        int leftInter = Math.max(x1,x3);
        int righInter = Math.min(x2, x4);

        int lowerInter = Math.max(y1, y3);
        int upperInter = Math.min(y2,y4);

        if(leftInter<righInter && lowerInter<upperInter){
            diff = (righInter-leftInter)*(upperInter-lowerInter);
        }
        int ans = area1+area2-diff;

        System.out.println(ans+" ");
        
        scn.close();
    }
}