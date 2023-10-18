package StrukturiertJava.Apps.console;

import java.util.Scanner;

public class MinMaxSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print(": ");

        int x1 = sc.nextInt();
        int x2 = sc.nextInt();
        int x3 = sc.nextInt();
        int x4 = sc.nextInt();
        int x5 = sc.nextInt();
        //array => zu schnell fertig :(


        int g2 = Math.max(x1,x2);
        int g4 = Math.max(x3,x4);
        int gg = Math.max(g2,g4);
        int max= Math.max(gg,x5);

        int q2 = Math.min(x1,x2);
        int q4 = Math.min(x3,x4);
        int qg = Math.min(q2,q4);
        int min= Math.min(qg,x5);

        int sumz=x1+x2+x3+x4+x5-max;
        int sumx= x1+x2+x3+x4+x5-min;

        System.out.printf("minimum sum: %d\nmaximum sum: %d",sumz,sumx);

        //System.out.printf();

        sc.close();
    }
}
