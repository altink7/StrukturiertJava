package StrukturiertJava.Apps.console;
import java.util.Scanner;

public class Frozen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String frage;
        int index=7;
        System.out.println("Abfragespiel für disney inc. Poster im Anhang(Anleitung),+ yes, - no");

        while(index !=0) {
            if (index == 7) {
                Question winter = new Question();
                winter.text = "Winter?: ";
                System.out.print(winter.text);
                frage = sc.next();
                if (frage.equals("+")) {
                    winter.on_yes = 3;
                    index = 3;
                }
                if (frage.equals("-")) {
                    winter.on_no = 2;
                    index = 2;
                }
            }
            if (index == 2) {
                Question mutig = new Question();
                mutig.text = "Mutig?: ";
                System.out.print(mutig.text);
                frage = sc.next();
                if (frage.equals("+")) {
                    mutig.on_yes = 6;
                    index = 6;
                }
                if (frage.equals("-")) {
                    mutig.on_no = 5;
                    index = 5;
                }
            }
            if (index == 3) {
                Question allein = new Question();
                allein.text = "Allein?: ";
                System.out.print(allein.text);
                frage = sc.next();
                if (frage.equals("+")) {
                    allein.on_yes = 4;
                    index = 4;
                }
                if (frage.equals("-")) {
                    allein.on_no = 5;
                    index = 5;
                }
            }
            if (index == 4) {
                Question abenteuer = new Question();
                abenteuer.text = "Abenteuer?: ";
                System.out.print(abenteuer.text);
                frage = sc.next();
                if (frage.equals("+")) {
                    abenteuer.on_yes = 5;
                    index = 5;
                }
                if (frage.equals("-")) {
                    abenteuer.on_no = 0;
                    index = 0;
                    System.out.print("ELSA");
                }
            }

            if (index == 5) {
                Question rentiere = new Question();
                rentiere.text = "Rentiere?: ";
                System.out.print(rentiere.text);
                frage = sc.next();
                if (frage.equals("+")) {
                    rentiere.on_yes = 0;
                    index = 0;
                    System.out.print("ANNA");
                }
                if (frage.equals("-")) {
                    rentiere.on_no = 0;
                    index = 0;
                    System.out.print("ELSA");
                }
            }

            if (index == 6) {
                Question geheimnis = new Question();
                geheimnis.text = "Gehemnis?: ";
                System.out.print(geheimnis.text);
                frage = sc.next();
                if (frage.equals("+")) {
                    geheimnis.on_yes = 5;
                    index = 5;
                }
                if (frage.equals("-")) {
                    geheimnis.on_no = 0;
                    index = 0;
                    System.out.print("ANNA");
                }
            }

        }



    }
}
class Question {
    String text;
    int on_yes;
    int on_no;
}

