package StrukturiertJava;

import StrukturiertJava.Apps.*;

import java.util.Scanner;

public class Application {
    static Scanner sc = new Scanner(System.in);
    static int appValue;
    public static void main(String[] args) {
        while (true) {
            appText();
            System.out.println("Enter the number of the application you want to test: ");
                appValue = sc.nextInt();


            if (appValue == 1) {
                welcomeText();
                AlphabetWalker.main(args);
            } else if (appValue == 2) {
                welcomeText();
                AlphabetWalkerStackQueue.main(args);
            } else if(appValue ==3){
                welcomeText();
                ArbeitRelevantUmsaetze.main(args);
            } else if(appValue ==4){
                welcomeText();
                CodematchStick.main(args);
            } else if(appValue ==5){
                welcomeText();
                Diagonale.main(args);
            } else if(appValue ==6){
                welcomeText();
                DjikstraAlg.main(args);
            } else if(appValue ==7){
                welcomeText();
                DjikstraShortestPath.main(args);
            } else if(appValue ==8){
                welcomeText();
                FitnessAlg.main(args);
            } else if(appValue ==9){
                welcomeText();
                FitzQuack.main(args);
            } else if(appValue ==10){
                welcomeText();
                Frozen.main(args);
            } else if(appValue ==11){
                welcomeText();
                GameOfLife.main(args);
            } else if(appValue ==12){
                welcomeText();
                LoopMinIdx.main(args);
            } else if(appValue ==13){
                welcomeText();
                MinMaxSum.main(args);
            } else if(appValue ==14){
                welcomeText();
                NeatMultTable.main(args);
            } else if(appValue ==15){
                welcomeText();
                NumberPairs.main(args);
            } else if(appValue ==16){
                welcomeText();
                PartyHandshake.main(args);
            } else if(appValue ==17){
                welcomeText();
                RaupeFlitzi.main(args);
            } else if(appValue ==18){
                welcomeText();
                ReadGraph.main(args);
            } else if(appValue ==19){
                welcomeText();
                StackQueue.main(args);
            } else if(appValue ==20){
                welcomeText();
                StarWriter.main(args);
            } else if(appValue ==21){
                welcomeText();
                TicTacToe.main(args);
            } else {
                System.out.println("Please enter a valid number!");
            }
            break;

        }
    }

    private static void welcomeText() {
        System.out.println("------------------------------------------------------------");
        System.out.println("|Welcome to this Application!                               |");
        System.out.println("------------------------------------------------------------");
    }

    private static void appText() {
        System.out.println("Welcome to the application!");
        System.out.println("You can test the following Applications: (Practice Examples)");
        System.out.println("1. AlphabetWalker");
        System.out.println("2. AlphabetWalkerStackQueue");
        System.out.println("3. Umsätze");
        System.out.println("4. CodematchStick");
        System.out.println("5. Diagonale");
        System.out.println("6. DjikstraAlgorithmus");
        System.out.println("7. DjikstraShortestPath");
        System.out.println("8. FitnessAlgorithmus");
        System.out.println("9. FitzQuack");
        System.out.println("10. Frozen");
        System.out.println("11. Game of Life");
        System.out.println("12. LoopMinIdx");
        System.out.println("13. MinMaxSum");
        System.out.println("14. NeatMultTable");
        System.out.println("15. NumberPairs");
        System.out.println("16. PartyHandshake");
        System.out.println("17. RaupeFlitzi");
        System.out.println("18. ReadGraph");
        System.out.println("19. StackQueue");
        System.out.println("20. StarWriter");
        System.out.println("21. TicTacToe");
    }
}

