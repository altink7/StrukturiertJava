package StrukturiertJava.Apps;

import java.util.Scanner;

public class PartyHandshake {
    static Scanner sc;
    public static void main(String[] args) {
        System.out.println("anzahl der person, namen der personen, ausgabe:handshakes für alle personen");
        sc = new Scanner(System.in);
        System.out.print(": ");
        int n = sc.nextInt();
        String[] names = readNames(n);
        String[] handshakes = handShakes(names);
        print(handshakes);
        sc.close();
    }

    static String[]readNames(int n){
        String[] arr= new String[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.next();
        }
        return arr;
    }

    public static String[] handShakes(String[] names){
        int count =0;
        int idx=0;
        for(int y=names.length;y>0;y--){
            count+=y;
        }
        count=count-names.length;
        String[]handshakes= new String[count];

        for(int i=0;i<names.length-1;i++){

            for(int j=i;j< names.length-1;j++) {
                handshakes[idx]= names[i]+" -> "+ names[j+1];
                idx++;
            }
        }
        return handshakes;
    }
    public static void print(String[] stra){
        for (String s : stra) {
            System.out.println(s);
        }
    }
}
