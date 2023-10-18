package StrukturiertJava.Apps;
import javax.swing.text.Segment;
import java.util.Objects;
import java.util.Scanner;
import java.util.LinkedList;


public class RaupeFlitzi {
    public static void main(String[] args) {
        System.out.println("Infos + Anleitung nebendatei(.pdf)");
        int count=0;
        int alphabet_zahl=0;
        char[] alphabet = new char[26];
        char a = 65;
        for(int i = 0; i < alphabet.length; i++, a++) {
            alphabet[i] = a;
        }


        Scanner sc = new Scanner(System.in);
        // Funktionen
        LinkedList<String> createNode = new LinkedList<>();

        new Segment();
        System.out.print("Create:\n");


        while (true) {
            System.out.print(": ");
            String t = sc.next();

            if (t.equals("x"))
                break;
            createNode.add(t);
        }

        System.out.print("Action (p|g|d|s): ");
        String action;
        action = sc.next();

        switch (action) {
            case "p": /// Print
                for (String s : createNode) {
                    System.out.println("(" + s + ")");
                }
                break;
            case "g": /// GetAt
                int idx = sc.nextInt();
                if(idx >25||idx<0){
                    System.out.print("Index: Invalid index\n");
                }
                else {
                    System.out.printf("Index: (" + createNode.get(idx) + ")\n");
                }

                /// ...

                break;
            case "d": /// Delete
                int delete=0;
                System.out.print("Type: ");
                String remove = sc.next();
                //System.out.printf("\n");
                for(int i=0;i<createNode.size();i++) {
                    if (Objects.equals(createNode.get(i), remove)) {
                        delete = i;
                    }
                }
                createNode.remove(delete);



                /// ...
                break;
            case "s": // Sublist

                System.out.print("Type: ");
                String neuesB = sc.next();
                int AnzahlDerBuchtabe=0;
                for(int i=0;i<createNode.size();i++) {
                    if (Objects.equals(createNode.get(i), neuesB)) {
                        AnzahlDerBuchtabe= i;
                    }
                }
                for (int d = AnzahlDerBuchtabe; d < createNode.size(); d++) {
                    System.out.printf("(" + createNode.get(d) + ")\n");
                }

                /// ...
                break;
        }

        System.out.println();
        for (int j = 0; j < createNode.size(); j++) {
            for(int i=0;i <26;i++) {
                if (Objects.equals(String.valueOf(alphabet[i]), createNode.get(count))) {
                    alphabet_zahl = i;
                }
            }

            System.out.printf("%d.%d\n",count,alphabet_zahl);
            count++;
        }
    }
}
