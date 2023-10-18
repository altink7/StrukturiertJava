package StrukturiertJava.Apps;
import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args){
        playGame();
    }

    public static char[][] createField() {
        System.out.println("Infos + Anleitung nebendatei(.pdf)");
        char[][] field = new char[3][3];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                field[i][j] = '_';
            }
        }
        return field;
    }

    public static void print(char[][] field) {
        for (char[] chars : field) {
            StringBuilder line = new StringBuilder("" + chars[0]);
            for (int j = 1; j < field[0].length; j++) {
                line.append(" ").append(chars[j]);
            }
            System.out.println(line);
        }
    }

    public static void playGame() {
        Scanner sc = new Scanner(System.in);
        char[][] field = createField();

        while (true) {
            String[] in = sc.nextLine().split(" ");
            if (in.length != 3)
                break;

            char sign = in[0].charAt(0);
            int row = Integer.parseInt(in[1]);
            int column = Integer.parseInt(in[2]);

            setSign(field, sign, row, column);
            if (checkWin(field))
                break;
        }

        print(field);


    }

    public static void setSign(char[][] field, char sign, int row, int column) {
        if (row >= field.length || column >= field[0].length || !(sign == 'X' || sign == 'O') || field[row][column] != '_')
            return;

        field[row][column] = sign;
    }

    public static boolean checkWin(char[][] field) {
        boolean check = false;
        int werhatGewonnen = 0;
        for (int i = 0; i < 3; i++) {
            if ((field[i][0] == 'X' && field[i][1] == 'X' && field[i][2] == 'X')
                    || (field[0][i] == 'X' && field[1][i] == 'X' && field[2][i] == 'X')
                    || (field[0][0] == 'X' && field[1][1] == 'X' && field[2][2] == 'X')
                    || (field[2][0] == 'X' && field[1][1] == 'X' && field[0][2] == 'X')) {
                check = true;
                werhatGewonnen = 1;
            } else if ((field[i][0] == 'O' && field[i][1] == 'O' && field[i][2] == 'O')
                    || (field[0][i] == 'O' && field[1][i] == 'O' && field[2][i] == 'O')
                    || (field[0][0] == 'O' && field[1][1] == 'O' && field[2][2] == 'O')
                    || (field[2][0] == 'O' && field[1][1] == 'O' && field[0][2] == 'O')) {
                check = true;
            }
        }

        if (check) {
            if (werhatGewonnen == 1) {
                System.out.printf("X wins!\n");
            } else {
                System.out.printf("O wins!\n");
            }
        }
        return check;
    }
}