package StrukturiertJava.Apps.console;

import java.util.Scanner;

public class FitnessAlg {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print(": ");
        System.out.println("1.Zahl: laufen in min, 2.Zahl gehen in min, und dann einen beliebigen Wert abfragen");

        int laufen = sc.nextInt();
        while(laufen<1){
            System.out.print(": ");
            laufen=sc.nextInt();
        }
        System.out.print(": ");
        int gehen = sc.nextInt();
        while(gehen<1){
            System.out.print(": ");
            gehen=sc.nextInt();
        }
        System.out.print(": ");
        int Abfrage = sc.nextInt();
        while(Abfrage>0){
            if(Abfrage%(laufen+gehen)>laufen||Abfrage%(laufen+gehen)==0){
                System.out.print("gehen");
            }
            else{
                System.out.print("laufen");
            }
            Abfrage=sc.nextInt();
        }




    }
}