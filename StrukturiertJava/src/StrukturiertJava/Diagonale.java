package StrukturiertJava;
import java.util.Scanner;

public class Diagonale {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt(); // Eingabezahl
        System.out.printf(": ");
        while(x%2==0 || x<1 ){ //Ungültige Zahlen Filtern
            System.out.printf(": ");
            x=sc.nextInt();
        }
        int fix=x; //Sterne von Links
        int m=x;   // Sterne von Rechts
        for(int n =x;n>0;n--){ // vertikale Achse

            for(int i=x;i>0;i--){//horizontale Achse
                System.out.print((fix-i==0)||(m-fix==i-1)?"*":"-");

            }
            System.out.printf("\n");// Zeilenumbruch nach jeder x
            fix--;
        }

        System.out.printf("");//nur zum Kopieren hier , keine Funktion daweil
        sc.close();
    }
}