package StrukturiertJava.Apps;
import java.util.Scanner;

public class LoopMinIdx {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Infos + Anleitung nebendatei(.pdf)");

        int n = sc.nextInt();
        int counter = 1;
        int zahl = 1;
        int A1 = 0;
        System.out.printf(": ");

        while (n>0){
            while(n >0){
                if (n==1){ zahl = counter;
                    A1 = 100; }

                System.out.printf(": ");
                n = sc.nextInt();
                counter++;

            }
            if(A1 == 100){System.out.printf("minIdx: %d\n",zahl);}

            else{System.out.printf("minIdx: %d\n",counter-1);}

        }
        System.out.println("End.");
        sc.close();
    }
}
