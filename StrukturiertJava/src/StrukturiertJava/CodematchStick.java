package StrukturiertJava;
import java.util.Scanner;

public class CodematchStick{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sticks = 30;
        int fixstick=sticks;
        int pcsticks = 30;
        int input=0;

        int sticks2 = 30;
        int fixstick2=sticks;
        int pcsticks2 = 30;
        int input2=0;

        System.out.println("Welcome to the matchstick game!");
        System.out.println("Please enter your name");
        String name = sc.next();
        System.out.println("Hello," + name + "!");
        System.out.println("Do you want to play against a computer(y/n)");
        String comp = sc.next();


        if (comp.equals("n")) {
            System.out.printf("Player 1 Sticks left:%d\n", sticks);
            while (sticks>0) {
                for (int i = 0; i < sticks; i++) {
                    System.out.printf("|");
                    System.out.print((i % 5 == 4) ? "  " : "");
                    fixstick--;


                }
                System.out.printf("\nPlayer 1 take 1-3 sticks:");
                input = sc.nextInt();
                while (input < 1 || input > 3) {
                    System.out.println("Bitte noch einmal versuchen:");
                    input = sc.nextInt();

                }
                for (int m=0;m<1;m++){
                    sticks=sticks-input;
                }

            }
            System.out.println("Yeahh, you won!!(0 Sticks left)");
        }

        else if(comp.equals("y")){

            while (sticks>0) {

                for (int j=0;j<1;j++) {

                    System.out.printf("Player 1 Sticks left:%d\n", sticks);
                    for (int i = 0; i < sticks; i++) {
                        System.out.printf("|");
                        System.out.print((i % 5 == 4) ? "  " : "");
                        fixstick--;


                    }
                    System.out.printf("\nPlayer 1 take 1-3 sticks:");
                    input = sc.nextInt();
                    while (input < 1 || input > 3) {
                        System.out.println("Bitte noch einmal versuchen:");
                        input = sc.nextInt();

                    }
                    for (int m = 0; m < 1; m++) {
                        sticks = sticks - input;
                    }
                }
                System.out.printf("\n\n");

                for (int k=0;k<1;k++) {
                    System.out.printf("Player 2 Sticks left:%d\n", sticks2);
                    for (int i1 = 0; i1 < sticks2; i1++) {
                        System.out.printf("|");
                        System.out.print((i1 % 5 == 4) ? "  " : "");
                        fixstick2--;


                    }
                    System.out.printf("\nPlayer 1 take 1-3 sticks:");
                    input2 = sc.nextInt();
                    while (input2 < 1 || input2 > 3) {
                        System.out.println("Bitte noch einmal versuchen:");
                        input2 = sc.nextInt();

                    }
                    for (int m1 = 0; m1 < 1; m1++) {
                        sticks2 = sticks2 - input2;
                    }

                }
                System.out.printf("\n\n");

                if (sticks2<1 && sticks >0){
                    System.out.println("Player 2 won!!");
                    break;
                }
                else if (sticks<1 && sticks2 >0){
                    System.out.println("Player 1 won!!");
                    break;
                }
                else if(sticks<1&& sticks2<1) {
                    System.out.println("It is a TIEEEE!!!");
                    break;
                }


            }


        }

    }
}