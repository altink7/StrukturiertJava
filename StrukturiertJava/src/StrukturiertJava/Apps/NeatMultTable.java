package StrukturiertJava.Apps;
import java.util.Scanner;

public class NeatMultTable {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.print("enter rows:");
        int rows  =sc.nextInt(); // Rows intialisieren
        System.out.print(" enter columns:\n    ");
        int columns = sc.nextInt();// Columns intialisieren

        for(int i=1;i<=columns;i++){ // Columns oben
            System.out.printf("  %d",i);
        }
        System.out.print("\n----"); //der fixe Teil von Strichen
        for(int y=1;y<=columns;y++){    //der variable Teill von Strichen
            System.out.print("---");
        }

        System.out.print("\n");
        for(int r=1; r<=rows;r++){ // Rows beschriftung
            System.out.printf(" %d | ",r);

            for(int c=1;c<=columns;c++){ // columns beschriftung
                System.out.printf("%2d ",c*r);
            }
            System.out.print("\n");
        }
    }

}
