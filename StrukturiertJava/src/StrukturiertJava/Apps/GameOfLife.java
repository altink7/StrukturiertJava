package StrukturiertJava.Apps;
import java.util.Scanner;

public class GameOfLife {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        char[][] field = createField();
        int counter=0;
        int x=1;
        System.out.println("Infos + Anleitung nebendatei(.pdf)");

        while (true) {
            String[] in = sc.nextLine().split(" ");
            if (Integer.parseInt(in[0])==-1)
                break;

            char sign = 'x';
            int row = Integer.parseInt(in[0]);
            int column = Integer.parseInt(in[1]);

            setSign(field, sign, row, column);
        }
        while(x>0){


            for (char[] chars : field) {
                for (int j = 0; j < field[0].length; j++) {
                    System.out.printf("%s", chars[j]);
                }
                System.out.println();
            }
            counter++;
            System.out.printf("(%06d):",counter);
            x=sc.nextInt();
        }

    }

    public static char[][] createField() {
        char[][] field = new char[32][32];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                field[i][j] = '.';
            }
        }
        return field;
    }
    public static void setSign(char[][] field, char sign, int row, int column) {
        if (row >= field.length || column >= field[0].length || field[row][column] != '.') return;

        field[row][column] = sign;
    }
}
