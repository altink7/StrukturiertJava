package StrukturiertJava;
import java.util.Objects;
import java.util.Scanner;


public class AlphabetWalker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int horizontal=0;
        int vertikal=0;
        int counter=0;
        int alphabetcounter=1;
        int A1=0;
        int A2=0;

        String[][] feld= new String [10][10];
        char[] alphabet = new char[26];
        char a = 65; //erster Buchstabe (großes A)
        for(int i = 0; i < alphabet.length; i++, a++) {
            alphabet[i] = a;
        }

        for(int i =0;i<10;i++){
            for(int j=0;j<10;j++){
                if(i==0 && j==0){
                    feld[i][j]="A";
                }
                else{
                    feld[i][j]=".";
                }
                System.out.print(feld[i][j]);
            }
            System.out.print("\n");
        }
        System.out.print("Enter direction command: \n" +
                "6->rechts, 8 rauf, 4<-links, 2 runter, 5 schliessen");
        int x =sc.nextInt();

        while(x!=5) {

            if(x==8) vertikal-=1;
            else if(x==4)horizontal-=1;
            else if(x==2)vertikal+=1;
            else if(x==6)horizontal+=1;

            if (x == 2 || x == 4 || x == 6 || x == 8) {

                if(horizontal>9||horizontal<0||vertikal<0||vertikal>9|| !Objects.equals(feld[vertikal][horizontal], ".")){
                    horizontal = A2;
                    vertikal = A1;
                    System.out.print("You cannot go there!\n");
                    System.out.print("Enter direction command: \n");
                    x = sc.nextInt();
                }
                else{
                    for (int k = 0; k < 10; k++) {
                        for (int l = 0; l < 10; l++) {
                            if(k == vertikal && l == horizontal && Objects.equals(feld[k][l], ".")){
                                feld[k][l]= String.valueOf(alphabet[alphabetcounter%26]);
                                alphabetcounter++;
                                A1= k;
                                A2=l;
                            }

                            counter++;
                            System.out.print(feld[k][l]);
                        }
                        System.out.print("\n");
                    }System.out.print("Enter direction command: \n");
                    x = sc.nextInt();

                }


            }
            else {
                System.out.print("Enter direction command: \n");
                x = sc.nextInt();
            }
        }
        sc.close();
    }
}
