package StrukturiertJava.Apps.console;

import java.util.Arrays;
import java.util.Scanner;

public class NumberPairs {
    public static void main(String[] args){
        System.out.println("Infos + Anleitung nebendatei(.pdf)");
        Scanner sc=new Scanner(System.in);
        System.out.print(": ");
        int Sequenzsum= sc.nextInt();
        int AnzahlPairs=1;
        int A1=1;

        int[] PaarValue= new int[Sequenzsum];

        for(int i=0; i< PaarValue.length;i++){
            PaarValue[i]=sc.nextInt();
        }
        if(Sequenzsum==2) Sequenzsum=1;
        else Sequenzsum-=1;

        int[][] doubleValue= new int[Sequenzsum][2];
        for(int f=0;f< doubleValue.length;f++){
            System.arraycopy(PaarValue, f, doubleValue[f], 0, 2);
        }
        bubble(doubleValue,0);


        for (int i=0;i< doubleValue.length;i++) {
            for (int j = 0; j < 2; j++) {
                if (j == 1){
                    AnzahlPairs=Compare(doubleValue,i,AnzahlPairs);
                    if(AnzahlPairs>1)Arrays.sort(doubleValue);
                    if(A1 ==Compare(doubleValue,i,AnzahlPairs)) AnzahlPairs = 1;
                    System.out.printf("(%d,%d): %d\n", doubleValue[i][0], doubleValue[i][1], AnzahlPairs);
                    A1 = AnzahlPairs;
                }
            }
        }


    }
    public static void bubble(int[][] numbers,int r) {//es wird eine reihe (r) sortiert
        boolean swapped;
        int i=0;
        do {
            swapped = false;
            for (int j = 1; j < numbers.length - i; j++){
                if (numbers[j - 1][r] > numbers[j][r]) {
                    swap(numbers, j - 1, j,r);
                    swapped = true;
                }
            }
            i++;
        } while (swapped);


    }

    private static void swap(int[][] numbers, int i, int j,int r) {//für X mal 2 reihen
        int tmp = numbers[i][r];
        if(r==0) {
            int tmpSecond = numbers[i][r + 1];
            numbers[i][r] = numbers[j][r];
            numbers[i][r + 1] = numbers[j][r + 1];
            numbers[j][r] = tmp;
            numbers[j][r + 1] = tmpSecond;
        }

    }

    public static int Compare(int[][]array, int zahl, int e_anzahl){
        int anzahl=e_anzahl;
        if (zahl> 0){
            if (array[zahl][0] == array[zahl -1][0]) {
                if (array[zahl][1] == array[zahl -1][1]) {
                    anzahl++;
                }

            }
            else{
                anzahl=1;
            }
        }

        return anzahl;
    }

}