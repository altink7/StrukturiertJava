package StrukturiertJava;

import java.util.Scanner;

public class StarWriter {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print(": ");
        int x = sc.nextInt(); // Eingabezahl

        while(x%2==0 || x<1 ){ //Ungültige Zahlen Filtern
            System.out.print(": ");
            x=sc.nextInt();
        }

        int fix=x; //Sterne von Links
        int m=x;   // Sterne von Rechts

        for(int n =x;n>0;n--){ // vertikale Achse

            for(int i=x;i>0;i--){//horizontale Achse
                System.out.print((fix-i==0)||(m-fix==i-1)||i-1==m/2||n-1==m/2 ?"*":"-");

            }
            System.out.printf("\n");// Zeilenumbruch nach jeder x
            fix--;
        }

        System.out.printf("");//nur zum Kopieren hier , keine Funktion daweil
        sc.close();
    }
}
