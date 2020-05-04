package DynamicProgramming1;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class HasanTrip {
    public static double distance(int x1,int y1, int x2, int y2){
        int x = (x2-x1)*(x2-x1);
        int y = (y2-y1)*(y2-y1);
        double noRound = Math.sqrt(x+y);
        return noRound;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] inp = new int[n][3];
        //System.out.println(distance(0,0,3,4));

        for(int i=0;i<n;i++){
            for(int j=0;j<3;j++){
                inp[i][j] = scn.nextInt();
            }
        }

        double[] reff = new double[n+1];
        Arrays.fill(reff, -Double.MAX_VALUE);
        reff[0] = inp[0][2];

        for(int i=1;i<n;i++){
            for(int j=i-1;j>=0;j--){
                double dist = distance(inp[i][0], inp[i][1], inp[j][0], inp[j][1]);
                double temp = reff[j] + inp[i][2] - dist;
                if(temp>reff[i]){
                    reff[i] = temp;
                }
            }
        }

        double ans = reff[n-1];
        double round = Math.round(ans*1000000.0)/1000000.0;
        DecimalFormat df = new DecimalFormat("#.######");
        System.out.println(df.format(round));

        scn.close();
    }

}